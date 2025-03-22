package org.iuh.se.library.observer.model;

import org.iuh.se.library.observer.core.Library;
import org.iuh.se.library.observer.observer.Observer;

/**
 * Lớp LibraryUser đại diện cho người dùng thư viện
 * Nhận thông báo về các sự kiện trong thư viện
 */
public class LibraryUser implements Observer {
    private String id;    // Mã người dùng
    private String name;  // Tên người dùng
    private String email; // Email để gửi thông báo

    /**
     * Khởi tạo người dùng thư viện mới
     * @param id Mã người dùng
     * @param name Tên người dùng
     * @param email Email
     */
    public LibraryUser(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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
                System.out.println("[NGƯỜI DÙNG] " + name + " được thông báo về sách mới: "
                        + book.getTitle() + " của tác giả " + book.getAuthor());
                // Trong hệ thống thực tế, sẽ gửi email thông báo
                System.out.println("Email đã được gửi đến: " + email);
            } else if (Library.getOverdueBookEvent().equals(event)) {
                // Xử lý sự kiện sách quá hạn
                // Trong thực tế, chỉ thông báo cho người mượn sách
                System.out.println("[NGƯỜI DÙNG] " + name + " được nhắc nhở về sách quá hạn: "
                        + book.getTitle() + ", hạn trả: " + book.getDueDate());
                System.out.println("Email nhắc nhở đã được gửi đến: " + email);
            }
        }
    }

    /**
     * @return Mã người dùng
     */
    public String getId() {
        return id;
    }
}