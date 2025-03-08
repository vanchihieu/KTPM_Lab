package bai2.strategy;

/**
 * Chiến lược tính thuế VAT (Giá trị gia tăng)
 */
public class VATStrategy implements TaxStrategy{
    // Tỷ lệ thuế VAT (ví dụ: 10%)
    private final double rate = 0.10;

    @Override
    public double calculateTax(double price) {
        return price * rate;
    }

    @Override
    public String getTaxName() {
        return "Thuế giá trị gia tăng (VAT)";
    }
}
