package org.iuh.se.library.singleton.core;

import org.iuh.se.library.singleton.model.User;
import org.iuh.se.library.singleton.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Lớp Library triển khai Singleton Pattern
 * Quản lý tất cả các sách và hoạt động mượn/trả trong thư viện
 */
public class Library {
    // Biến static để lưu trữ instance duy nhất của lớp Library
    private static Library instance;

    // Danh sách sách trong thư viện
    private List<Book> books;

    // Map lưu trữ thông tin người mượn sách
    private Map<Book, User> borrowers;

    /**
     * Constructor được đặt private để ngăn khởi tạo bên ngoài lớp
     */
    private Library() {
        books = new ArrayList<>();
        borrowers = new HashMap<>();
    }

    /**
     * Phương thức static để lấy instance duy nhất của Library
     * Sử dụng synchronized để đảm bảo thread-safe
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