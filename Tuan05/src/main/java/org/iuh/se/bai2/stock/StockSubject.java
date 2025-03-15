package org.iuh.se.bai2.stock;

import org.iuh.se.bai2.core.Observer;
import org.iuh.se.bai2.core.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject - lớp cổ phiếu
 */
public class StockSubject implements Subject {
    private String symbol;
    private double price;
    private List<Observer> observers = new ArrayList<>();

    public StockSubject(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("Observer mới đã đăng ký theo dõi cổ phiếu " + symbol);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
        System.out.println("Một observer đã hủy đăng ký theo dõi cổ phiếu " + symbol);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void setPrice(double price) {
        double oldPrice = this.price;
        this.price = price;

        System.out.println("Giá cổ phiếu " + symbol + " đã thay đổi từ " +
                oldPrice + " thành " + price);

        // Thông báo cho tất cả observers khi giá thay đổi
        notifyObservers();
    }

    public double getPrice() {
        return price;
    }

    public String getSymbol() {
        return symbol;
    }
}