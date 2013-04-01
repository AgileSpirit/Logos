package com.agile.spirit.logos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.agile.spirit.logos.condition.Condition;
import com.agile.spirit.logos.datatype.DataType;
import com.agile.spirit.logos.operator.Comparaison;
import com.agile.spirit.logos.value.DefaultValueHandler;
import com.agile.spirit.logos.value.ValueHandler;

public class ConditionEngine {

    private ValueHandler valueHandler = new DefaultValueHandler();

    public ConditionEngine() {
        // Empty constructor
    }

    public ConditionEngine(final ValueHandler valueHandler) {
        this.valueHandler = valueHandler;
    }

    public boolean process(List<Condition> conditions) {
        for (Condition condition : conditions) {
            if (process(condition) == false) {
                return false;
            }
        }
        return true;
    }

    public boolean process(Condition condition) {
        Comparaison comparaison = condition.getComparaison();
        Object leftOperandValue = valueHandler.handleLeftOperandValue(condition);
        Object rightOperandValue = valueHandler.handleRightOperandValue(condition);

        boolean result = false;
        DataType dataType = condition.getDataType();
        switch (dataType) {
        case BOOLEAN: {
            Boolean leftValue = (Boolean) leftOperandValue;
            Boolean rightValue = (Boolean) rightOperandValue;
            if (leftValue != null && rightValue != null) {
                result = comparaison.compareBoolean(leftValue, rightValue);
            }
            break;
        }
        case TEXT: {
            String leftValue = (String) leftOperandValue;
            String rightValue = (String) rightOperandValue;
            if (leftValue != null && rightValue != null) {
                result = comparaison.compareString(leftValue, rightValue);
            }
            break;
        }
        case NUMBER: {
            BigDecimal leftValue = (BigDecimal) leftOperandValue;
            BigDecimal rightValue = (BigDecimal) rightOperandValue;
            if (leftValue != null && rightValue != null) {
                result = comparaison.compareBigDecimal(leftValue, rightValue);
            }
            break;
        }
        case DATE: {
            Date leftValue = (Date) leftOperandValue;
            Date rightValue = (Date) rightOperandValue;
            if (leftValue != null && rightValue != null) {
                result = comparaison.compareDate(leftValue, rightValue);
            }
            break;
        }
        default:
            break;
        }
        return result;
    }

}
