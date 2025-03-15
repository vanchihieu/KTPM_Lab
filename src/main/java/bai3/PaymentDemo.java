package bai3;

import bai3.concrete.CreditCardPayment;
import bai3.concrete.PayPalPayment;
import bai3.core.Payment;
import bai3.decorator.DiscountDecorator;
import bai3.decorator.InternationalPaymentDecorator;
import bai3.decorator.ProcessingFeeDecorator;
import bai3.system.PaymentSystem;

public class PaymentDemo {
    public static void main(String[] args) {
        // Khởi tạo hệ thống thanh toán
        PaymentSystem paymentSystem = new PaymentSystem("Shop Online ABC");

        // Ví dụ 1: Thanh toán cơ bản bằng thẻ tín dụng
        Payment creditCardPayment = new CreditCardPayment("1234567890123456", "Nguyễn Văn A");
        paymentSystem.processOrder(creditCardPayment, 1000000, "Đơn hàng #1 - Điện thoại Samsung Galaxy");

        // Ví dụ 2: Thanh toán PayPal với phí xử lý
        Payment paypalWithFee = new ProcessingFeeDecorator(
                new PayPalPayment("nguyen.van.b@example.com"), 0.03);
        paymentSystem.processOrder(paypalWithFee, 2000000, "Đơn hàng #2 - Laptop Dell XPS");

        // Ví dụ 3: Thanh toán thẻ tín dụng với mã giảm giá
        Payment creditCardWithDiscount = new DiscountDecorator(
                new CreditCardPayment("9876543210987654", "Trần Thị C"),
                "SUMMER2025", 0.15);
        paymentSystem.processOrder(creditCardWithDiscount, 3000000, "Đơn hàng #3 - Apple iPad");

        // Ví dụ 4: Thanh toán PayPal với cả phí xử lý và mã giảm giá
        Payment complexPayment = new DiscountDecorator(
                new ProcessingFeeDecorator(
                        new PayPalPayment("tran.thi.d@example.com"), 0.02),
                "WELCOME10", 0.10);
        paymentSystem.processOrder(complexPayment, 5000000, "Đơn hàng #4 - Máy ảnh Canon");

        // Ví dụ 5: Thanh toán quốc tế bằng thẻ tín dụng với phí xử lý
        Payment internationalPayment = new ProcessingFeeDecorator(
                new InternationalPaymentDecorator(
                        new CreditCardPayment("4111111111111111", "Lê Văn E"),
                        "USD", 24500),
                0.05);
        paymentSystem.processOrder(internationalPayment, 12250000, "Đơn hàng #5 - Đồng hồ Apple Watch");
    }
}
