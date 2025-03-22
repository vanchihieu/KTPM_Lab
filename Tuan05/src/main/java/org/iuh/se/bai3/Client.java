package org.iuh.se.bai3;

/**
 * Lớp Client minh họa cách sử dụng DataAdapter
 */
public class Client {
    public static void main(String[] args) {
        // Tạo một DataConverter cụ thể
        DataConverter converter = new DataConverterImpl();

        // Tạo adapter
        DataAdapter adapter = new DataAdapter(converter);

        // Dữ liệu XML mẫu
        String xmlSample = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<user>" +
                "    <id>1</id>" +
                "    <name>Nguyễn Văn A</name>" +
                "    <email>nguyenvana@example.com</email>" +
                "    <roles>" +
                "        <role>admin</role>" +
                "        <role>user</role>" +
                "    </roles>" +
                "</user>";

        // Tạo đối tượng XmlDataFormat
        XmlDataFormat xmlDataFormat = new XmlDataFormat(xmlSample);
        System.out.println("Dữ liệu XML ban đầu:");
        System.out.println(xmlDataFormat.getXmlData());

        // Chuyển đổi XML sang JSON
        JsonDataFormat jsonDataFormat = adapter.convertToJson(xmlDataFormat);
        System.out.println("\nSau khi chuyển đổi sang JSON:");
        System.out.println(jsonDataFormat.getJsonData());

        // Chuyển đổi JSON trở lại XML
        XmlDataFormat convertedBackXml = adapter.convertToXml(jsonDataFormat);
        System.out.println("\nSau khi chuyển đổi trở lại XML:");
        System.out.println(convertedBackXml.getXmlData());
    }
}