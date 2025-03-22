package org.iuh.se.library.factory.model;

/**
 * Lớp sách giấy
 */
public class PhysicalBook extends Book {
    private int pages;
    private String publisher;

    /**
     * Khởi tạo sách giấy
     *
     * @param id ID duy nhất của sách
     * @param title Tên sách
     * @param author Tác giả
     * @param genre Thể loại
     * @param pages Số trang
     * @param publisher Nhà xuất bản
     */
    public PhysicalBook(String id, String title, String author, String genre, int pages, String publisher) {
        super(id, title, author, genre);
        this.pages = pages;
        this.publisher = publisher;
    }

    public int getPages() {
        return pages;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public void display() {
        System.out.println("Sách giấy: " + getTitle());
        System.out.println("  Tác giả: " + getAuthor());
        System.out.println("  Thể loại: " + getGenre());
        System.out.println("  Số trang: " + pages);
        System.out.println("  Nhà xuất bản: " + publisher);
        System.out.println("  Trạng thái: " + (isAvailable() ? "Có sẵn" : "Đã mượn"));
    }

    @Override
    public String toString() {
        return "PhysicalBook{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", genre='" + getGenre() + '\'' +
                ", pages=" + pages +
                ", publisher='" + publisher + '\'' +
                ", available=" + isAvailable() +
                '}';
    }
}