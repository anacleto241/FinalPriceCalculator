package source;

import java.util.Scanner;


public class FinalCalculator {
    public static void main(String[] args) {
        // Criando o scanner para receber a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados para o produto
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

        // Criando o produto com as informações fornecidas
        Product product = new Product(productName, productValue, freight, insurance);

        // Entrada de dados para o serviço
        scanner.nextLine(); // Consumir a nova linha pendente
        System.out.println("Insira a descrição do serviço:");
        String serviceDescription = scanner.nextLine();

        System.out.println("Insira o valor do serviço:");
        double serviceValue = scanner.nextDouble();

        // Entrada de cidade para calcular ISS
        System.out.println("Insira a cidade onde o serviço será prestado (Ex: Alfenas, Machado, Belo Horizonte):");
        scanner.nextLine(); // Consumir a nova linha
        String city = scanner.nextLine();

        System.out.println("Insira a margem de lucro para o serviço (Ex: 15 para 15%):");
        double serviceProfitMargin = scanner.nextDouble();

        // Criando o serviço com as informações fornecidas
        Service service = new Service(serviceDescription, serviceValue);

        // Instanciando o calculador de impostos
        TaxCalculator taxCalculator = new TaxCalculator();

        // Instanciando o calculador de preços
        PriceCalculator priceCalculator = new PriceCalculator(taxCalculator);

        // Calculando preço final do produto com margem de lucro
        double finalPriceProduct = priceCalculator.calculateFinalPriceProduct(product, originState, destinationState, productProfitMargin/100);

        // Calculando preço final do serviço com margem de lucro
        double finalPriceService = priceCalculator.calculateFinalPriceService(service, city, serviceProfitMargin/100);

        // Exibindo resultados
        System.out.println("Preço final do Produto (com margem de lucro): R$ " + finalPriceProduct);
        System.out.println("Preço final do Serviço (com margem de lucro): R$ " + finalPriceService);

        // Fechando o scanner
        scanner.close();
    }
}

