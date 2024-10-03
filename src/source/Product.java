package source;

public class Product {
    private String name;
    private double value;
    private double freight;
    private double insurance;
    
    public Product(String name, double value, double freight, double insurance) {
        this.name = name;
        this.value = value;
        this.freight = freight;
        this.insurance = insurance;
    }
    
    public double getBaseValue() {
        return value + freight + insurance;
    }
    
    public double getValue() {
        return value;
    }
}