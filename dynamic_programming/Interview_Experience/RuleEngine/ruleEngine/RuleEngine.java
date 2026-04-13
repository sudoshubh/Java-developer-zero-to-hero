package ruleEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RuleEngine {

    List<RuleI<Phone,Phone>> rules;

    public RuleEngine(){
        rules = new ArrayList<>();
    }
    public Phone rule(Phone phone) throws Exception {
        return     rules.stream()
                        .filter(rule -> rule.matches(phone))
                        .map(rule -> rule.process(phone))
                        .findFirst()
                        .orElseThrow(() -> new Exception("No Matching rule Found"));
    }
    public RuleEngine registerRule(RuleI<Phone,Phone> rule){
        rules.add(rule);
        return this;
    }
}
