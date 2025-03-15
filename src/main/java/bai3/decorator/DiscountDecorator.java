package bai3.decorator;

import bai3.core.Payment;

/**
 * Decorator để áp dụng mã giảm giá vào phương thức thanh toán
 */
public class DiscountDecorator extends PaymentDecorator {
    private String discountCode;
    private double discountRate;

    public DiscountDecorator(Payment payment, String discountCode, double discountRate) {
        super(payment);
        this.discountCode = discountCode;
        this.discountRate = discountRate;
    }

    @Override
    public double processPayment(double amount) {
        double discountAmount = amount * discountRate;
        System.out.println("Áp dụng mã giảm giá " + discountCode + ": -" + discountAmount + " VND ("
                + (discountRate * 100) + "%)");
        return wrappedPayment.processPayment(amount - discountAmount);
    }

    @Override
    public String getDescription() {
        return wrappedPayment.getDescription() + " + Mã giảm giá " + discountCode + " ("
                + (discountRate * 100) + "%)";
    }
}