package org.iuh.se.bai3;

/**
 * Lớp XmlDataFormat đại diện cho dữ liệu ở định dạng XML
 */
public class XmlDataFormat {
    private String xmlData;

    /**
     * Constructor tạo đối tượng XmlDataFormat với dữ liệu XML
     * @param xmlData Dữ liệu XML
     */
    public XmlDataFormat(String xmlData) {
        this.xmlData = xmlData;
    }

    /**
     * Constructor mặc định
     */
    public XmlDataFormat() {
        this.xmlData = "";
    }

    /**
     * Lấy dữ liệu XML
     * @return Dữ liệu XML
     */
    public String getXmlData() {
        return xmlData;
    }

    /**
     * Thiết lập dữ liệu XML
     * @param xmlData Dữ liệu XML mới
     */
    public void setXmlData(String xmlData) {
        this.xmlData = xmlData;
    }
}