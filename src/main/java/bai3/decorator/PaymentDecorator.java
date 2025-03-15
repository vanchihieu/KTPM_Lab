package bai3.decorator;

import bai3.core.Payment;

/**
 * Lớp decorator cơ sở cho các tính năng thanh toán bổ sung
 */
public abstract class PaymentDecorator implements Payment {
    protected Payment wrappedPayment;

    public PaymentDecorator(Payment payment) {
        this.wrappedPayment = payment;
    }

    @Override
    public double processPayment(double amount) {
        return wrappedPayment.processPayment(amount);
    }

    @Override
    public String getDescription() {
        return wrappedPayment.getDescription();
    }
}