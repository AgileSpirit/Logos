package com.agile.spirit.logos.example;

import java.math.BigDecimal;
import java.util.List;

import com.agile.spirit.logos.condition.Condition;

public class CalculationRule {

    private List<Condition> conditions;
    private CalculationResult result;

    private CalculationRule() {
        // Empty constructor
    }

    public static CalculationRule create(final List<Condition> conditions, final Outcome outcome, final BigDecimal majoration) {
        CalculationRule rule = new CalculationRule();
        rule.conditions = conditions;
        rule.result = CalculationResult.create(outcome, majoration);
        return rule;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public CalculationResult getResult() {
        return result;
    }

    public void setResult(CalculationResult result) {
        this.result = result;
    }

}
