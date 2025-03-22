package org.iuh.se.library.factory.factory;

import org.iuh.se.library.factory.model.Book;
import org.iuh.se.library.factory.model.ElectronicBook;

import java.util.Map;

/**
 * Factory cho việc tạo sách điện tử
 */
public class ElectronicBookFactory implements BookFactory {
    @Override
    public Book createBook(String id, String title, String author, String genre, Map<String, Object> attributes) {
        // Lấy thuộc tính cụ thể cho sách điện tử
        String format = attributes.containsKey("format") ? (String) attributes.get("format") : "PDF";
        int fileSizeMB = attributes.containsKey("fileSizeMB") ? (int) attributes.get("fileSizeMB") : 0;

        return new ElectronicBook(id, title, author, genre, format, fileSizeMB);
    }
}