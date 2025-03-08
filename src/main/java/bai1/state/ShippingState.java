package bai1.state;

import bai1.model.Order;

/**
 * Lớp trạng thái cụ thể cho trạng thái Đang vận chuyển
 */
public class ShippingState implements OrderState{
    @Override
    public void verifyOrder(Order order) {
        System.out.println("Đơn hàng đã được xác minh rồi.");
    }

    @Override
    public void processOrder(Order order) {
        System.out.println("Đơn hàng đã được xử lý rồi.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Đang vận chuyển đơn hàng...");
        System.out.println("Đơn hàng đang được giao đến địa chỉ của bạn.");
        System.out.println("Đơn hàng đã được vận chuyển thành công.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Đang giao đơn hàng...");
        System.out.println("Đơn hàng đã được giao thành công.");
        order.setState(new DeliveredState());
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Không thể hủy đơn hàng vì nó đã được vận chuyển.");
    }

    @Override
    public String getStateName() {
        return "Đang vận chuyển";
    }
}
