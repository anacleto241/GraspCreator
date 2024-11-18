package view;

import model.PaymentMethod;
import model.Sale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sale sale = new Sale();
        sale.createSaleItem("at", 2);
        sale.createSaleItem("ff", 1);
        sale.createSaleItem("msa", 2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEscolha a forma de pagamento:");
        System.out.println("1. Cartão de Crédito (5% juros)");
        System.out.println("2. Cartão de Débito (sem juros)");
        System.out.println("3. Dinheiro/Pix (5% desconto)");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                sale.setPaymentMethod(PaymentMethod.CREDIT_CARD);
                break;
            case 2:
                sale.setPaymentMethod(PaymentMethod.DEBIT_CARD);
                break;
            case 3:
                sale.setPaymentMethod(PaymentMethod.CASH_PIX);
                break;
            default:
                System.out.println("Opção inválida! Usando Cartão de Débito por padrão.");
                sale.setPaymentMethod(PaymentMethod.DEBIT_CARD);
                break;
        }


        System.out.println("Itens da Venda:");
        for (Object item : sale.getItems()) 
            System.out.println(item);
        System.out.println(String.format("Forma de Pagamento: %s", sale.getPaymentMethod().getDescription()));
        System.out.println(String.format("Valor Total: R$ %.2f", sale.getTotal()));
        System.out.println(String.format("Valor a Pagar: R$ %.2f", sale.getAmountToPay()));
    }
}
