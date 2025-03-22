package org.iuh.se.library.factory.factory;

import org.iuh.se.library.factory.model.Book;
import org.iuh.se.library.factory.model.PhysicalBook;

import java.util.Map;

/**
 * Factory cho việc tạo sách giấy
 */
public class PhysicalBookFactory implements BookFactory {
    @Override
    public Book createBook(String id, String title, String author, String genre, Map<String, Object> attributes) {
        // Lấy thuộc tính cụ thể cho sách giấy
        int pages = attributes.containsKey("pages") ? (int) attributes.get("pages") : 0;
        String publisher = attributes.containsKey("publisher") ? (String) attributes.get("publisher") : "Không xác định";

        return new PhysicalBook(id, title, author, genre, pages, publisher);
    }
}