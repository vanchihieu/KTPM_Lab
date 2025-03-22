package org.iuh.se.library.strategy;

import org.iuh.se.library.strategy.model.Book;
import org.iuh.se.library.strategy.service.Library;
import org.iuh.se.library.strategy.strategy.AuthorSearchStrategy;
import org.iuh.se.library.strategy.strategy.GenreSearchStrategy;
import org.iuh.se.library.strategy.strategy.TitleSearchStrategy;

import java.util.List;
import java.util.Scanner;

/**
 * Lớp LibraryManagementSystem cung cấp giao diện dòng lệnh cho người dùng
 * để tương tác với hệ thống thư viện.
 */
public class LibraryManagementSystem {
    private static Scanner scanner = new Scanner(System.in);  // Scanner để đọc input từ người dùng
    private static Library library = new Library();           // Đối tượng quản lý thư viện

    /**
     * Phương thức chính khởi chạy chương trình
     * @param args Tham số dòng lệnh (không sử dụng)
     */
    public static void main(String[] args) {
        // Khởi tạo thư viện với một số sách ban đầu
        initializeLibrary();

        boolean running = true;
        while (running) {
            printMenu();
            int choice = getIntInput("Nhập lựa chọn của bạn: ");

            switch (choice) {
                case 1:
                    displayAllBooks();
                    break;
                case 2:
                    displayAvailableBooks();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    addNewBook();
                    break;
                case 6:
                    searchBooks();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
        System.out.println("Cảm ơn bạn đã sử dụng Hệ thống Quản lý Thư viện!");
    }

    /**
     * Khởi tạo thư viện với một số sách mẫu
     */
    private static void initializeLibrary() {
        library.addBook(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald", "Classic"));
        library.addBook(new Book("B002", "To Kill a Mockingbird", "Harper Lee", "Fiction"));
        library.addBook(new Book("B003", "1984", "George Orwell", "Dystopian"));
        library.addBook(new Book("B004", "Pride and Prejudice", "Jane Austen", "Romance"));
        library.addBook(new Book("B005", "The Hobbit", "J.R.R. Tolkien", "Fantasy"));
    }

    /**
     * Hiển thị menu chính của chương trình
     */
    private static void printMenu() {
        System.out.println("\n===== Hệ thống Quản lý Thư viện =====");
        System.out.println("1. Xem tất cả sách");
        System.out.println("2. Xem sách có sẵn");
        System.out.println("3. Mượn sách");
        System.out.println("4. Trả sách");
        System.out.println("5. Thêm sách mới");
        System.out.println("6. Tìm kiếm sách");
        System.out.println("7. Thoát");
        System.out.println("=====================================");
    }

    /**
     * Hiển thị tất cả sách trong thư viện
     */
    private static void displayAllBooks() {
        List<Book> allBooks = library.getAllBooks();
        System.out.println("\n===== Tất cả sách =====");
        for (Book book : allBooks) {
            System.out.println(book);
        }
    }

    /**
     * Hiển thị sách có sẵn để mượn
     */
    private static void displayAvailableBooks() {
        List<Book> availableBooks = library.getAvailableBooks();
        System.out.println("\n===== Sách có sẵn =====");
        for (Book book : availableBooks) {
            System.out.println(book);
        }
    }

    /**
     * Xử lý việc mượn sách
     */
    private static void borrowBook() {
        displayAllBooks();
        String bookId = getStringInput("Nhập mã sách bạn muốn mượn: ");
        boolean success = library.borrowBook(bookId);
        if (success) {
            System.out.println("Mượn sách thành công!");
        } else {
            System.out.println("Không thể mượn sách. Sách có thể không có sẵn hoặc mã không hợp lệ.");
        }
    }

    /**
     * Xử lý việc trả sách
     */
    private static void returnBook() {
        String bookId = getStringInput("Nhập mã sách bạn muốn trả: ");
        boolean success = library.returnBook(bookId);
        if (success) {
            System.out.println("Trả sách thành công!");
        } else {
            System.out.println("Không thể trả sách. Mã sách có thể không hợp lệ hoặc sách đã có sẵn.");
        }
    }

    /**
     * Xử lý việc thêm sách mới
     */
    private static void addNewBook() {
        String id = getStringInput("Nhập mã sách: ");
        String title = getStringInput("Nhập tiêu đề sách: ");
        String author = getStringInput("Nhập tác giả: ");
        String genre = getStringInput("Nhập thể loại: ");

        Book newBook = new Book(id, title, author, genre);
        library.addBook(newBook);
        System.out.println("Thêm sách thành công!");
    }

    /**
     * Xử lý việc tìm kiếm sách sử dụng Strategy Pattern
     */
    private static void searchBooks() {
        System.out.println("\n===== Tìm kiếm sách =====");
        System.out.println("1. Tìm theo tiêu đề");
        System.out.println("2. Tìm theo tác giả");
        System.out.println("3. Tìm theo thể loại");
        int searchChoice = getIntInput("Nhập phương thức tìm kiếm: ");

        // Thiết lập chiến lược tìm kiếm thích hợp dựa trên lựa chọn của người dùng
        switch (searchChoice) {
            case 1:
                library.setSearchStrategy(new TitleSearchStrategy());
                break;
            case 2:
                library.setSearchStrategy(new AuthorSearchStrategy());
                break;
            case 3:
                library.setSearchStrategy(new GenreSearchStrategy());
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Mặc định tìm kiếm theo tiêu đề.");
                library.setSearchStrategy(new TitleSearchStrategy());
                break;
        }

        String searchTerm = getStringInput("Nhập từ khóa tìm kiếm: ");
        List<Book> searchResults = library.searchBooks(searchTerm);

        System.out.println("\n===== Kết quả tìm kiếm =====");
        if (searchResults.isEmpty()) {
            System.out.println("Không tìm thấy sách nào phù hợp với từ khóa.");
        } else {
            for (Book book : searchResults) {
                System.out.println(book);
            }
        }
    }

    /**
     * Đọc input số nguyên từ người dùng
     * @param prompt Thông báo hiển thị cho người dùng
     * @return Số nguyên người dùng nhập vào
     */
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Vui lòng nhập một số hợp lệ.");
            System.out.print(prompt);
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Tiêu thụ dòng mới
        return input;
    }

    /**
     * Đọc input chuỗi từ người dùng
     * @param prompt Thông báo hiển thị cho người dùng
     * @return Chuỗi người dùng nhập vào
     */
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}