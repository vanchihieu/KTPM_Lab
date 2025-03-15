package bai3.core;

import bai3.core.Payment;

/**
 * Lớp cơ sở cho các phương thức thanh toán cơ bản
 */
public abstract class BasicPayment implements Payment {
    @Override
    public double processPayment(double amount) {
        System.out.println("Đang xử lý thanh toán cơ bản: " + amount + " VND");
        return amount;
    }
}