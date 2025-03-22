package org.iuh.se.library.decorator.decorator;

import org.iuh.se.library.decorator.core.IBorrowable;

/**
 * Lớp ExtendedBorrowingDecorator mở rộng thời gian mượn sách
 * Đây là một concrete decorator trong mẫu thiết kế Decorator
 */
public class ExtendedBorrowingDecorator extends BookDecorator {
    // Số ngày gia hạn thêm
    private int additionalDays;

    /**
     * Constructor khởi tạo decorator với sách cần gia hạn và số ngày gia hạn
     * @param decoratedBook Sách cần gia hạn thời gian mượn
     * @param additionalDays Số ngày gia hạn thêm
     */
    public ExtendedBorrowingDecorator(IBorrowable decoratedBook, int additionalDays) {
        super(decoratedBook);
        this.additionalDays = additionalDays;
    }

    /**
     * Ghi đè phương thức mượn sách để bổ sung thông tin về thời gian gia hạn
     * @return Thông tin về việc mượn sách với thời gian gia hạn
     */
    @Override
    public String borrow() {
        return decoratedBook.borrow() + " với thời gian gia hạn thêm " + additionalDays + " ngày";
    }

    /**
     * Ghi đè phương thức tính phí mượn sách để tính thêm phí gia hạn
     * @return Tổng phí mượn sách bao gồm phí gia hạn
     */
    @Override
    public double calculateBorrowingFee() {
        // Phí phụ thu cho việc gia hạn thời gian mượn
        return decoratedBook.calculateBorrowingFee() + (additionalDays * 0.5);
    }

    /**
     * Ghi đè phương thức lấy thời gian mượn sách để tính cả thời gian gia hạn
     * @return Tổng số ngày được phép mượn bao gồm ngày gia hạn
     */
    @Override
    public int getBorrowingDays() {
        return decoratedBook.getBorrowingDays() + additionalDays;
    }
}