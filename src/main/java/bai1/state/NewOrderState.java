package bai1.state;

import bai1.model.Order;

/**
 * Lớp trạng thái cụ thể cho trạng thái Đơn hàng mới
 */
public class NewOrderState implements OrderState{
    @Override
    public void verifyOrder(Order order) {
        System.out.println("Đang kiểm tra thông tin đơn hàng...");
        System.out.println("Thông tin đơn hàng đã được xác minh thành công.");
        order.setState(new ProcessingState());
    }

    @Override
    public void processOrder(Order order) {
        System.out.println("Không thể xử lý đơn hàng cho đến khi nó được xác minh.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Không thể vận chuyển đơn hàng cho đến khi nó được xử lý.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Không thể giao đơn hàng cho đến khi nó được vận chuyển.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Đang hủy đơn hàng...");
        System.out.println("Đơn hàng đã được hủy thành công.");
        order.setState(new CancelledState());
    }

    @Override
    public String getStateName() {
        return "Mới tạo";
    }
}
