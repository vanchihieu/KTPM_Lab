package org.iuh.se.library.factory.core;

import java.util.ArrayList;
import org.iuh.se.library.factory.factory.BookFactory;
import org.iuh.se.library.factory.factory.BookFactoryProducer;
import org.iuh.se.library.factory.model.Book;
import org.iuh.se.library.factory.model.User;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Quản lý thư viện sử dụng Singleton Pattern
 */
public class Library {
    // Single instance của Library
    private static Library instance;

    // Danh sách sách trong thư viện
    private List<Book> books;

    // Map lưu trữ thông tin người mượn sách
    private Map<Book, User> borrowers;

    /**
     * Constructor private để ngăn việc tạo đối tượng trực tiếp
     */
    private Library() {
        books = new ArrayList<>();
        borrowers = new HashMap<>();
    }

    /**
     * Phương thức static để lấy instance duy nhất của Library
     *
     * @return instance duy nhất của Library
     */
    public static synchronized Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    /**
     * Thêm sách mới vào thư viện
     *
     * @param book Sách cần thêm
     */
    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
            System.out.println("Đã thêm sách: " + book.getTitle());
        } else {
            System.out.println("Sách đã tồn tại trong thư viện");
        }
    }

    /**
     * Tạo và thêm sách mới vào thư viện bằng Factory Method
     *
     * @param bookType Loại sách (PHYSICAL, ELECTRONIC, AUDIO)
     * @param id ID sách
     * @param title Tên sách
     * @param author Tác giả
     * @param genre Thể loại
     * @param attributes Thuộc tính bổ sung
     * @return Sách đã tạo
     */
    public Book createAndAddBook(String bookType, String id, String title, String author, String genre, Map<String, Object> attributes) {
        BookFactory factory = BookFactoryProducer.getFactory(bookType);
        if (factory != null) {
            Book book = factory.createBook(id, title, author, genre, attributes);
            addBook(book);
            return book;
        }
        return null;
    }

    /**
     * Xóa sách khỏi thư viện
     *
     * @param book Sách cần xóa
     * @return true nếu xóa thành công
     */
    public boolean removeBook(Book book) {
        if (books.contains(book) && book.isAvailable()) {
            books.remove(book);
            System.out.println("Đã xóa sách: " + book.getTitle());
            return true;
        }
        System.out.println("Không thể xóa sách (không tồn tại hoặc đang được mượn)");
        return false;
    }

    /**
     * Cho mượn sách
     *
     * @param book Sách cần mượn
     * @param user Người mượn sách
     * @return true nếu mượn thành công
     */
    public boolean borrowBook(Book book, User user) {
        if (books.contains(book) && book.isAvailable()) {
            book.setAvailable(false);
            borrowers.put(book, user);
            user.borrowBook(book);
            System.out.println(user.getName() + " đã mượn sách: " + book.getTitle());
            return true;
        }
        System.out.println("Không thể mượn sách (không tồn tại hoặc đã được mượn)");
        return false;
    }

    /**
     * Trả sách
     *
     * @param book Sách cần trả
     * @return true nếu trả thành công
     */
    public boolean returnBook(Book book) {
        if (borrowers.containsKey(book)) {
            User user = borrowers.get(book);
            book.setAvailable(true);
            borrowers.remove(book);
            user.returnBook(book);
            System.out.println(user.getName() + " đã trả sách: " + book.getTitle());
            return true;
        }
        System.out.println("Không thể trả sách (sách không được mượn)");
        return false;
    }

    /**
     * Tìm sách theo tên
     *
     * @param title Tên sách cần tìm
     * @return Danh sách sách có tên khớp với tên tìm kiếm
     */
    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Tìm sách theo tác giả
     *
     * @param author Tên tác giả cần tìm
     * @return Danh sách sách có tác giả khớp với tên tìm kiếm
     */
    public List<Book> searchByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Tìm sách theo thể loại
     *
     * @param genre Thể loại cần tìm
     * @return Danh sách sách có thể loại khớp với tên tìm kiếm
     */
    public List<Book> searchByGenre(String genre) {
        return books.stream()
                .filter(book -> book.getGenre().toLowerCase().contains(genre.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Lấy danh sách sách theo loại
     *
     * @param bookType Loại sách (PhysicalBook, ElectronicBook, AudioBook)
     * @return Danh sách sách thuộc loại cụ thể
     */
    public List<Book> getBooksByType(Class<?> bookType) {
        return books.stream()
                .filter(book -> bookType.isInstance(book))
                .collect(Collectors.toList());
    }

    /**
     * Lấy danh sách sách có sẵn (chưa được mượn)
     *
     * @return Danh sách sách có sẵn
     */
    public List<Book> getAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }

    /**
     * Lấy tất cả sách trong thư viện
     *
     * @return Danh sách tất cả sách
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Kiểm tra xem sách có trong thư viện không
     *
     * @param book Sách cần kiểm tra
     * @return true nếu sách có trong thư viện
     */
    public boolean containsBook(Book book) {
        return books.contains(book);
    }
}