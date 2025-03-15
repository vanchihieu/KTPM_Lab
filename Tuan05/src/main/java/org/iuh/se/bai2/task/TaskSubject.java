package org.iuh.se.bai2.task;

import org.iuh.se.bai2.core.Observer;
import org.iuh.se.bai2.core.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject - lớp công việc
 */
public class TaskSubject implements Subject {
    private String taskId;
    private String taskName;
    private TaskStatus status;
    private List<Observer> observers = new ArrayList<>();

    public TaskSubject(String taskId, String taskName, TaskStatus status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("Observer mới đã đăng ký theo dõi công việc " + taskName);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
        System.out.println("Một observer đã hủy đăng ký theo dõi công việc " + taskName);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void setStatus(TaskStatus status) {
        TaskStatus oldStatus = this.status;
        this.status = status;

        System.out.println("Trạng thái công việc " + taskName + " đã thay đổi từ " +
                oldStatus.getDescription() + " thành " + status.getDescription());

        // Thông báo cho tất cả observers khi trạng thái thay đổi
        notifyObservers();
    }

    public TaskStatus getStatus() {
        return status;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }
}