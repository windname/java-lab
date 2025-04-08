package com.vg.structural.bridge;

// Implementation Hierarchy (TV Brands)
interface TV {
    void on();
    void off();
    void setChannel(int channel);
}

class SonyTV implements TV {
    @Override
    public void on() {
        System.out.println("Sony TV: Powered ON");
    }

    @Override
    public void off() {
        System.out.println("Sony TV: Powered OFF");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Sony TV: Switching to channel " + channel);
    }
}

class SamsungTV implements TV {
    @Override
    public void on() {
        System.out.println("Samsung TV: Welcome (Powered ON)");
    }

    @Override
    public void off() {
        System.out.println("Samsung TV: Goodbye (Powered OFF)");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Samsung TV: Tuned to channel " + channel);
    }
}

// Abstraction Hierarchy (Remote Controls)
abstract class RemoteControl {
    protected TV tv;

    protected RemoteControl(TV tv) {
        this.tv = tv;
    }

    abstract void turnOn();
    abstract void turnOff();
    abstract void setChannel(int channel);
}

class BasicRemote extends RemoteControl {
    public BasicRemote(TV tv) {
        super(tv);
    }

    @Override
    public void turnOn() {
        System.out.print("Basic Remote: ");
        tv.on();
    }

    @Override
    public void turnOff() {
        System.out.print("Basic Remote: ");
        tv.off();
    }

    @Override
    public void setChannel(int channel) {
        System.out.print("Basic Remote: ");
        tv.setChannel(channel);
    }
}

class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(TV tv) {
        super(tv);
    }

    @Override
    public void turnOn() {
        System.out.print("Advanced Remote (Voice): ");
        tv.on();
    }

    @Override
    public void turnOff() {
        System.out.print("Advanced Remote (Voice): ");
        tv.off();
    }

    @Override
    public void setChannel(int channel) {
        System.out.print("Advanced Remote: ");
        tv.setChannel(channel);
    }

    public void mute() {
        System.out.println("Advanced Remote: Sound muted");
    }
}

// Main Class
public class BridgeDemo {
    public static void main(String[] args) {
        System.out.println("=== Testing Sony TV with Basic Remote ===");
        TV sony = new SonyTV();
        RemoteControl basicRemote = new BasicRemote(sony);
        basicRemote.turnOn();
        basicRemote.setChannel(5);
        basicRemote.turnOff();

        System.out.println("\n=== Testing Samsung TV with Advanced Remote ===");
        TV samsung = new SamsungTV();
        AdvancedRemote advancedRemote = new AdvancedRemote(samsung);
        advancedRemote.turnOn();
        advancedRemote.setChannel(42);
        advancedRemote.mute();
        advancedRemote.turnOff();
    }
}