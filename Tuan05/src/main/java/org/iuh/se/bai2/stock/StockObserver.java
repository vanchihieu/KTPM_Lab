package org.iuh.se.bai2.stock;

import org.iuh.se.bai2.core.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Observer - lớp nhà đầu tư
 */
public class StockObserver implements Observer {
    private String name;
    private List<StockSubject> observedStocks = new ArrayList<>();

    public StockObserver(String name) {
        this.name = name;
    }

    public void addStock(StockSubject stock) {
        observedStocks.add(stock);
        stock.attach(this);
    }

    public void removeStock(StockSubject stock) {
        observedStocks.remove(stock);
        stock.detach(this);
    }

    @Override
    public void update(Object data) {
        if (data instanceof StockSubject) {
            StockSubject stock = (StockSubject) data;
            System.out.println("Thông báo cho nhà đầu tư " + name +
                    ": Cổ phiếu " + stock.getSymbol() +
                    " hiện có giá mới là $" + stock.getPrice());
        }
    }

    public String getName() {
        return name;
    }
}
