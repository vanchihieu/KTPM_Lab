package org.iuh.se.bai1.component;

/**
 * Component (thành phần) định nghĩa interface chung cho tất cả các thành phần
 * trong hệ thống quản lý file (cả thư mục và tập tin)
 */
public interface FileSystemItem {
    /**
     * Lấy tên của thành phần
     * @return tên của thành phần
     */
    String getName();

    /**
     * Lấy đường dẫn của thành phần
     * @return đường dẫn của thành phần
     */
    String getPath();

    /**
     * Hiển thị thông tin của thành phần với mức thụt lề
     * @param depth mức độ thụt lề
     */
    void display(int depth);

    /**
     * Lấy kích thước của thành phần
     * @return kích thước tính bằng byte
     */
    long getSize();
}