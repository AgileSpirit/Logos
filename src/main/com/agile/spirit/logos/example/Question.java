package com.agile.spirit.logos.example;

import com.agile.spirit.logos.datatype.DataType;
import com.agile.spirit.logos.datatype.HasDataType;

public class Question implements HasDataType {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public DataType getDataType() {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    
}
