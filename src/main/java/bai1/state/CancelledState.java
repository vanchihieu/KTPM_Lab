package bai1.state;

import bai1.model.Order;

/**
 * Lớp trạng thái cụ thể cho trạng thái Đã hủy
 */
public class CancelledState implements OrderState{
    @Override
    public void verifyOrder(Order order) {
        System.out.println("Không thể xác minh đơn hàng đã bị hủy.");
    }

    @Override
    public void processOrder(Order order) {
        System.out.println("Không thể xử lý đơn hàng đã bị hủy.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Không thể vận chuyển đơn hàng đã bị hủy.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Không thể giao đơn hàng đã bị hủy.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Đơn hàng đã bị hủy rồi.");
    }

    @Override
    public String getStateName() {
        return "Đã hủy";
    }
}
