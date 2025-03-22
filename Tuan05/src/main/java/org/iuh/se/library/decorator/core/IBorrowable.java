package org.iuh.se.library.decorator.core;

/**
 * Interface IBorrowable định nghĩa các phương thức cơ bản cho việc mượn sách
 * Đây là interface cốt lõi trong mẫu thiết kế Decorator
 */
public interface IBorrowable {
    // Phương thức mượn sách
    String borrow();

    // Tính phí mượn sách
    double calculateBorrowingFee();

    // Lấy số ngày được phép mượn
    int getBorrowingDays();
}