package org.iuh.se.library.strategy.strategy;

import org.iuh.se.library.strategy.model.Book;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Chiến lược tìm kiếm sách theo thể loại.
 * Là một triển khai cụ thể của giao diện SearchStrategy.
 */
public class GenreSearchStrategy implements SearchStrategy {
    /**
     * Tìm kiếm sách dựa trên thể loại chứa từ khóa
     * @param books Danh sách sách cần tìm kiếm
     * @param searchTerm Từ khóa tìm kiếm trong thể loại
     * @return Danh sách sách có thể loại chứa từ khóa
     */
    @Override
    public List<Book> search(List<Book> books, String searchTerm) {
        // Sử dụng Stream API để lọc sách có thể loại chứa từ khóa (không phân biệt hoa thường)
        return books.stream()
                .filter(book -> book.getGenre().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());
    }
}