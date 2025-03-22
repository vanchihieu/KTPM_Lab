package org.iuh.se.bai3;

import org.json.JSONObject;
import org.json.XML;

/**
 * Lớp DataConverterImpl triển khai giao diện DataConverter
 * sử dụng thư viện org.json để thực hiện việc chuyển đổi
 */
public class DataConverterImpl implements DataConverter {
    /**
     * Thuộc tính xác định độ sâu khi chuyển đổi tài liệu XML phức tạp
     */
    private static final int PRETTY_PRINT_INDENT_FACTOR = 4;

    /**
     * Chuyển đổi dữ liệu từ XML sang JSON
     * @param xmlData Dữ liệu XML cần chuyển đổi
     * @return Dữ liệu sau khi chuyển đổi sang JSON
     */
    @Override
    public String convertToJson(String xmlData) {
        try {
            JSONObject jsonData = XML.toJSONObject(xmlData);
            return jsonData.toString(PRETTY_PRINT_INDENT_FACTOR);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi chuyển đổi XML sang JSON", e);
        }
    }

    /**
     * Chuyển đổi dữ liệu từ JSON sang XML
     * @param jsonData Dữ liệu JSON cần chuyển đổi
     * @return Dữ liệu sau khi chuyển đổi sang XML
     */
    @Override
    public String convertToXml(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return XML.toString(jsonObject);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi chuyển đổi JSON sang XML", e);
        }
    }
}