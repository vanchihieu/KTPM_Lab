package org.iuh.se.bai2.task;

import org.iuh.se.bai2.core.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Observer - lớp thành viên dự án
 */
public class TaskObserver implements Observer {
    private String name;
    private List<TaskSubject> observedTasks = new ArrayList<>();

    public TaskObserver(String name) {
        this.name = name;
    }

    public void addTask(TaskSubject task) {
        observedTasks.add(task);
        task.attach(this);
    }

    public void removeTask(TaskSubject task) {
        observedTasks.remove(task);
        task.detach(this);
    }

    @Override
    public void update(Object data) {
        if (data instanceof TaskSubject) {
            TaskSubject task = (TaskSubject) data;
            System.out.println("Thông báo cho thành viên " + name +
                    ": Công việc '" + task.getTaskName() + "' (ID: " + task.getTaskId() +
                    ") đã chuyển sang trạng thái: " + task.getStatus().getDescription());
        }
    }

    public String getName() {
        return name;
    }
}