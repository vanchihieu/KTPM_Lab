package bai1.state;

import bai1.model.Order;

/**
 * Lớp trạng thái cụ thể cho trạng thái Đã giao
 */
public class DeliveredState implements OrderState{
    @Override
    public void verifyOrder(Order order) {
        System.out.println("Đơn hàng đã được giao rồi.");
    }

    @Override
    public void processOrder(Order order) {
        System.out.println("Đơn hàng đã được giao rồi.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Đơn hàng đã được giao rồi.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Đơn hàng đã được giao rồi.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Không thể hủy đơn hàng vì nó đã được giao.");
    }

    @Override
    public String getStateName() {
        return "Đã giao";
    }
}
