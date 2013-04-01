package com.agile.spirit.logos.example;

import java.math.BigDecimal;

public class CalculationResult {

    private Outcome outcome;
    private BigDecimal majoration;
    
    private CalculationResult() {
        // Empty constructor
    }
    
    public static CalculationResult create(final Outcome outcome, final BigDecimal majoration) {
        CalculationResult result = new CalculationResult();
        result.outcome = outcome;
        result.majoration = majoration;
        return result;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public BigDecimal getMajoration() {
        return majoration;
    }

    public CalculationResult add(final CalculationResult other) {
        if (other == null) {
            return create(this.getOutcome(), this.getMajoration());
        }
        if (this.outcome == Outcome.REJECTED) {
            return create(Outcome.REJECTED, BigDecimal.ZERO);
        }
        if (other.outcome == Outcome.REJECTED) {
            return create(Outcome.REJECTED, BigDecimal.ZERO);
        }
        if (this.outcome == Outcome.PENDED) {
            return create(Outcome.PENDED, BigDecimal.ZERO);
        }
        if (other.outcome == Outcome.PENDED) {
            return create(Outcome.PENDED, BigDecimal.ZERO);
        }
        final BigDecimal majoration = this.majoration.add(other.majoration);
        final CalculationResult result = create(Outcome.ACCEPTED, majoration);
        return result;
    }
    
}
