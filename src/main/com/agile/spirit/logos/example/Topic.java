package com.agile.spirit.logos.example;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    private String title;
    private List<Question> questions;
    private List<CalculationRule> rules;
    
    private Topic() {
        // Empty constructor
    }

    private Topic(String title) {
        this.title = title;
    }
    
    public static Topic create() {
        Topic topic = new Topic();
        topic.questions = new ArrayList<Question>();
        topic.rules = new ArrayList<CalculationRule>();
        return topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<CalculationRule> getRules() {
        return rules;
    }

    public void setRules(List<CalculationRule> rules) {
        this.rules = rules;
    }
    
}
