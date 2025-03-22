package org.iuh.se.library.factory.factory;

import org.iuh.se.library.factory.model.AudioBook;
import org.iuh.se.library.factory.model.Book;

import java.util.Map;

/**
 * Factory cho việc tạo sách nói
 */
public class AudioBookFactory implements BookFactory {
    @Override
    public Book createBook(String id, String title, String author, String genre, Map<String, Object> attributes) {
        // Lấy thuộc tính cụ thể cho sách nói
        int durationMinutes = attributes.containsKey("durationMinutes") ? (int) attributes.get("durationMinutes") : 0;
        String narrator = attributes.containsKey("narrator") ? (String) attributes.get("narrator") : "Không xác định";

        return new AudioBook(id, title, author, genre, durationMinutes, narrator);
    }
}