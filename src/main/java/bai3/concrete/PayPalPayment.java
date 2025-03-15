package bai3.concrete;

import bai3.core.BasicPayment;

/**
 * Phương thức thanh toán bằng PayPal
 */
public class PayPalPayment extends BasicPayment {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public double processPayment(double amount) {
        System.out.println("Kết nối đến tài khoản PayPal...");
        System.out.println("Đang thanh toán " + amount + " VND thông qua PayPal (" + email + ")");
        return super.processPayment(amount);
    }

    @Override
    public String getDescription() {
        return "Thanh toán PayPal (" + email + ")";
    }
}