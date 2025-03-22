package org.iuh.se.bai3;

/**
 * Lớp DataAdapter đóng vai trò Adapter, chuyển đổi giữa định dạng XML và JSON
 */
public class DataAdapter {
    private DataConverter converter;

    /**
     * Constructor tạo DataAdapter với một DataConverter cụ thể
     * @param converter Bộ chuyển đổi dữ liệu
     */
    public DataAdapter(DataConverter converter) {
        this.converter = converter;
    }

    /**
     * Chuyển đổi từ định dạng XML sang JSON
     * @param xmlDataFormat Đối tượng chứa dữ liệu XML
     * @return Đối tượng JsonDataFormat sau khi chuyển đổi
     */
    public JsonDataFormat convertToJson(XmlDataFormat xmlDataFormat) {
        String xmlData = xmlDataFormat.getXmlData();
        String jsonData = converter.convertToJson(xmlData);
        return new JsonDataFormat(jsonData);
    }

    /**
     * Chuyển đổi từ định dạng JSON sang XML
     * @param jsonDataFormat Đối tượng chứa dữ liệu JSON
     * @return Đối tượng XmlDataFormat sau khi chuyển đổi
     */
    public XmlDataFormat convertToXml(JsonDataFormat jsonDataFormat) {
        String jsonData = jsonDataFormat.getJsonData();
        String xmlData = converter.convertToXml(jsonData);
        return new XmlDataFormat(xmlData);
    }
}