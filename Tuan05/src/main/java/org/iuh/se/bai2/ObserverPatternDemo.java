package org.iuh.se.bai2;

import org.iuh.se.bai2.stock.StockObserver;
import org.iuh.se.bai2.stock.StockSubject;
import org.iuh.se.bai2.task.TaskObserver;
import org.iuh.se.bai2.task.TaskStatus;
import org.iuh.se.bai2.task.TaskSubject;

/**
 * Lớp Demo cho Observer Pattern
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        // Demo hệ thống thông báo cổ phiếu
        System.out.println("===== DEMO HỆ THỐNG THÔNG BÁO CỔ PHIẾU =====");

        // Tạo các cổ phiếu
        StockSubject apple = new StockSubject("AAPL", 150.25);
        StockSubject google = new StockSubject("GOOG", 2700.50);
        StockSubject amazon = new StockSubject("AMZN", 3300.75);

        // Tạo các nhà đầu tư
        StockObserver investor1 = new StockObserver("Nguyễn Văn A");
        StockObserver investor2 = new StockObserver("Trần Thị B");
        StockObserver investor3 = new StockObserver("Lê Văn C");

        // Đăng ký theo dõi
        investor1.addStock(apple);
        investor1.addStock(google);

        investor2.addStock(apple);
        investor2.addStock(amazon);

        investor3.addStock(google);
        investor3.addStock(amazon);

        System.out.println("\n--- Cập nhật giá cổ phiếu ---");

        // Thay đổi giá cổ phiếu
        apple.setPrice(155.75);
        google.setPrice(2750.00);
        amazon.setPrice(3250.50);

        // Hủy đăng ký
        System.out.println("\n--- Hủy đăng ký và cập nhật lại ---");
        investor1.removeStock(apple);
        apple.setPrice(160.25);

        // Demo hệ thống thông báo trạng thái công việc
        System.out.println("\n\n===== DEMO HỆ THỐNG THÔNG BÁO CÔNG VIỆC =====");

        // Tạo các công việc
        TaskSubject task1 = new TaskSubject("TASK-001", "Thiết kế database", TaskStatus.TO_DO);
        TaskSubject task2 = new TaskSubject("TASK-002", "Viết API endpoints", TaskStatus.TO_DO);
        TaskSubject task3 = new TaskSubject("TASK-003", "Thiết kế giao diện người dùng", TaskStatus.TO_DO);

        // Tạo các thành viên dự án
        TaskObserver member1 = new TaskObserver("Phạm Văn D");
        TaskObserver member2 = new TaskObserver("Hoàng Thị E");
        TaskObserver member3 = new TaskObserver("Đỗ Văn F");

        // Đăng ký theo dõi
        member1.addTask(task1);
        member1.addTask(task2);

        member2.addTask(task1);
        member2.addTask(task3);

        member3.addTask(task2);
        member3.addTask(task3);

        System.out.println("\n--- Cập nhật trạng thái công việc ---");

        // Cập nhật trạng thái công việc
        task1.setStatus(TaskStatus.IN_PROGRESS);
        task2.setStatus(TaskStatus.IN_PROGRESS);
        task3.setStatus(TaskStatus.IN_PROGRESS);

        // Cập nhật thêm
        System.out.println("\n--- Cập nhật trạng thái mới ---");
        task1.setStatus(TaskStatus.REVIEW);
        task2.setStatus(TaskStatus.COMPLETED);

        // Hủy đăng ký
        System.out.println("\n--- Hủy đăng ký và cập nhật lại ---");
        member1.removeTask(task1);
        task1.setStatus(TaskStatus.COMPLETED);
    }
}