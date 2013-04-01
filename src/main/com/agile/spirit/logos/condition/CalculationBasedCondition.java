package com.agile.spirit.logos.condition;

import com.agile.spirit.logos.datatype.DataType;
import com.agile.spirit.logos.datatype.HasDataType;
import com.agile.spirit.logos.operator.Calculation;

public class CalculationBasedCondition<T extends HasDataType> extends Condition {

    protected Calculation calculation;
    protected T leftOperand;
    protected T rightOperand;

    @Override
    public DataType getDataType() {
        if (leftOperand.getDataType() == rightOperand.getDataType()) {
            return leftOperand.getDataType();
        }
        return DataType.TEXT;
    }

    /*
     * 
     */

    public Calculation getCalculation() {
        return calculation;
    }

    public void setCalculation(Calculation calculation) {
        this.calculation = calculation;
    }

    public T getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(T leftOperand) {
        this.leftOperand = leftOperand;
    }

    public T getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(T rightOperand) {
        this.rightOperand = rightOperand;
    }

}
