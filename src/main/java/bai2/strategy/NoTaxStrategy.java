package bai2.strategy;

/**
 * Chiến lược không tính thuế (cho các sản phẩm được miễn thuế)
 */
public class NoTaxStrategy implements TaxStrategy{
    @Override
    public double calculateTax(double price) {
        return 0;
    }

    @Override
    public String getTaxName() {
        return null;
    }
}
