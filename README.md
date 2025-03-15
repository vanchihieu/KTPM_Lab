# Bộ sưu tập Design Patterns trong Java

Repository này chứa triển khai của ba mẫu thiết kế phổ biến trong Java: State, Strategy và Decorator. Mỗi mẫu thiết kế được minh họa thông qua một ứng dụng thực tế để giúp hiểu rõ hơn về cách triển khai và ứng dụng các mẫu thiết kế này.

## 1. State Pattern - Hệ thống quản lý đơn hàng

### Mô tả
Hệ thống quản lý đơn hàng với các trạng thái khác nhau (Mới tạo, Đang xử lý, Đang vận chuyển, Đã giao, Đã hủy). Mỗi trạng thái có các hành vi riêng biệt và các quy tắc chuyển đổi trạng thái.

### Các lớp chính
- **OrderState**: Interface định nghĩa các hành vi của đơn hàng
- **NewOrderState, ProcessingState, ShippingState, DeliveredState, CancelledState**: Các lớp triển khai trạng thái cụ thể
- **Order**: Lớp context, duy trì trạng thái hiện tại và ủy quyền hành vi

### Ưu điểm
- Tách biệt logic xử lý cho mỗi trạng thái
- Dễ dàng thêm trạng thái mới mà không ảnh hưởng đến code hiện có
- Loại bỏ các câu lệnh điều kiện phức tạp
- Đảm bảo các chuyển đổi trạng thái hợp lệ

### Chạy ứng dụng
- ![Image](https://github.com/user-attachments/assets/0c44a26e-b926-477a-86f4-050fe7f2015d)

## 2. Strategy Pattern - Hệ thống tính thuế sản phẩm

### Mô tả
Hệ thống tính toán thuế cho các sản phẩm khác nhau với các chiến lược tính thuế đa dạng (thuế tiêu thụ, thuế VAT, thuế hàng xa xỉ, miễn thuế).

### Các lớp chính
- **TaxStrategy**: Interface định nghĩa phương thức tính thuế
- **ConsumptionTaxStrategy, VATStrategy, LuxuryTaxStrategy, NoTaxStrategy**: Các chiến lược tính thuế cụ thể
- **Product**: Lớp sản phẩm sử dụng chiến lược thuế

### Ưu điểm
- Tách biệt các thuật toán tính thuế khỏi lớp sản phẩm
- Linh hoạt thay đổi chiến lược tính thuế trong thời gian chạy
- Dễ dàng thêm các chiến lược tính thuế mới
- Tuân thủ nguyên tắc đơn trách nhiệm

### Chạy ứng dụng
- ![Image](https://github.com/user-attachments/assets/75092208-4d6f-437a-9f9d-a7780ce993af)

## 3. Decorator Pattern - Hệ thống thanh toán

### Mô tả
Hệ thống thanh toán hỗ trợ nhiều phương thức thanh toán (Thẻ tín dụng, PayPal) và cho phép thêm các tính năng bổ sung (phí xử lý, mã giảm giá, thanh toán quốc tế).

### Các lớp chính
- **Payment**: Interface cho tất cả các phương thức thanh toán
- **CreditCardPayment, PayPalPayment**: Các phương thức thanh toán cơ bản
- **PaymentDecorator**: Lớp decorator trừu tượng
- **ProcessingFeeDecorator, DiscountDecorator, InternationalPaymentDecorator**: Các decorator cụ thể
- **PaymentSystem**: Lớp xử lý các giao dịch thanh toán

### Ưu điểm
- Linh hoạt kết hợp các tính năng thanh toán
- Mở rộng chức năng mà không cần sửa đổi code hiện có
- Kết hợp nhiều tính năng theo nhiều cách khác nhau
- Tuân thủ nguyên tắc đóng mở (Open-Closed Principle)

### Chạy ứng dụng
- ![Image](https://github.com/user-attachments/assets/c803f021-032d-461a-a40f-283f4e0e0c72)