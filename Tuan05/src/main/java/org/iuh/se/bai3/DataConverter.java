package org.iuh.se.bai3;

/**
 * Giao diện DataConverter định nghĩa các phương thức chuyển đổi dữ liệu
 * giữa định dạng XML và JSON
 */
public interface DataConverter {
    /**
     * Chuyển đổi dữ liệu từ XML sang JSON
     * @param xmlData Dữ liệu XML cần chuyển đổi
     * @return Dữ liệu sau khi chuyển đổi sang JSON
     */
    String convertToJson(String xmlData);

    /**
     * Chuyển đổi dữ liệu từ JSON sang XML
     * @param jsonData Dữ liệu JSON cần chuyển đổi
     * @return Dữ liệu sau khi chuyển đổi sang XML
     */
    String convertToXml(String jsonData);
}