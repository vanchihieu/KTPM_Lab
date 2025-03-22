package org.iuh.se.library.singleton.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Lớp User đại diện cho người dùng thư viện
 */
public class User {
    private String id;
    private String name;
    private List<Book> borrowedBooks;

    /**
     * Khởi tạo một người dùng mới
     *
     * @param id ID duy nhất của người dùng
     * @param name Tên người dùng
     */
    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    /**
     * Mượn một quyển sách
     *
     * @param book Sách cần mượn
     */
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    /**
     * Trả một quyển sách
     *
     * @param book Sách cần trả
     * @return true nếu trả sách thành công, false nếu người dùng không mượn sách này
     */
    public boolean returnBook(Book book) {
        return borrowedBooks.remove(book);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", borrowedBooks=" + borrowedBooks.size() +
                '}';
    }
}