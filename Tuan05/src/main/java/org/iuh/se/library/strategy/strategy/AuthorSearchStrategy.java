package org.iuh.se.library.strategy.strategy;

import org.iuh.se.library.strategy.model.Book;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Chiến lược tìm kiếm sách theo tác giả.
 * Là một triển khai cụ thể của giao diện SearchStrategy.
 */
public class AuthorSearchStrategy implements SearchStrategy {
    /**
     * Tìm kiếm sách dựa trên tên tác giả chứa từ khóa
     * @param books Danh sách sách cần tìm kiếm
     * @param searchTerm Từ khóa tìm kiếm trong tên tác giả
     * @return Danh sách sách có tác giả chứa từ khóa
     */
    @Override
    public List<Book> search(List<Book> books, String searchTerm) {
        // Sử dụng Stream API để lọc sách có tác giả chứa từ khóa (không phân biệt hoa thường)
        return books.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());
    }
}