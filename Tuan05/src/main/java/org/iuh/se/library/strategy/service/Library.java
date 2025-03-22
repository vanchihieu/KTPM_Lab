package org.iuh.se.library.strategy.service;

import org.iuh.se.library.strategy.model.Book;
import org.iuh.se.library.strategy.strategy.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Lớp Library quản lý toàn bộ sách trong thư viện và các thao tác với sách.
 * Hoạt động như context trong Strategy Pattern.
 */
public class Library {
    private List<Book> books;              // Danh sách sách trong thư viện
    private SearchStrategy searchStrategy; // Chiến lược tìm kiếm hiện tại

    /**
     * Khởi tạo thư viện với danh sách sách rỗng
     */
    public Library() {
        books = new ArrayList<>();
    }

    /**
     * Thiết lập chiến lược tìm kiếm
     * @param searchStrategy Chiến lược tìm kiếm sẽ được sử dụng
     */
    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    /**
     * Tìm kiếm sách sử dụng chiến lược hiện tại
     * @param searchTerm Từ khóa tìm kiếm
     * @return Danh sách sách thỏa mãn điều kiện tìm kiếm
     * @throws IllegalStateException Nếu chiến lược tìm kiếm chưa được thiết lập
     */
    public List<Book> searchBooks(String searchTerm) {
        if (searchStrategy == null) {
            throw new IllegalStateException("Search strategy is not set");
        }
        return searchStrategy.search(books, searchTerm);
    }

    /**
     * Thêm sách vào thư viện
     * @param book Sách cần thêm
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Mượn sách từ thư viện
     * @param bookId Mã sách cần mượn
     * @return true nếu mượn thành công, false nếu không tìm thấy sách hoặc sách đã được mượn
     */
    public boolean borrowBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId) && book.isAvailable()) {
                book.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    /**
     * Trả sách về thư viện
     * @param bookId Mã sách cần trả
     * @return true nếu trả thành công, false nếu không tìm thấy sách hoặc sách đã có sẵn
     */
    public boolean returnBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId) && !book.isAvailable()) {
                book.setAvailable(true);
                return true;
            }
        }
        return false;
    }

    /**
     * Lấy danh sách sách có sẵn (chưa được mượn)
     * @return Danh sách sách có sẵn
     */
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    /**
     * Lấy toàn bộ danh sách sách trong thư viện
     * @return Danh sách tất cả sách
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}