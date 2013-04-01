package com.agile.spirit.logos.value;

import com.agile.spirit.logos.datatype.HasDataType;

public class DefaultValueHandler extends AbstractValueHandler<HasDataType> {

    @Override
    protected Object retrieveValueFromOperand(HasDataType operand) {
        return operand;
    }

}
