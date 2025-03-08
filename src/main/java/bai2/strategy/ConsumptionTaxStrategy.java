package bai2.strategy;

/**
 * Chiến lược tính thuế tiêu thụ
 */
public class ConsumptionTaxStrategy implements TaxStrategy{
    // Tỷ lệ thuế tiêu thụ (ví dụ: 5%)
    private final double rate = 0.05;

    @Override
    public double calculateTax(double price) {
        return price * rate;
    }

    @Override
    public String getTaxName() {
        return "Thuế tiêu thụ";
    }
}
