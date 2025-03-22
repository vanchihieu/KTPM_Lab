package org.iuh.se.library.observer.model;

import java.util.Date;

/**
 * Lớp Book đại diện cho một cuốn sách trong thư viện
 * Lưu trữ thông tin cơ bản và trạng thái của sách
 */
public class Book {
    private String id;          // Mã định danh sách
    private String title;       // Tiêu đề sách
    private String author;      // Tác giả
    private String genre;       // Thể loại
    private boolean available;  // Trạng thái khả dụng (có thể mượn)
    private Date dueDate;       // Ngày đến hạn trả sách

    /**
     * Khởi tạo một cuốn sách mới
     * @param id Mã sách
     * @param title Tiêu đề
     * @param author Tác giả
     * @param genre Thể loại
     */
    public Book(String id, String title, String author, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = true;  // Sách mới thêm luôn có sẵn
        this.dueDate = null;    // Chưa có ngày đến hạn
    }

    // Các phương thức getter và setter
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    /**
     * Kiểm tra sách có sẵn để mượn không
     * @return true nếu sách có thể mượn, false nếu đã được mượn
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Đặt trạng thái khả dụng của sách
     * @param available true nếu sách có sẵn, false nếu đã được mượn
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Lấy ngày đến hạn trả sách
     * @return Ngày đến hạn nếu sách đã được mượn, null nếu không
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Đặt ngày đến hạn trả sách
     * @param dueDate Ngày đến hạn mới
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Trả về chuỗi mô tả sách
     */
    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", available=" + available +
                '}';
    }
}