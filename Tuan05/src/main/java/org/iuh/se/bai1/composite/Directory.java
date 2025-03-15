package org.iuh.se.bai1.composite;

import org.iuh.se.bai1.component.FileSystemItem;

import java.util.ArrayList;
import java.util.List;


/**
 * Composite (hỗn hợp) đại diện cho thư mục
 */
public class Directory implements FileSystemItem {
    private String name;
    private String path;
    private List<FileSystemItem> children;

    public Directory(String name, String path) {
        this.name = name;
        this.path = path;
        this.children = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPath() {
        return path;
    }

    public void add(FileSystemItem item) {
        children.add(item);
    }

    public void remove(FileSystemItem item) {
        children.remove(item);
    }

    public FileSystemItem getChild(int index) {
        return children.get(index);
    }

    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileSystemItem item : children) {
            totalSize += item.getSize();
        }
        return totalSize;
    }

    @Override
    public void display(int depth) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append("  ");
        }

        System.out.println(indent + "+ Directory: " + name + " (Size: " + getSize() + " bytes)");

        // Hiển thị thông tin của các thành phần con
        for (FileSystemItem item : children) {
            item.display(depth + 1);
        }
    }
}