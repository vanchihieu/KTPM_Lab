package bai3.core;

/**
 * Interface Payment định nghĩa giao diện cơ bản cho tất cả các phương thức thanh toán
 */
public interface Payment {
    /**
     * Thực hiện thanh toán với số tiền đã cho
     * @param amount Số tiền cần thanh toán
     * @return Số tiền thực tế được thanh toán sau khi áp dụng các tính năng bổ sung
     */
    double processPayment(double amount);

    /**
     * Lấy mô tả về phương thức thanh toán và các tính năng của nó
     * @return Chuỗi mô tả phương thức thanh toán
     */
    String getDescription();
}