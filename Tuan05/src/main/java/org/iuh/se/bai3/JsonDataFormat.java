package org.iuh.se.bai3;

/**
 * Lớp JsonDataFormat đại diện cho dữ liệu ở định dạng JSON
 */
public class JsonDataFormat {
    private String jsonData;

    /**
     * Constructor tạo đối tượng JsonDataFormat với dữ liệu JSON
     * @param jsonData Dữ liệu JSON
     */
    public JsonDataFormat(String jsonData) {
        this.jsonData = jsonData;
    }

    /**
     * Constructor mặc định
     */
    public JsonDataFormat() {
        this.jsonData = "";
    }

    /**
     * Lấy dữ liệu JSON
     * @return Dữ liệu JSON
     */
    public String getJsonData() {
        return jsonData;
    }

    /**
     * Thiết lập dữ liệu JSON
     * @param jsonData Dữ liệu JSON mới
     */
    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}