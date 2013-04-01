package com.agile.spirit.logos.example;

import java.math.BigDecimal;
import java.util.List;

import com.agile.spirit.logos.ConditionEngine;

public class CalculationEngine {

    final private ConditionEngine conditionEngine;

    public CalculationEngine(final ConditionEngine conditionEngine) {
        this.conditionEngine = conditionEngine;
    }

    public CalculationResult process(final List<CalculationRule> rules) {
        CalculationResult result = CalculationResult.create(Outcome.ACCEPTED, BigDecimal.ZERO);
        for (CalculationRule rule : rules) {
            result = result.add(process(rule));
        }
        return result;
    }

    private CalculationResult process(final CalculationRule rule) {
        boolean conditionsValidated = conditionEngine.process(rule.getConditions());
        if (conditionsValidated) {
            return rule.getResult();
        }
        return CalculationResult.create(Outcome.ACCEPTED, BigDecimal.ZERO);
    }

}
