package org.iuh.se.library.decorator.decorator;

import org.iuh.se.library.decorator.core.IBorrowable;

/**
 * Lớp TranslatedVersionDecorator cung cấp sách ở dạng đã được dịch sang ngôn ngữ khác
 * Đây là một concrete decorator trong mẫu thiết kế Decorator
 */
public class TranslatedVersionDecorator extends BookDecorator {
    // Ngôn ngữ đích để dịch sách
    private String targetLanguage;

    /**
     * Constructor khởi tạo decorator với sách cần dịch và ngôn ngữ đích
     * @param decoratedBook Sách cần dịch
     * @param targetLanguage Ngôn ngữ đích cần dịch sang
     */
    public TranslatedVersionDecorator(IBorrowable decoratedBook, String targetLanguage) {
        super(decoratedBook);
        this.targetLanguage = targetLanguage;
    }

    /**
     * Ghi đè phương thức mượn sách để bổ sung thông tin về phiên bản dịch
     * @return Thông tin về việc mượn sách phiên bản đã dịch
     */
    @Override
    public String borrow() {
        return decoratedBook.borrow() + " đã được dịch sang " + targetLanguage;
    }

    /**
     * Tính thêm phí cho phiên bản dịch
     * @return Tổng phí mượn sách bao gồm phí dịch
     */
    @Override
    public double calculateBorrowingFee() {
        // Phí phụ thu nhỏ cho phiên bản dịch
        return decoratedBook.calculateBorrowingFee() + 2.0;
    }
}