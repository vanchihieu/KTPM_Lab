package org.iuh.se.library.factory.model;

/**
 * Lớp sách điện tử
 */
public class ElectronicBook extends Book {
    private String format; // PDF, EPUB, MOBI, etc.
    private int fileSizeMB;

    /**
     * Khởi tạo sách điện tử
     *
     * @param id ID duy nhất của sách
     * @param title Tên sách
     * @param author Tác giả
     * @param genre Thể loại
     * @param format Định dạng file
     * @param fileSizeMB Kích thước file (MB)
     */
    public ElectronicBook(String id, String title, String author, String genre, String format, int fileSizeMB) {
        super(id, title, author, genre);
        this.format = format;
        this.fileSizeMB = fileSizeMB;
    }

    public String getFormat() {
        return format;
    }

    public int getFileSizeMB() {
        return fileSizeMB;
    }

    @Override
    public void display() {
        System.out.println("Sách điện tử: " + getTitle());
        System.out.println("  Tác giả: " + getAuthor());
        System.out.println("  Thể loại: " + getGenre());
        System.out.println("  Định dạng: " + format);
        System.out.println("  Kích thước: " + fileSizeMB + " MB");
        System.out.println("  Trạng thái: " + (isAvailable() ? "Có sẵn" : "Đã mượn"));
    }

    @Override
    public String toString() {
        return "ElectronicBook{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", genre='" + getGenre() + '\'' +
                ", format='" + format + '\'' +
                ", fileSizeMB=" + fileSizeMB +
                ", available=" + isAvailable() +
                '}';
    }
}