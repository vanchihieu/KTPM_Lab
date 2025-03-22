package org.iuh.se.library.observer.observer;


/**
 * Giao diện Observer định nghĩa các đối tượng có thể nhận thông báo từ Subject
 * Các đối tượng này sẽ được cập nhật khi Subject thay đổi trạng thái
 */
public interface Observer {
    /**
     * Phương thức này được gọi khi Subject gửi thông báo
     * @param event Loại sự kiện xảy ra (vd: sách mới, sách quá hạn)
     * @param data Dữ liệu liên quan đến sự kiện (thường là đối tượng Book)
     */
    void update(String event, Object data);
}