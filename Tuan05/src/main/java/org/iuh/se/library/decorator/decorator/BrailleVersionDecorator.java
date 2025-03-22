package org.iuh.se.library.decorator.decorator;

import org.iuh.se.library.decorator.core.IBorrowable;

/**
 * Lớp BrailleVersionDecorator cung cấp sách ở dạng chữ nổi Braille
 * Đây là một concrete decorator trong mẫu thiết kế Decorator
 */
public class BrailleVersionDecorator extends BookDecorator {
    /**
     * Constructor khởi tạo decorator với sách cần chuyển sang dạng chữ nổi
     * @param decoratedBook Sách cần chuyển sang chữ nổi Braille
     */
    public BrailleVersionDecorator(IBorrowable decoratedBook) {
        super(decoratedBook);
    }

    /**
     * Ghi đè phương thức mượn sách để bổ sung thông tin về phiên bản chữ nổi
     * @return Thông tin về việc mượn sách phiên bản chữ nổi
     */
    @Override
    public String borrow() {
        return decoratedBook.borrow() + " phiên bản chữ nổi Braille";
    }

    /**
     * Không tính thêm phí cho sách chữ nổi (tính năng hỗ trợ tiếp cận)
     * @return Phí mượn sách gốc
     */
    @Override
    public double calculateBorrowingFee() {
        // Không tính thêm phí cho phiên bản chữ nổi (đây là tính năng hỗ trợ người khuyết tật)
        return decoratedBook.calculateBorrowingFee();
    }
}