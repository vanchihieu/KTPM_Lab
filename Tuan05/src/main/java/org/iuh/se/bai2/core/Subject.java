package org.iuh.se.bai2.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject interface - định nghĩa các phương thức cho việc quản lý observers
 */
public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}