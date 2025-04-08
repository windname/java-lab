package com.vg.structural.composite;

import java.util.ArrayList;
import java.util.List;

// Component
interface FileSystemItem {
    void delete();
    String getName();
    void print(String indent);
}

// Leaf
class File implements FileSystemItem {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void delete() {
        System.out.println("Deleting file: " + name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "📄 " + name);
    }
}

// Composite
class Folder implements FileSystemItem {
    private String name;
    private List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemItem item) {
        children.add(item);
    }

    public void remove(FileSystemItem item) {
        children.remove(item);
    }

    @Override
    public void delete() {
        System.out.println("Deleting folder: " + name);
        for (FileSystemItem item : children) {
            item.delete();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "📁 " + name);
        for (FileSystemItem item : children) {
            item.print(indent + "    ");
        }
    }
}

// Client
public class FileSystemDemo {
    public static void main(String[] args) {
        // Create files
        FileSystemItem file1 = new File("Document.txt");
        FileSystemItem file2 = new File("Image.jpg");
        FileSystemItem file3 = new File("Spreadsheet.xlsx");

        // Create subfolder
        Folder subfolder = new Folder("My Files");
        subfolder.add(file1);
        subfolder.add(file2);

        // Create root folder
        Folder root = new Folder("Root");
        root.add(subfolder);
        root.add(file3);

        // Print structure
        System.out.println("File System Structure:");
        root.print("");

        // Delete operation
        System.out.println("\nDeleting 'My Files' folder:");
        subfolder.delete();
    }
}