package bai3.system;

import bai3.core.Payment;

/**
 * Lớp hệ thống thanh toán
 */
public class PaymentSystem {
    private String merchantName;

    public PaymentSystem(String merchantName) {
        this.merchantName = merchantName;
    }

    public void processOrder(Payment paymentMethod, double amount, String orderDetails) {
        System.out.println("\n==== " + merchantName + " - XỬ LÝ ĐƠN HÀNG ====");
        System.out.println("Chi tiết đơn hàng: " + orderDetails);
        System.out.println("Phương thức thanh toán: " + paymentMethod.getDescription());
        System.out.println("Số tiền ban đầu: " + amount + " VND");

        System.out.println("\n--- Quá trình xử lý thanh toán ---");
        double finalAmount = paymentMethod.processPayment(amount);

        System.out.println("\n--- Kết quả thanh toán ---");
        System.out.println("Số tiền cuối cùng: " + finalAmount + " VND");
        System.out.println("Trạng thái: Thành công");
        System.out.println("================================\n");
    }
}