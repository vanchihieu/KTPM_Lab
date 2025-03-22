package org.iuh.se.library.strategy.model;

/**
 * Lớp Book đại diện cho một cuốn sách trong hệ thống thư viện.
 * Chứa thông tin cơ bản về sách như mã sách, tiêu đề, tác giả, thể loại và trạng thái.
 */
public class Book {
    private String id;        // Mã định danh của sách
    private String title;     // Tiêu đề sách
    private String author;    // Tác giả sách
    private String genre;     // Thể loại sách
    private boolean isAvailable;  // Trạng thái sách (có sẵn hay đã được mượn)

    /**
     * Hàm khởi tạo để tạo một đối tượng sách mới
     * @param id Mã định danh sách
     * @param title Tiêu đề sách
     * @param author Tác giả sách
     * @param genre Thể loại sách
     */
    public Book(String id, String title, String author, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true;  // Mặc định sách mới thêm vào có trạng thái sẵn sàng
    }

    // Các phương thức getter và setter

    /**
     * Lấy mã định danh của sách
     * @return Mã định danh sách
     */
    public String getId() {
        return id;
    }

    /**
     * Lấy tiêu đề sách
     * @return Tiêu đề sách
     */
    public String getTitle() {
        return title;
    }

    /**
     * Lấy tên tác giả
     * @return Tên tác giả
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Lấy thể loại sách
     * @return Thể loại sách
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Kiểm tra trạng thái sách
     * @return true nếu sách có sẵn, false nếu đã được mượn
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Cập nhật trạng thái sách
     * @param available trạng thái mới (true: có sẵn, false: đã mượn)
     */
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     * Ghi đè phương thức toString để hiển thị thông tin sách
     * @return Chuỗi thông tin về sách
     */
    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}