package com.agile.spirit.logos.condition;

import com.agile.spirit.logos.datatype.DataType;
import com.agile.spirit.logos.datatype.HasDataType;

public class SimpleCondition<T extends HasDataType> extends Condition {

    protected T operand;

    @Override
    public DataType getDataType() {
        return operand.getDataType();
    }

    public T getOperand() {
        return operand;
    }

    public void setOperand(T operand) {
        this.operand = operand;
    }

}
