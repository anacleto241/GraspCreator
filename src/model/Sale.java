package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private List<SaleItem> items = new ArrayList<>();
    private PaymentMethod paymentMethod;

    public void createSaleItem(String code, int quantity) {
        SaleItem item = new SaleItem();
        item.createProduct(code, quantity);
        items.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (SaleItem saleItem : items) 
            total += saleItem.getSubtotal();
        return total;
    }

    public double getAmountToPay() {
        double total = getTotal();
        if (paymentMethod == PaymentMethod.CREDIT_CARD) {
            return total * 1.05;
        } else if (paymentMethod == PaymentMethod.CASH_PIX) {
            return total * 0.95;
        }
        return total;
    }

    public void setPaymentMethod(PaymentMethod method) {
        this.paymentMethod = method;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public List<String> getItems() {
        List<String> itemsStr = new ArrayList<>();
        for (SaleItem saleItem : items) 
            itemsStr.add(saleItem.toString());
        return itemsStr;
    }
}
