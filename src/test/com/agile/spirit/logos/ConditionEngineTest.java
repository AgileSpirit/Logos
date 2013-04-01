package com.agile.spirit.logos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.agile.spirit.logos.ConditionEngine;
import com.agile.spirit.logos.condition.CalculationBasedCondition;
import com.agile.spirit.logos.condition.SimpleCondition;
import com.agile.spirit.logos.datatype.DataType;
import com.agile.spirit.logos.datatype.HasDataType;
import com.agile.spirit.logos.operator.Calculation;
import com.agile.spirit.logos.operator.Comparaison;
import com.agile.spirit.logos.value.AbstractValueHandler;

public class ConditionEngineTest {

    private final ConditionEngine engine = new ConditionEngine(new ValueObjectHandler());

    private class ValueObject implements HasDataType {
        private Object data;
        private DataType dataType;

        ValueObject(final Object data, final DataType dataType) {
            this.data = data;
            this.dataType = dataType;
        }

        Object getData() {
            return this.data;
        }

        @Override
        public DataType getDataType() {
            return dataType;
        }
    }
    
    private class ValueObjectHandler extends AbstractValueHandler<ValueObject> {

        @Override
        protected Object retrieveValueFromOperand(ValueObject operand) {
            return operand.getData();
        }
        
    }

    @Test
    public void processSimpleConditionEqualText() {
        SimpleCondition<ValueObject> c = new SimpleCondition<ValueObject>();
        c.setComparaison(Comparaison.EQUAL);
        c.setEqualValue("Foo");
        c.setOperand(new ValueObject("Foo", DataType.TEXT));
        assertTrue(engine.process(c));

        c.setOperand(new ValueObject("Bar", DataType.TEXT));
        assertFalse(engine.process(c));
    }

    @Test
    public void processSimpleConditionEqualBoolean() {
        SimpleCondition<ValueObject> c = new SimpleCondition<ValueObject>();
        c.setComparaison(Comparaison.EQUAL);
        c.setEqualValue(Boolean.TRUE);
        c.setOperand(new ValueObject(Boolean.TRUE, DataType.BOOLEAN));
        assertTrue(engine.process(c));

        c.setOperand(new ValueObject(Boolean.FALSE, DataType.BOOLEAN));
        assertFalse(engine.process(c));
    }

    @Test
    public void processSimpleConditionEqualNumber() {
        SimpleCondition<ValueObject> c = new SimpleCondition<ValueObject>();
        c.setComparaison(Comparaison.EQUAL);
        c.setEqualValue(BigDecimal.valueOf(100));
        c.setOperand(new ValueObject(BigDecimal.valueOf(100), DataType.NUMBER));
        assertTrue(engine.process(c));

        c.setOperand(new ValueObject(BigDecimal.valueOf(200), DataType.NUMBER));
        assertFalse(engine.process(c));
    }

    @Test
    public void processCalculatonConditionEqualNumber() {
        CalculationBasedCondition<ValueObject> c = new CalculationBasedCondition<ValueObject>();
        c.setComparaison(Comparaison.EQUAL);
        c.setCalculation(Calculation.PRODUCT);
        c.setEqualValue(BigDecimal.valueOf(500));
        c.setLeftOperand(new ValueObject(BigDecimal.valueOf(100), DataType.NUMBER));
        c.setRightOperand(new ValueObject(BigDecimal.valueOf(5), DataType.NUMBER));
        assertTrue(engine.process(c));

        c.setRightOperand(new ValueObject(BigDecimal.valueOf(6), DataType.NUMBER));
        assertFalse(engine.process(c));
    }
}
