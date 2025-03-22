package org.iuh.se.library.factory.factory;

import org.iuh.se.library.factory.model.Book;

import java.util.Map;

/**
 * Interface cho Factory Method Pattern
 */
public interface BookFactory {
    /**
     * Phương thức tạo sách
     *
     * @param id ID sách
     * @param title Tên sách
     * @param author Tác giả
     * @param genre Thể loại
     * @param additionalInfo Thông tin bổ sung cho từng loại sách
     * @return Đối tượng sách đã tạo
     */
    Book createBook(String id, String title, String author, String genre, Map<String, Object> additionalInfo);
}