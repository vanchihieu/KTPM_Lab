package bai2.strategy;

/**
 * Interface chiến lược tính thuế
 * Định nghĩa một phương thức chung để tính thuế
 */
public interface TaxStrategy {
    /**
     * Tính thuế cho sản phẩm dựa trên giá
     * @param price Giá sản phẩm
     * @return Số tiền thuế
     */
    double calculateTax(double price);

    /**
     * Lấy tên của chiến lược thuế
     * @return Tên chiến lược thuế
     */
    String getTaxName();
}
