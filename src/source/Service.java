package source;

public class Service {
    private String description;
    private double serviceValue;
    
    public Service(String description, double serviceValue) {
        this.description = description;
        this.serviceValue = serviceValue;
    }
    
    public double getServiceValue() {
        return serviceValue;
    }
}
