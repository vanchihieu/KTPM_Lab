package org.iuh.se.library.factory;

import org.iuh.se.library.factory.core.Library;
import org.iuh.se.library.factory.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Demo cho việc sử dụng Factory Method Pattern trong hệ thống thư viện
 */
public class LibraryFactoryDemo {
    public static void main(String[] args) {
        // Lấy instance duy nhất của Library
        Library library = Library.getInstance();

        // Tạo người dùng
        User user1 = new User("U001", "Nguyễn Văn A");
        User user2 = new User("U002", "Trần Thị B");

        // Thêm sách sử dụng Factory Method
        System.out.println("=== THÊM SÁCH SỬ DỤNG FACTORY METHOD ===");

        // Thêm sách giấy
        Map<String, Object> physicalAttributes = new HashMap<>();
        physicalAttributes.put("pages", 320);
        physicalAttributes.put("publisher", "NXB Kim Đồng");

        Book book1 = library.createAndAddBook("PHYSICAL", "P001", "Dế Mèn phiêu lưu ký", "Tô Hoài", "Văn học", physicalAttributes);

        // Thêm sách điện tử
        Map<String, Object> electronicAttributes = new HashMap<>();
        electronicAttributes.put("format", "EPUB");
        electronicAttributes.put("fileSizeMB", 5);

        Book book2 = library.createAndAddBook("ELECTRONIC", "E001", "Lập trình Java cơ bản", "John Smith", "Công nghệ", electronicAttributes);

        // Thêm sách nói
        Map<String, Object> audioAttributes = new HashMap<>();
        audioAttributes.put("durationMinutes", 480);
        audioAttributes.put("narrator", "Nguyễn Thị C");

        Book book3 = library.createAndAddBook("AUDIO", "A001", "Đắc nhân tâm", "Dale Carnegie", "Tâm lý", audioAttributes);

        // Hiển thị thông tin các sách vừa thêm
        System.out.println("\n=== HIỂN THỊ THÔNG TIN SÁCH ===");
        book1.display();
        System.out.println();
        book2.display();
        System.out.println();
        book3.display();

        // Tìm sách theo loại
        System.out.println("\n=== TÌM SÁCH THEO LOẠI ===");
        System.out.println("Sách giấy:");
        List<Book> physicalBooks = library.getBooksByType(PhysicalBook.class);
        for (Book book : physicalBooks) {
            System.out.println("  - " + book.getTitle());
        }

        System.out.println("Sách điện tử:");
        List<Book> electronicBooks = library.getBooksByType(ElectronicBook.class);
        for (Book book : electronicBooks) {
            System.out.println("  - " + book.getTitle());
        }

        System.out.println("Sách nói:");
        List<Book> audioBooks = library.getBooksByType(AudioBook.class);
        for (Book book : audioBooks) {
            System.out.println("  - " + book.getTitle());
        }

        // Mượn sách
        System.out.println("\n=== MƯỢN SÁCH ===");
        library.borrowBook(book1, user1);
        library.borrowBook(book2, user2);

        // Kiểm tra sách đã mượn
        System.out.println("\n=== KIỂM TRA SÁCH ĐÃ MƯỢN ===");
        user1.displayBorrowedBooks();
        System.out.println();
        user2.displayBorrowedBooks();

        // Kiểm tra sách có sẵn
        System.out.println("\n=== KIỂM TRA SÁCH CÓ SẴN ===");
        List<Book> availableBooks = library.getAvailableBooks();
        for (Book book : availableBooks) {
            System.out.println("  - " + book.getTitle() + " (" + book.getClass().getSimpleName() + ")");
        }
    }
}