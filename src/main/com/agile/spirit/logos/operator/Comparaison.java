package com.agile.spirit.logos.operator;

import java.math.BigDecimal;
import java.util.Date;

public enum Comparaison {

    EQUAL {
        @Override
        public boolean compareBoolean(final Boolean leftValue, final Boolean rightValue) {
            return leftValue.equals(rightValue);
        }

        @Override
        public boolean compareBigDecimal(final BigDecimal leftValue, final BigDecimal rightValue) {
            return leftValue.equals(rightValue);
        }

        @Override
        public boolean compareString(final String leftValue, final String rightValue) {
            return leftValue.compareTo(rightValue) == 0;
        }

        @Override
        public boolean compareDate(final Date leftValue, final Date rightValue) {
            // TODO Auto-generated method stub
            return false;
        }
    },

    LESS_THAN {
        @Override
        public boolean compareString(final String leftValue, final String rightValue) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean compareBigDecimal(final BigDecimal leftValue, final BigDecimal rightValue) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean compareDate(final Date leftValue, final Date rightValue) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean compareBoolean(Boolean leftValue, Boolean rightValue) {
            // TODO Auto-generated method stub
            return false;
        }
    },

    LESS_THAN_OR_EQUAL {
        @Override
        public boolean compareString(final String leftValue, final String rightValue) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean compareBigDecimal(final BigDecimal leftValue, final BigDecimal rightValue) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean compareDate(final Date leftValue, final Date rightValue) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean compareBoolean(Boolean leftValue, Boolean rightValue) {
            // TODO Auto-generated method stub
            return false;
        }
    },

    GREATER_THAN {
        @Override
        public boolean compareString(final String leftValue, final String rightValue) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean compareBigDecimal(final BigDecimal leftValue, final BigDecimal rightValue) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean compareDate(final Date leftValue, final Date rightValue) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean compareBoolean(Boolean leftValue, Boolean rightValue) {
            // TODO Auto-generated method stub
            return false;
        }
    },

    GREATER_THAN_OR_EQUAL {
        @Override
        public boolean compareString(final String leftValue, final String rightValue) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean compareBigDecimal(final BigDecimal leftValue, final BigDecimal rightValue) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean compareDate(final Date leftValue, final Date rightValue) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean compareBoolean(Boolean leftValue, Boolean rightValue) {
            // TODO Auto-generated method stub
            return false;
        }
    };

    abstract public boolean compareBoolean(final Boolean leftValue, final Boolean rightValue);

    abstract public boolean compareString(final String leftValue, final String rightValue);

    abstract public boolean compareBigDecimal(final BigDecimal leftValue, final BigDecimal rightValue);

    abstract public boolean compareDate(final Date leftValue, final Date rightValue);
    
}
