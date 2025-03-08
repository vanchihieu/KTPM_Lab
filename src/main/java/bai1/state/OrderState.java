package bai1.state;

import bai1.model.Order;

public interface OrderState {
    void verifyOrder(Order order);
    void processOrder(Order order);
    void shipOrder(Order order);
    void deliverOrder(Order order);
    void cancelOrder(Order order);
    String getStateName();
}
