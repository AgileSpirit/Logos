package com.agile.spirit.logos.condition;

import java.math.BigDecimal;

import com.agile.spirit.logos.datatype.DataType;
import com.agile.spirit.logos.operator.Comparaison;

public abstract class Condition {

    protected Comparaison comparaison;
    protected Object equalValue;
    protected BigDecimal lowerLimit;
    protected BigDecimal upperLimit;
    protected boolean lowerInclude;
    protected boolean upperInclude;

    abstract public DataType getDataType();
    
    /*
     * 
     */

    public Comparaison getComparaison() {
        return comparaison;
    }

    public void setComparaison(Comparaison comparaison) {
        this.comparaison = comparaison;
    }

    public Object getEqualValue() {
        return equalValue;
    }

    public void setEqualValue(Object equalValue) {
        this.equalValue = equalValue;
    }

    public BigDecimal getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(BigDecimal lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public BigDecimal getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(BigDecimal upperLimit) {
        this.upperLimit = upperLimit;
    }

    public boolean isLowerInclude() {
        return lowerInclude;
    }

    public void setLowerInclude(boolean lowerInclude) {
        this.lowerInclude = lowerInclude;
    }

    public boolean isUpperInclude() {
        return upperInclude;
    }

    public void setUpperInclude(boolean upperInclude) {
        this.upperInclude = upperInclude;
    }

}
