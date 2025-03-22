package org.iuh.se.library.observer.core;

import org.iuh.se.library.observer.model.Book;
import org.iuh.se.library.observer.observer.Observer;
import org.iuh.se.library.observer.observer.Subject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Lớp Library quản lý các sách và thông báo cho các đối tượng quan tâm khi có sự kiện
 * Là triển khai cụ thể của giao diện Subject trong Observer pattern
 */
public class Library implements Subject {
    // Các loại sự kiện (event) được định nghĩa
    private static final String NEW_BOOK_EVENT = "NEW_BOOK";         // Sự kiện thêm sách mới
    private static final String OVERDUE_BOOK_EVENT = "OVERDUE_BOOK"; // Sự kiện sách quá hạn

    private List<Book> books;                           // Danh sách các sách trong thư viện
    private List<Observer> observers;                   // Danh sách observer cho tất cả sự kiện
    private Map<String, List<Observer>> topicObservers; // Danh sách observer theo từng chủ đề

    /**
     * Khởi tạo thư viện mới
     */
    public Library() {
        this.books = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.topicObservers = new HashMap<>();
        // Khởi tạo danh sách theo từng chủ đề
        topicObservers.put(NEW_BOOK_EVENT, new ArrayList<>());
        topicObservers.put(OVERDUE_BOOK_EVENT, new ArrayList<>());
    }

    // Triển khai các phương thức của giao diện Subject
    /**
     * Thêm một observer vào danh sách đăng ký tất cả sự kiện
     * @param observer Đối tượng observer cần thêm
     */
    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    /**
     * Xóa một observer khỏi danh sách đăng ký
     * @param observer Đối tượng observer cần xóa
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Thông báo cho tất cả observer về một sự kiện
     * @param event Loại sự kiện xảy ra
     * @param data Dữ liệu liên quan đến sự kiện
     */
    @Override
    public void notifyObservers(String event, Object data) {
        // Thông báo cho tất cả observer đăng ký chung
        for (Observer observer : observers) {
            observer.update(event, data);
        }

        // Thông báo cho các observer đăng ký theo chủ đề cụ thể
        if (topicObservers.containsKey(event)) {
            for (Observer observer : topicObservers.get(event)) {
                observer.update(event, data);
            }
        }
    }

    /**
     * Đăng ký một observer vào một chủ đề cụ thể
     * @param topic Chủ đề cần đăng ký (NEW_BOOK_EVENT, OVERDUE_BOOK_EVENT)
     * @param observer Đối tượng observer cần đăng ký
     */
    public void subscribeToTopic(String topic, Observer observer) {
        if (topicObservers.containsKey(topic)) {
            List<Observer> topicList = topicObservers.get(topic);
            if (!topicList.contains(observer)) {
                topicList.add(observer);
            }
        }
    }

    /**
     * Hủy đăng ký một observer khỏi một chủ đề cụ thể
     * @param topic Chủ đề cần hủy đăng ký
     * @param observer Đối tượng observer cần hủy đăng ký
     */
    public void unsubscribeFromTopic(String topic, Observer observer) {
        if (topicObservers.containsKey(topic)) {
            topicObservers.get(topic).remove(observer);
        }
    }

    // Các phương thức quản lý thư viện
    /**
     * Thêm một cuốn sách mới vào thư viện
     * @param book Cuốn sách cần thêm
     */
    public void addBook(Book book) {
        books.add(book);
        // Thông báo cho các observer về sách mới
        notifyObservers(NEW_BOOK_EVENT, book);
    }

    /**
     * Kiểm tra và thông báo về các sách quá hạn
     */
    public void checkForOverdueBooks() {
        Date currentDate = new Date();
        for (Book book : books) {
            if (!book.isAvailable() && book.getDueDate() != null && book.getDueDate().before(currentDate)) {
                // Thông báo cho các observer về sách quá hạn
                notifyObservers(OVERDUE_BOOK_EVENT, book);
            }
        }
    }

    /**
     * Lấy danh sách tất cả sách trong thư viện
     * @return Bản sao của danh sách sách
     */
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Tìm sách theo mã định danh
     * @param bookId Mã sách cần tìm
     * @return Đối tượng Book nếu tìm thấy, null nếu không
     */
    public Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    // Các phương thức getter cho hằng số (sử dụng bên ngoài)
    /**
     * @return Tên sự kiện thêm sách mới
     */
    public static String getNewBookEvent() {
        return NEW_BOOK_EVENT;
    }

    /**
     * @return Tên sự kiện sách quá hạn
     */
    public static String getOverdueBookEvent() {
        return OVERDUE_BOOK_EVENT;
    }
}