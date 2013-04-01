package com.agile.spirit.logos.value;

import com.agile.spirit.logos.condition.Condition;

public interface ValueHandler {
   
    public Object handleLeftOperandValue(final Condition condition);
    
    public Object handleRightOperandValue(final Condition condition);
    
}
