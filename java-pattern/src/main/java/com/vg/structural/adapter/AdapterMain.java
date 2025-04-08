package com.vg.structural.adapter;

public class AdapterMain {
    public static void main(String[] args) {
        // Create devices
        HdmiSocket projector = new HdmiProjector();
        UsbCable usbCAdapter = new UsbCToHdmiAdapter(projector);

        System.out.println("💻 Laptop with USB-C port trying to connect...");

        // Connect via adapter
        usbCAdapter.connectUsbC();
    }
}

// 1. Target Interface (HDMI)
interface HdmiSocket {
    void connectHdmi();
}

// 2. Adaptee (HDMI Projector)
class HdmiProjector implements HdmiSocket {
    @Override
    public void connectHdmi() {
        System.out.println("✅ Projector connected via HDMI");
    }
}

// 3. Client Interface (USB-C)
interface UsbCable {
    void connectUsbC();
}

// 4. Adapter (USB-C to HDMI)
class UsbCToHdmiAdapter implements UsbCable {
    private final HdmiSocket hdmiDevice;

    public UsbCToHdmiAdapter(HdmiSocket hdmiDevice) {
        this.hdmiDevice = hdmiDevice;
    }

    @Override
    public void connectUsbC() {
        System.out.println("🔌 Adapter: Converting USB-C signal to HDMI");
        hdmiDevice.connectHdmi();
    }
}
