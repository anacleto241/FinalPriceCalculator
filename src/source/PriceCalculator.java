package source;

public class PriceCalculator {
    private TaxCalculator taxCalculator;

    public PriceCalculator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public double calculateFinalPriceProduct(Product product, String originState, String destinationState, double profitMargin) {
        double ipi = taxCalculator.calculateIPI(product);
        double icms = taxCalculator.calculateICMS(product, originState, destinationState);

        double priceWithTaxes = product.getValue() + ipi + icms;

        return priceWithTaxes * (1 + profitMargin);
    }

    public double calculateFinalPriceService(Service service, String city, double profitMargin) {
        double iss = taxCalculator.calculateISS(service, city);

        double priceWithTaxes = service.getServiceValue() + iss;

        return priceWithTaxes * (1 + profitMargin);
    }
}
