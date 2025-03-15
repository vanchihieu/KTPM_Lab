package bai3.decorator;

import bai3.core.Payment;

/**
 * Decorator để thêm phí xử lý vào phương thức thanh toán
 */
public class ProcessingFeeDecorator extends PaymentDecorator {
    private double feeRate;

    public ProcessingFeeDecorator(Payment payment, double feeRate) {
        super(payment);
        this.feeRate = feeRate;
    }

    @Override
    public double processPayment(double amount) {
        double processingFee = amount * feeRate;
        System.out.println("Thêm phí xử lý " + processingFee + " VND (" + (feeRate * 100) + "%)");
        return wrappedPayment.processPayment(amount + processingFee);
    }

    @Override
    public String getDescription() {
        return wrappedPayment.getDescription() + " + Phí xử lý (" + (feeRate * 100) + "%)";
    }
}