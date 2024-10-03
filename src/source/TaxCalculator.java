package source;

public class TaxCalculator {

    public double calculateIPI(Product product) {
        double baseValue = product.getBaseValue();
        return baseValue * 0.15 / 100; // IPI = 0,15% da base
    }

    public double calculateICMS(Product product, String originState, String destinationState) {
        double rate = getICMSRate(originState, destinationState);
        return product.getValue() * rate;
    }

    private double getICMSRate(String originState, String destinationState) {
        double rate;
        switch (originState) {
            case "SP":
                switch (destinationState) {
                    case "RJ":
                        rate = 0.12;
                        break;
                    case "DF":
                        rate = 0.07;
                        break;
                    default:
                        rate = 0.18;
                        break;
                }
                break;
            case "MG":
                switch (destinationState) {
                    case "RJ":
                        rate = 0.10;
                        break;
                    case "SP":
                        rate = 0.08;
                        break;
                    default:
                        rate = 0.18;
                        break;
                }
                break;
            default:
                rate = 0.18;
                break;
        }
        return rate;
    }

    public double calculateISS(Service service, String city) {
        double issRate = getISSRate(city);
        return service.getServiceValue() * issRate;
    }

    private double getISSRate(String city) {
        double rate;
        switch (city.toLowerCase()) {
            case "alfenas":
                rate = 0.05;
                break;
            case "machado":
                rate = 0.04;
                break;
            case "belo horizonte":
                rate = 0.03;
                break;
            case "sao paulo":
                rate = 0.05;
                break;
            case "campinas":
                rate = 0.04;
                break;
            case "macaé":
                rate = 0.03;
                break;
            case "brasilia":
                rate = 0.05;
                break;
            case "rio de janeiro":
                rate = 0.04;
                break;
            case "parati":
                rate = 0.03;
                break;
            default:
                rate = 0.06;
                break;
        }
        return rate;
    }
}
