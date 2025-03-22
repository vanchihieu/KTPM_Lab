package org.iuh.se.library.decorator;

import org.iuh.se.library.decorator.core.BasicBook;
import org.iuh.se.library.decorator.core.IBorrowable;
import org.iuh.se.library.decorator.decorator.BrailleVersionDecorator;
import org.iuh.se.library.decorator.decorator.ExtendedBorrowingDecorator;
import org.iuh.se.library.decorator.decorator.InsuranceDecorator;
import org.iuh.se.library.decorator.decorator.TranslatedVersionDecorator;

/**
 * Lớp LibraryManagementDemo dùng để demo các tính năng của hệ thống quản lý thư viện
 * sử dụng mẫu thiết kế Decorator
 */
public class LibraryManagementDemo {
    public static void main(String[] args) {
        // Tạo một sách cơ bản
        System.out.println("=== DEMO HỆ THỐNG QUẢN LÝ THƯ VIỆN ===");
        IBorrowable basicBook = new BasicBook("Design Patterns", "Erich Gamma et al.", "Khoa học máy tính", "978-0201633610");
        System.out.println(basicBook.borrow());
        System.out.println("Phí mượn: " + basicBook.calculateBorrowingFee() + " đồng");
        System.out.println("Thời gian mượn: " + basicBook.getBorrowingDays() + " ngày");

        System.out.println("\n--------------------------\n");

        // Tạo một sách với thời gian mượn gia hạn
        System.out.println("=== SÁCH VỚI THỜI GIAN MƯỢN GIA HẠN ===");
        IBorrowable extendedBook = new ExtendedBorrowingDecorator(basicBook, 7);
        System.out.println(extendedBook.borrow());
        System.out.println("Phí mượn: " + extendedBook.calculateBorrowingFee() + " đồng");
        System.out.println("Thời gian mượn: " + extendedBook.getBorrowingDays() + " ngày");

        System.out.println("\n--------------------------\n");

        // Tạo một sách với phiên bản chữ nổi
        System.out.println("=== SÁCH PHIÊN BẢN CHỮ NỔI BRAILLE ===");
        IBorrowable brailleBook = new BrailleVersionDecorator(basicBook);
        System.out.println(brailleBook.borrow());
        System.out.println("Phí mượn: " + brailleBook.calculateBorrowingFee() + " đồng");

        System.out.println("\n--------------------------\n");

        // Tạo một sách với phiên bản đã dịch
        System.out.println("=== SÁCH PHIÊN BẢN DỊCH ===");
        IBorrowable translatedBook = new TranslatedVersionDecorator(basicBook, "Tiếng Việt");
        System.out.println(translatedBook.borrow());
        System.out.println("Phí mượn: " + translatedBook.calculateBorrowingFee() + " đồng");

        System.out.println("\n--------------------------\n");

        // Kết hợp nhiều decorator
        System.out.println("=== SÁCH KẾT HỢP NHIỀU TÍNH NĂNG ===");
        IBorrowable complexBook = new InsuranceDecorator(
                new ExtendedBorrowingDecorator(
                        new TranslatedVersionDecorator(basicBook, "Tiếng Pháp"),
                        14),
                50.0);
        System.out.println(complexBook.borrow());
        System.out.println("Phí mượn: " + complexBook.calculateBorrowingFee() + " đồng");
        System.out.println("Thời gian mượn: " + complexBook.getBorrowingDays() + " ngày");
        System.out.println("\n=== KẾT THÚC DEMO ===");
    }
}