package bai1.model;

import bai1.state.NewOrderState;
import bai1.state.OrderState;

public class Order {
    private OrderState state;
    private String orderId;

    public Order(String orderId) {
        // Trạng thái ban đầu là Mới tạo
        this.state = new NewOrderState();
        this.orderId = orderId;
    }

    public void setState(OrderState state) {
        this.state = state;
        System.out.println("Đơn hàng " + orderId + " đã chuyển sang trạng thái: " + state.getStateName());
    }

    public OrderState getState() {
        return state;
    }

    public void verifyOrder() {
        System.out.println("\nĐang cố gắng xác minh đơn hàng " + orderId + "...");
        state.verifyOrder(this);
    }

    public void processOrder() {
        System.out.println("\nĐang cố gắng xử lý đơn hàng " + orderId + "...");
        state.processOrder(this);
    }

    public void shipOrder() {
        System.out.println("\nĐang cố gắng vận chuyển đơn hàng " + orderId + "...");
        state.shipOrder(this);
    }

    public void deliverOrder() {
        System.out.println("\nĐang cố gắng giao đơn hàng " + orderId + "...");
        state.deliverOrder(this);
    }

    public void cancelOrder() {
        System.out.println("\nĐang cố gắng hủy đơn hàng " + orderId + "...");
        state.cancelOrder(this);
    }

    public String getOrderId() {
        return orderId;
    }
}
