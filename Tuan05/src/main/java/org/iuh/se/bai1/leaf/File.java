package org.iuh.se.bai1.leaf;

import org.iuh.se.bai1.component.FileSystemItem;

/**
 * Leaf (lá) đại diện cho tập tin đơn giản
 */
/**
 * Leaf (lá) đại diện cho tập tin đơn giản
 */
public class File implements FileSystemItem {
    private String name;
    private String path;
    private long size;

    public File(String name, String path, long size) {
        this.name = name;
        this.path = path;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public void display(int depth) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append("  ");
        }
        System.out.println(indent + "- File: " + name + " (" + size + " bytes)");
    }
}