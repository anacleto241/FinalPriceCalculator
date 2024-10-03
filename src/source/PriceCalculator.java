package source;

public class PriceCalculator {
    private TaxCalculator taxCalculator;

    public PriceCalculator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public double calculateFinalPriceProduct(Product product, String originState, String destinationState, double profitMargin) {
        double ipi = taxCalculator.calculateIPI(product);
        double icms = taxCalculator.calculateICMS(product, originState, destinationState);

        // Preço final com impostos
        double priceWithTaxes = product.getValue() + ipi + icms;

        // Aplicar margem de lucro
        return priceWithTaxes * (1 + profitMargin);
    }

    public double calculateFinalPriceService(Service service, String city, double profitMargin) {
        double iss = taxCalculator.calculateISS(service, city);

        // Preço final com impostos
        double priceWithTaxes = service.getServiceValue() + iss;

        // Aplicar margem de lucro
        return priceWithTaxes * (1 + profitMargin);
    }
}
