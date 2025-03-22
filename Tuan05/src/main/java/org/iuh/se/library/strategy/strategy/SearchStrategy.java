package org.iuh.se.library.strategy.strategy;

import org.iuh.se.library.strategy.model.Book;

import java.util.List;

/**
 * Giao diện SearchStrategy định nghĩa chiến lược tìm kiếm.
 * Đây là phần cốt lõi của mẫu thiết kế Strategy Pattern.
 */
public interface SearchStrategy {
    /**
     * Phương thức tìm kiếm sách theo từ khóa
     * @param books Danh sách sách cần tìm kiếm
     * @param searchTerm Từ khóa tìm kiếm
     * @return Danh sách sách khớp với tiêu chí tìm kiếm
     */
    List<Book> search(List<Book> books, String searchTerm);
}