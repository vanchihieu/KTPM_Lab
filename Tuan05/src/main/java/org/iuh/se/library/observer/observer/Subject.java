package org.iuh.se.library.observer.observer;

/**
 * Giao diện Subject định nghĩa các đối tượng có thể được theo dõi
 * Subject quản lý danh sách các Observer và thông báo cho họ khi có sự thay đổi
 */
public interface Subject {
    /**
     * Thêm một Observer vào danh sách theo dõi
     * @param observer Đối tượng Observer cần thêm
     */
    void addObserver(Observer observer);

    /**
     * Xóa một Observer khỏi danh sách theo dõi
     * @param observer Đối tượng Observer cần xóa
     */
    void removeObserver(Observer observer);

    /**
     * Thông báo cho tất cả Observer về một sự kiện
     * @param event Loại sự kiện xảy ra
     * @param data Dữ liệu liên quan đến sự kiện
     */
    void notifyObservers(String event, Object data);
}