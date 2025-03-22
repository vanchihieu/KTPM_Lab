package org.iuh.se.library.factory.model;

/**
 * Lớp sách nói
 */
public class AudioBook extends Book {
    private int durationMinutes;
    private String narrator;

    /**
     * Khởi tạo sách nói
     *
     * @param id ID duy nhất của sách
     * @param title Tên sách
     * @param author Tác giả
     * @param genre Thể loại
     * @param durationMinutes Thời lượng (phút)
     * @param narrator Người đọc
     */
    public AudioBook(String id, String title, String author, String genre, int durationMinutes, String narrator) {
        super(id, title, author, genre);
        this.durationMinutes = durationMinutes;
        this.narrator = narrator;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getNarrator() {
        return narrator;
    }

    @Override
    public void display() {
        System.out.println("Sách nói: " + getTitle());
        System.out.println("  Tác giả: " + getAuthor());
        System.out.println("  Thể loại: " + getGenre());
        System.out.println("  Thời lượng: " + durationMinutes + " phút");
        System.out.println("  Người đọc: " + narrator);
        System.out.println("  Trạng thái: " + (isAvailable() ? "Có sẵn" : "Đã mượn"));
    }

    @Override
    public String toString() {
        return "AudioBook{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", genre='" + getGenre() + '\'' +
                ", durationMinutes=" + durationMinutes +
                ", narrator='" + narrator + '\'' +
                ", available=" + isAvailable() +
                '}';
    }
}