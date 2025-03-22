package org.iuh.se.library.singleton.demo;

import org.iuh.se.library.singleton.core.Library;
import org.iuh.se.library.singleton.model.Book;
import org.iuh.se.library.singleton.model.User;

import java.util.List;

/**
 * Demo cho hệ thống quản lý thư viện với Singleton Pattern
 */
public class LibraryDemo {
    public static void main(String[] args) {
        // Lấy instance duy nhất của Library
        Library library = Library.getInstance();

        // Thêm sách vào thư viện
        Book book1 = new Book("B001", "Harry Potter và Hòn đá Phù thủy", "J.K. Rowling", "Fantasy");
        Book book2 = new Book("B002", "Đắc nhân tâm", "Dale Carnegie", "Self-help");
        Book book3 = new Book("B003", "Lập trình Java cơ bản", "John Smith", "Programming");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Kiểm tra instance duy nhất của Library
        Library anotherLibraryReference = Library.getInstance();
        System.out.println("Kiểm tra Singleton Pattern: " + (library == anotherLibraryReference));

        // Tạo người dùng
        User user1 = new User("U001", "Nguyễn Văn A");

        // Mượn sách
        library.borrowBook(book1, user1);

        // Hiển thị danh sách sách có sẵn
        System.out.println("\nDanh sách sách có sẵn:");
        List<Book> availableBooks = library.getAvailableBooks();
        for (Book book : availableBooks) {
            System.out.println(book);
        }

        // Tìm kiếm sách theo tác giả
        System.out.println("\nTìm kiếm sách theo tác giả 'John':");
        List<Book> booksByAuthor = library.searchByAuthor("John");
        for (Book book : booksByAuthor) {
            System.out.println(book);
        }

        // Trả sách
        library.returnBook(book1);

        // Hiển thị lại danh sách sách có sẵn
        System.out.println("\nDanh sách sách có sẵn sau khi trả:");
        availableBooks = library.getAvailableBooks();
        for (Book book : availableBooks) {
            System.out.println(book);
        }
    }
}