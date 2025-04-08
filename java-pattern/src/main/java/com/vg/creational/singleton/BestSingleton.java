package com.vg.creational.singleton;

public class BestSingleton{

    // Private constructor prevents instantiation from other classes
    private BestSingleton() {
        // Optionally prevent reflection-based instantiation
        if (Holder.INSTANCE != null) {
            throw new RuntimeException("Use getInstance() method");
        }
    }

    // Static inner class is loaded only when getInstance() is called
    private static class Holder {
        private static final BestSingleton INSTANCE = new BestSingleton();
    }

    // Global access point
    public static BestSingleton getInstance() {
        return Holder.INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(BestSingleton.getInstance());
        System.out.println(BestSingleton.getInstance());
    }
}
