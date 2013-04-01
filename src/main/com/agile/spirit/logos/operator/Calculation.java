package com.agile.spirit.logos.operator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public enum Calculation {

    PRODUCT {
        @Override
        public BigDecimal process(final BigDecimal leftValue, final BigDecimal rightValue) {
            return leftValue.multiply(rightValue, mc);
        }
    },
    SUM {
        @Override
        public BigDecimal process(final BigDecimal leftValue, final BigDecimal rightValue) {
            return leftValue.add(rightValue, mc);
        }
    },
    SUBTRACTION {
        @Override
        public BigDecimal process(final BigDecimal leftValue, final BigDecimal rightValue) {
            return leftValue.subtract(rightValue, mc);
        }
    },
    DIVISION {
        @Override
        public BigDecimal process(final BigDecimal leftValue, final BigDecimal rightValue) {
            return leftValue.divide(rightValue, mc);
        }
    },
    IMC {
        @Override
        public BigDecimal process(final BigDecimal leftValue, final BigDecimal rightValue) {
            final BigDecimal imc = leftValue.divide((rightValue.pow(2, mc)), mc);
            return imc;
        }
    };

    private static MathContext mc = new MathContext(6, RoundingMode.HALF_UP);

    public abstract BigDecimal process(final BigDecimal leftValue, final BigDecimal rightValue);

}
