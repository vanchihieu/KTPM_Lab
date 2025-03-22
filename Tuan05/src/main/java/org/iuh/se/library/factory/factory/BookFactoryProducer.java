package org.iuh.se.library.factory.factory;

/**
 * Lớp tạo các factory phù hợp dựa vào loại sách
         */
public class BookFactoryProducer {
    public static BookFactory getFactory(String bookType) {
        if (bookType == null) {
            return null;
        }

        if (bookType.equalsIgnoreCase("PHYSICAL")) {
            return new PhysicalBookFactory();
        } else if (bookType.equalsIgnoreCase("ELECTRONIC")) {
            return new ElectronicBookFactory();
        } else if (bookType.equalsIgnoreCase("AUDIO")) {
            return new AudioBookFactory();
        }

        return null;
    }
}