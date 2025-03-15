package bai3.decorator;

import bai3.core.Payment;

/**
 * Decorator để xử lý thanh toán quốc tế với phí chuyển đổi tiền tệ
 */
public class InternationalPaymentDecorator extends PaymentDecorator {
    private String currency;
    private double exchangeRate;

    public InternationalPaymentDecorator(Payment payment, String currency, double exchangeRate) {
        super(payment);
        this.currency = currency;
        this.exchangeRate = exchangeRate;
    }

    @Override
    public double processPayment(double amount) {
        double foreignAmount = amount / exchangeRate;
        System.out.println("Chuyển đổi tiền tệ: " + amount + " VND = "
                + String.format("%.2f", foreignAmount) + " " + currency);
        System.out.println("Áp dụng phí giao dịch quốc tế");
        return wrappedPayment.processPayment(amount);
    }

    @Override
    public String getDescription() {
        return wrappedPayment.getDescription() + " + Thanh toán quốc tế (" + currency + ")";
    }
}