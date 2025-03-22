package org.iuh.se.library.observer.model;

import org.iuh.se.library.observer.core.Library;
import org.iuh.se.library.observer.observer.Observer;

/**
 * Lớp LibraryStaff đại diện cho nhân viên thư viện
 * Nhận thông báo về các sự kiện trong thư viện
 */
public class LibraryStaff implements Observer {
    private String name;     // Tên nhân viên
    private String position; // Chức vụ

    /**
     * Khởi tạo nhân viên thư viện mới
     * @param name Tên nhân viên
     * @param position Chức vụ
     */
    public LibraryStaff(String name, String position) {
        this.name = name;
        this.position = position;
    }

    /**
     * Xử lý thông báo từ Subject
     * @param event Loại sự kiện
     * @param data Dữ liệu sự kiện (thường là sách)
     */
    @Override
    public void update(String event, Object data) {
        if (data instanceof Book) {
            Book book = (Book) data;

            if (Library.getNewBookEvent().equals(event)) {
                // Xử lý sự kiện sách mới
                System.out.println("[NHÂN VIÊN] " + name + " (" + position + ") được thông báo về sách mới: "
                        + book.getTitle() + " của tác giả " + book.getAuthor());
            } else if (Library.getOverdueBookEvent().equals(event)) {
                // Xử lý sự kiện sách quá hạn
                System.out.println("[NHÂN VIÊN] " + name + " (" + position + ") được thông báo về sách quá hạn: "
                        + book.getTitle() + ", hạn trả: " + book.getDueDate());
            }
        }
    }
}