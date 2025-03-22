package org.iuh.se.library.decorator.core;

/**
 * Lớp BasicBook là lớp cơ bản thực thi interface IBorrowable
 * Đây là component cụ thể trong mẫu thiết kế Decorator
 */
public class BasicBook implements IBorrowable {
    private String title;     // Tiêu đề sách
    private String author;    // Tác giả
    private String genre;     // Thể loại
    private String isbn;      // Mã ISBN

    /**
     * Constructor khởi tạo sách với các thông tin cơ bản
     * @param title Tiêu đề sách
     * @param author Tác giả
     * @param genre Thể loại
     * @param isbn Mã ISBN
     */
    public BasicBook(String title, String author, String genre, String isbn) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
    }

    // Các phương thức getter
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    /**
     * Thực hiện việc mượn sách cơ bản
     * @return Thông tin về việc mượn sách
     */
    @Override
    public String borrow() {
        return "Đang mượn sách cơ bản: " + title + " của tác giả " + author;
    }

    /**
     * Tính phí mượn sách tiêu chuẩn
     * @return Phí mượn sách (đơn vị: đồng)
     */
    @Override
    public double calculateBorrowingFee() {
        return 5.0; // Phí mượn sách tiêu chuẩn
    }

    /**
     * Lấy thời gian được phép mượn sách tiêu chuẩn
     * @return Số ngày được phép mượn
     */
    @Override
    public int getBorrowingDays() {
        return 14; // Thời gian mượn tiêu chuẩn: 14 ngày
    }
}