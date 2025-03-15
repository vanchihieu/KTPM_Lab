package org.iuh.se.bai2.task;

/**
 * Enum định nghĩa các trạng thái công việc
 */
public enum TaskStatus {
    TO_DO("Cần làm"),
    IN_PROGRESS("Đang thực hiện"),
    REVIEW("Đang kiểm tra"),
    COMPLETED("Hoàn thành");

    private final String description;

    TaskStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}