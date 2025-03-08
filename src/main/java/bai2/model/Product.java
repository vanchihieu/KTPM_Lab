package bai2.model;

import bai2.strategy.TaxStrategy;

public class Product {
    private String name;
    private double price;
    private TaxStrategy taxStrategy;

    public Product(String name, double price, TaxStrategy taxStrategy) {
        this.name = name;
        this.price = price;
        this.taxStrategy = taxStrategy;
    }

    /**
     * Tính toán thuế cho sản phẩm
     * @return Số tiền thuế
     */
    public double calculateTax() {
        return taxStrategy.calculateTax(price);
    }

    /**
     * Tính giá cuối cùng bao gồm thuế
     * @return Tổng giá bao gồm thuế
     */
    public double getFinalPrice() {
        return price + calculateTax();
    }

    /**
     * Thay đổi chiến lược tính thuế
     * @param taxStrategy Chiến lược thuế mới
     */
    public void setTaxStrategy(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }

    /**
     * Lấy thông tin sản phẩm
     * @return Thông tin về sản phẩm và thuế
     */
    public String getProductInfo() {
        return String.format("Sản phẩm: %s\n" +
                        "Giá gốc: %.2f VND\n" +
                        "Loại thuế: %s\n" +
                        "Thuế: %.2f VND\n" +
                        "Giá sau thuế: %.2f VND",
                name, price, taxStrategy.getTaxName(), calculateTax(), getFinalPrice());
    }

    // Getters và setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TaxStrategy getTaxStrategy() {
        return taxStrategy;
    }
}
