package bai2.strategy;

/**
 * Chiến lược tính thuế hàng xa xỉ
 */
public class LuxuryTaxStrategy implements TaxStrategy{
    // Tỷ lệ thuế xa xỉ (ví dụ: 20%)
    private final double rate = 0.20;

    @Override
    public double calculateTax(double price) {
        // Với hàng xa xỉ, nếu giá > 1000, áp dụng thêm phí 50
        return price * rate + (price > 1000 ? 50 : 0);
    }

    @Override
    public String getTaxName() {
        return "Thuế hàng xa xỉ";
    }
}
