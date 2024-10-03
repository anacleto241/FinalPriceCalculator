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
                        rate = 0.12; // 12% SP -> RJ
                        break;
                    case "DF":
                        rate = 0.07; // 7% SP -> DF
                        break;
                    default:
                        rate = 0.18; // Taxa padrão para outros estados
                        break;
                }
                break;
            case "MG":
                switch (destinationState) {
                    case "RJ":
                        rate = 0.10; // Exemplo de 10% MG -> RJ
                        break;
                    case "SP":
                        rate = 0.08; // Exemplo de 8% MG -> SP
                        break;
                    default:
                        rate = 0.18; // Taxa padrão para outros estados
                        break;
                }
                break;
            default:
                rate = 0.18; // Taxa padrão para outros estados
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
                rate = 0.05; // 5% para Alfenas
                break;
            case "machado":
                rate = 0.04; // 4% para Machado
                break;
            case "belo horizonte":
                rate = 0.03; // 3% para Belo Horizonte
                break;
            default:
                rate = 0.06; // Taxa padrão para outras cidades
                break;
        }
        return rate;
    }
}
