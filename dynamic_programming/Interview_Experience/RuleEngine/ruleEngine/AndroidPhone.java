package ruleEngine;

public class AndroidPhone implements RuleI<Phone, Phone>{

    @Override
    public boolean matches(Phone input){
        return input.getOsType().equals(Phone.OSType.ANDROID);
    }
    @Override
    public Phone process(Phone input){
        input.setModel("Samsung S22");
        return input;
    }

}
