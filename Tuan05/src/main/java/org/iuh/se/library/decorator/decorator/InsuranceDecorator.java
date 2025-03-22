package org.iuh.se.library.decorator.decorator;

import org.iuh.se.library.decorator.core.IBorrowable;

/**
 * Lớp InsuranceDecorator thêm tính năng bảo hiểm cho sách khi mượn
 * Đây là một concrete decorator trong mẫu thiết kế Decorator
 */
public class InsuranceDecorator extends BookDecorator {
    // Số tiền bảo hiểm
    private double insuranceAmount;

    /**
     * Constructor khởi tạo decorator với sách cần bảo hiểm và số tiền bảo hiểm
     * @param decoratedBook Sách cần bảo hiểm
     * @param insuranceAmount Số tiền bảo hiểm
     */
    public InsuranceDecorator(IBorrowable decoratedBook, double insuranceAmount) {
        super(decoratedBook);
        this.insuranceAmount = insuranceAmount;
    }

    /**
     * Ghi đè phương thức mượn sách để bổ sung thông tin về bảo hiểm
     * @return Thông tin về việc mượn sách có bảo hiểm
     */
    @Override
    public String borrow() {
        return decoratedBook.borrow() + " với bảo hiểm trị giá " + insuranceAmount + " đồng";
    }

    /**
     * Tính thêm phí bảo hiểm dựa trên số tiền bảo hiểm
     * @return Tổng phí mượn sách bao gồm phí bảo hiểm
     */
    @Override
    public double calculateBorrowingFee() {
        // Phí bảo hiểm là một tỷ lệ phần trăm của số tiền bảo hiểm
        return decoratedBook.calculateBorrowingFee() + (insuranceAmount * 0.1);
    }
}