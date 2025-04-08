package com.vg.structural.proxy;

// Subject Interface
interface Image {
    void display();
    String getFileName();
}

// Real Subject
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("⏳ Loading high-resolution image: " + fileName);
        // Simulate expensive loading operation
        try { Thread.sleep(1500); } catch (InterruptedException e) {}
    }

    @Override
    public void display() {
        System.out.println("🖼️ Displaying image: " + fileName);
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}

// Proxy
class ImageProxy implements Image {
    private RealImage realImage;
    private String fileName;
    private boolean hasAccess;

    public ImageProxy(String fileName, boolean hasAccess) {
        this.fileName = fileName;
        this.hasAccess = hasAccess;
    }

    @Override
    public void display() {
        if (!hasAccess) {
            System.out.println("⛔ Access denied to image: " + fileName);
            return;
        }

        if (realImage == null) {
            realImage = new RealImage(fileName); // Lazy initialization
        }
        realImage.display();
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    // Additional proxy functionality
    public void grantAccess() {
        this.hasAccess = true;
        System.out.println("🔓 Access granted to image: " + fileName);
    }
}

// Client
public class ImageViewer {
    public static void main(String[] args) {
        System.out.println("=== Image Viewer with Proxy ===");

        // Create proxies (no heavy loading yet)
        Image vacationPhoto = new ImageProxy("vacation.jpg", true);
        Image secretDocument = new ImageProxy("top_secret.png", false);

        System.out.println("\n[First access attempt]");
        vacationPhoto.display(); // Will load and display
        secretDocument.display(); // Access denied

        System.out.println("\n[Granting access and second attempt]");
        ((ImageProxy)secretDocument).grantAccess();
        secretDocument.display(); // Now loads and displays

        System.out.println("\n[Subsequent access]");
        vacationPhoto.display(); // Uses already loaded image
        secretDocument.display(); // Uses already loaded image
    }
}