package ruleEngine;

public class Phone {

    private String model;
    private OSType osType;
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", osType=" + osType +
                '}';
    }

    public Phone(OSType osType) {
        this.osType = osType;
    }

    enum OSType{
        ANDROID, IOS;
    }

    public OSType getOsType() {
        return osType;
    }
    public Phone() {
    }
}
