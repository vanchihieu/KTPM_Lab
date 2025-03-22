package org.iuh.se.library.decorator.decorator;

import org.iuh.se.library.decorator.core.IBorrowable;

/**
 * Lớp BookDecorator là lớp Decorator trừu tượng
 * Lớp này bọc các đối tượng IBorrowable và chuyển tiếp các phương thức đến đối tượng bị bọc
 */
public abstract class BookDecorator implements IBorrowable {
    // Đối tượng sách được trang trí
    protected IBorrowable decoratedBook;

    /**
     * Constructor khởi tạo decorator với sách cần được trang trí
     * @param decoratedBook Sách cần được trang trí thêm tính năng
     */
    public BookDecorator(IBorrowable decoratedBook) {
        this.decoratedBook = decoratedBook;
    }

    /**
     * Chuyển tiếp phương thức mượn sách đến đối tượng bị bọc
     * @return Thông tin về việc mượn sách
     */
    @Override
    public String borrow() {
        return decoratedBook.borrow();
    }

    /**
     * Chuyển tiếp phương thức tính phí mượn sách đến đối tượng bị bọc
     * @return Phí mượn sách
     */
    @Override
    public double calculateBorrowingFee() {
        return decoratedBook.calculateBorrowingFee();
    }

    /**
     * Chuyển tiếp phương thức lấy thời gian mượn sách đến đối tượng bị bọc
     * @return Số ngày được phép mượn
     */
    @Override
    public int getBorrowingDays() {
        return decoratedBook.getBorrowingDays();
    }
}