package org.iuh.se.bai1;

import org.iuh.se.bai1.composite.Directory;
import org.iuh.se.bai1.leaf.File;

public class Main {
    public static void main(String[] args) {
        // Tạo cấu trúc thư mục
        Directory root = new Directory("Root", "/");

        // Tạo thư mục con
        Directory pictures = new Directory("Pictures", "/Pictures");
        Directory documents = new Directory("Documents", "/Documents");
        Directory downloads = new Directory("Downloads", "/Downloads");

        // Tạo thư mục con trong Pictures
        Directory vacation = new Directory("Vacation", "/Pictures/Vacation");

        // Tạo tập tin
        File readme = new File("readme.txt", "/readme.txt", 1024);
        File photo1 = new File("photo1.jpg", "/Pictures/photo1.jpg", 2048);
        File photo2 = new File("photo2.jpg", "/Pictures/Vacation/photo2.jpg", 3072);
        File document1 = new File("document1.pdf", "/Documents/document1.pdf", 5120);
        File music = new File("song.mp3", "/Downloads/song.mp3", 10240);

        // Xây dựng cấu trúc cây
        root.add(readme);
        root.add(pictures);
        root.add(documents);
        root.add(downloads);

        pictures.add(photo1);
        pictures.add(vacation);
        vacation.add(photo2);

        documents.add(document1);
        downloads.add(music);

        // Hiển thị cấu trúc cây
        System.out.println("=== File System Structure ===");
        root.display(0);

        // Hiển thị kích thước tổng
        System.out.println("\nTotal size: " + root.getSize() + " bytes");
    }
}