package bai1.state;

import bai1.model.Order;

/**
 * Lớp trạng thái cụ thể cho trạng thái Đang xử lý
 */
public class ProcessingState implements OrderState{
    @Override
    public void verifyOrder(Order order) {
        System.out.println("Đơn hàng đã được xác minh rồi.");
    }

    @Override
    public void processOrder(Order order) {
        System.out.println("Đang xử lý đơn hàng...");
        System.out.println("Đóng gói các sản phẩm...");
        System.out.println("Đơn hàng đã được xử lý thành công.");
        order.setState(new ShippingState());
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Không thể vận chuyển đơn hàng cho đến khi nó được xử lý xong.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Không thể giao đơn hàng cho đến khi nó được vận chuyển.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Đang hủy đơn hàng...");
        System.out.println("Đơn hàng đã được hủy thành công và tiền sẽ được hoàn lại.");
        order.setState(new CancelledState());
    }

    @Override
    public String getStateName() {
        return "Đang xử lý";
    }
}
