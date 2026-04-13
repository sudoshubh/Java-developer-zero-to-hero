package ruleEngine;

import static ruleEngine.Phone.OSType.ANDROID;

public class main {
    public static void main(String[] args) throws Exception {
    RuleEngine ruleEngine = new RuleEngine();
    ruleEngine.registerRule(new IPhone());
    ruleEngine.registerRule(new AndroidPhone());

    Phone androidPhone = new Phone(ANDROID);
    Phone phone = ruleEngine.rule(androidPhone);

        System.out.println("Output Phone: "+ phone);

    }
}
