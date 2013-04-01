package com.agile.spirit.logos.value;

import java.math.BigDecimal;

import com.agile.spirit.logos.condition.CalculationBasedCondition;
import com.agile.spirit.logos.condition.Condition;
import com.agile.spirit.logos.condition.SimpleCondition;
import com.agile.spirit.logos.datatype.HasDataType;

public abstract class AbstractValueHandler<T extends HasDataType> implements ValueHandler {

    @Override
    public Object handleLeftOperandValue(Condition condition) {
        final Object value;
        if (condition instanceof SimpleCondition<?>) {
            value = getLeftOperandValue((SimpleCondition<?>) condition);
        } else if (condition instanceof CalculationBasedCondition) {
            value = getLeftOperandValue((CalculationBasedCondition<?>) condition);
        } else {
            value = null;
        }
        return value;
    }

    @SuppressWarnings("unchecked")
    private Object getLeftOperandValue(final SimpleCondition<?> condition) {
        return retrieveValueFromOperand((T) condition.getOperand());
    }

    @SuppressWarnings("unchecked")
    private BigDecimal getLeftOperandValue(final CalculationBasedCondition<?> condition) {
        
        BigDecimal leftValue = (BigDecimal) retrieveValueFromOperand((T) condition.getLeftOperand());
        BigDecimal rightValue = (BigDecimal) retrieveValueFromOperand((T) condition.getRightOperand());
        if (leftValue == null || rightValue == null) {
            return null;
        }
        return condition.getCalculation().process(leftValue, rightValue);
    }

    abstract protected Object retrieveValueFromOperand(final T operand);

    @Override
    public Object handleRightOperandValue(final Condition condition) {
        final Object value;
        switch (condition.getComparaison()) {
        case EQUAL:
            value = condition.getEqualValue();
            break;
        case LESS_THAN:
        case LESS_THAN_OR_EQUAL:
            value = condition.getLowerLimit();
            break;
        case GREATER_THAN:
        case GREATER_THAN_OR_EQUAL:
            value = condition.getUpperLimit();
            break;
        default:
            value = null;
            break;
        }
        return value;
    }

}
