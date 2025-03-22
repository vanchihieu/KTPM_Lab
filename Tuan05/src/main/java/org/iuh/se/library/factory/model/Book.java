package org.iuh.se.library.factory.model;

/**
 * Lớp trừu tượng đại diện cho một quyển sách trong thư viện
 */
public abstract class Book {
    private String id;
    private String title;
    private String author;
    private String genre;
    private boolean available;

    /**
     * Khởi tạo một quyển sách mới
     *
     * @param id ID duy nhất của sách
     * @param title Tên sách
     * @param author Tác giả
     * @param genre Thể loại
     */
    public Book(String id, String title, String author, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = true;
    }

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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Hiển thị thông tin sách
     * Phương thức trừu tượng phải được cài đặt bởi các lớp con
     */
    public abstract void display();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}