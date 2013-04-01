package com.agile.spirit.logos.example;

import com.agile.spirit.logos.value.AbstractValueHandler;

public class QuestionValueHandler extends AbstractValueHandler<Question> {

    private final Questionnaire questionnaire;
    
    public QuestionValueHandler(final Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    @Override
    protected Object retrieveValueFromOperand(Question operand) {
        if (operand instanceof Question) {
            return questionnaire.getAnswserValueFromQuestion((Question) operand);
        }
        return null;
    }
    

}
