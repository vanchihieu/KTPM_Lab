package org.iuh.se.library.observer;

import org.iuh.se.library.observer.core.Library;
import org.iuh.se.library.observer.model.Book;
import org.iuh.se.library.observer.model.LibraryStaff;
import org.iuh.se.library.observer.model.LibraryUser;

import java.util.Calendar;
import java.util.Date;

/**
 * Lớp demo minh họa cách hoạt động của Observer Pattern trong hệ thống thư viện
 */
public class LibraryManagementDemo {
    public static void main(String[] args) {
        // Tạo thư viện
        Library library = new Library();

        // Tạo một số nhân viên thư viện
        LibraryStaff librarian = new LibraryStaff("Nguyễn Văn A", "Thủ thư trưởng");
        LibraryStaff assistant = new LibraryStaff("Trần Thị B", "Trợ lý thủ thư");

        // Tạo một số người dùng thư viện
        LibraryUser user1 = new LibraryUser("U001", "Lê Thị C", "lethic@example.com");
        LibraryUser user2 = new LibraryUser("U002", "Phạm Văn D", "phamvand@example.com");

        // Đăng ký nhân viên nhận tất cả thông báo của thư viện
        library.addObserver(librarian);
        library.addObserver(assistant);

        // Đăng ký người dùng nhận thông báo theo chủ đề cụ thể
        library.subscribeToTopic(Library.getNewBookEvent(), user1);
        library.subscribeToTopic(Library.getNewBookEvent(), user2);

        System.out.println("=== Thêm sách mới ===");
        // Thêm một số sách vào thư viện và quan sát thông báo
        Book book1 = new Book("B001", "Dế Mèn Phiêu Lưu Ký", "Tô Hoài", "Văn học Việt Nam");
        Book book2 = new Book("B002", "Lập Trình Java Hiệu Quả", "Joshua Bloch", "Lập trình");

        library.addBook(book1);
        library.addBook(book2);

        System.out.println("\n=== Mô phỏng sách quá hạn ===");
        // Mô phỏng tình huống mượn sách và quá hạn
        // Đặt ngày hạn trả trong quá khứ để mô phỏng sách quá hạn
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -5); // 5 ngày trước
        Date pastDate = calendar.getTime();

        book1.setAvailable(false); // Sách đã được mượn
        book1.setDueDate(pastDate); // Ngày hạn trả đã qua

        // Kiểm tra sách quá hạn
        library.checkForOverdueBooks();

        // Hủy đăng ký thông báo cho một người dùng
        System.out.println("\n=== Sau khi hủy đăng ký cho User1 ===");
        library.unsubscribeFromTopic(Library.getNewBookEvent(), user1);

        // Thêm sách khác
        Book book3 = new Book("B003", "Design Patterns", "Gamma et al.", "Kỹ thuật phần mềm");
        library.addBook(book3);
    }
}