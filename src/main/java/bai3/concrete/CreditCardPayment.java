package bai3.concrete;

import bai3.core.BasicPayment;

/**
 * Phương thức thanh toán bằng thẻ tín dụng
 */
public class CreditCardPayment extends BasicPayment {
    private String cardNumber;
    private String cardholderName;

    public CreditCardPayment(String cardNumber, String cardholderName) {
        this.cardNumber = cardNumber;
        this.cardholderName = cardholderName;
    }

    @Override
    public double processPayment(double amount) {
        System.out.println("Xác thực thông tin thẻ tín dụng...");
        System.out.println("Đang thanh toán " + amount + " VND bằng thẻ tín dụng "
                + getMaskedCardNumber());
        return super.processPayment(amount);
    }

    @Override
    public String getDescription() {
        return "Thanh toán thẻ tín dụng (" + getMaskedCardNumber() + ")";
    }

    private String getMaskedCardNumber() {
        // Hiển thị chỉ 4 số cuối của thẻ
        return "xxxx-xxxx-xxxx-" + cardNumber.substring(cardNumber.length() - 4);
    }
}