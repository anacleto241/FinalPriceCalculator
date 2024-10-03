package source;

import java.util.Scanner;


public class FinalCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Insira o nome do produto:");
        String productName = scanner.nextLine();

        System.out.println("Insira o valor do produto:");
        double productValue = scanner.nextDouble();

        System.out.println("Insira o valor do frete:");
        double freight = scanner.nextDouble();

        System.out.println("Insira o valor do seguro:");
        double insurance = scanner.nextDouble();

        System.out.println("Insira o estado de origem do produto (Ex: SP):");
        String originState = scanner.next().toUpperCase();

        System.out.println("Insira o estado de destino do produto (Ex: RJ):");
        String destinationState = scanner.next().toUpperCase();

        System.out.println("Insira a margem de lucro para o produto (Ex:10 para 10%):");
        double productProfitMargin = scanner.nextDouble();

        Product product = new Product(productName, productValue, freight, insurance);


        scanner.nextLine();
        System.out.println("Insira a descrição do serviço:");
        String serviceDescription = scanner.nextLine();

        System.out.println("Insira o valor do serviço:");
        double serviceValue = scanner.nextDouble();

        System.out.println("Insira a cidade onde o serviço será prestado (Ex: Alfenas, Machado, Belo Horizonte):");
        scanner.nextLine();
        String city = scanner.nextLine();

        System.out.println("Insira a margem de lucro para o serviço (Ex: 15 para 15%):");
        double serviceProfitMargin = scanner.nextDouble();

        Service service = new Service(serviceDescription, serviceValue);

        TaxCalculator taxCalculator = new TaxCalculator();

        PriceCalculator priceCalculator = new PriceCalculator(taxCalculator);

        double finalPriceProduct = priceCalculator.calculateFinalPriceProduct(product, originState, destinationState, productProfitMargin/100);

        double finalPriceService = priceCalculator.calculateFinalPriceService(service, city, serviceProfitMargin/100);

        System.out.println("Preço final do Produto (com margem de lucro): R$ " + finalPriceProduct);
        System.out.println("Preço final do Serviço (com margem de lucro): R$ " + finalPriceService);

        scanner.close();
    }
}

