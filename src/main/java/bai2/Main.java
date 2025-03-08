package bai2;

import bai2.model.Product;
import bai2.strategy.*;

public class Main {
    public static void main(String[] args) {
        // Tạo các chiến lược tính thuế
        TaxStrategy consumptionTax = new ConsumptionTaxStrategy();
        TaxStrategy vatTax = new VATStrategy();
        TaxStrategy luxuryTax = new LuxuryTaxStrategy();
        TaxStrategy noTax = new NoTaxStrategy();

        // Tạo các sản phẩm với các chiến lược thuế khác nhau
        Product rice = new Product("Gạo", 20000, consumptionTax);
        Product laptop = new Product("Laptop", 15000000, vatTax);
        Product luxuryWatch = new Product("Đồng hồ Rolex", 50000000, luxuryTax);
        Product book = new Product("Sách giáo khoa", 30000, noTax);

        // Hiển thị thông tin sản phẩm và thuế
        System.out.println("===== THÔNG TIN SẢN PHẨM VÀ THUẾ =====");
        System.out.println(rice.getProductInfo());
        System.out.println("\n" + laptop.getProductInfo());
        System.out.println("\n" + luxuryWatch.getProductInfo());
        System.out.println("\n" + book.getProductInfo());

        // Thay đổi chiến lược thuế cho một sản phẩm
        System.out.println("\n===== SAU KHI THAY ĐỔI CHÍNH SÁCH THUẾ =====");
        System.out.println("Thay đổi thuế cho Laptop từ VAT sang thuế xa xỉ:");
        laptop.setTaxStrategy(luxuryTax);
        System.out.println(laptop.getProductInfo());

        // Tạo sản phẩm với chiến lược thuế mới
        System.out.println("\n===== TẠO SẢN PHẨM VỚI CHIẾN LƯỢC MỚI =====");
        // Ví dụ: Chiến lược thuế kết hợp có thể được triển khai thêm
        TaxStrategy combinedTax = new TaxStrategy() {
            @Override
            public double calculateTax(double price) {
                // Kết hợp thuế VAT (10%) và thuế tiêu thụ (5%)
                return price * 0.15;
            }

            @Override
            public String getTaxName() {
                return "Thuế kết hợp (VAT + Tiêu thụ)";
            }
        };

        Product smartphone = new Product("Điện thoại", 8000000, combinedTax);
        System.out.println(smartphone.getProductInfo());
    }
}
