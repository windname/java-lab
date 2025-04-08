package com.vg.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight
class Font {
    private final String name;
    private final int size;
    private final boolean isBold;

    public Font(String name, int size, boolean isBold) {
        this.name = name;
        this.size = size;
        this.isBold = isBold;
    }

    public void display(String text) {
        System.out.printf("Rendering '%s' with %s %d %s%n",
                text,
                name,
                size,
                isBold ? "[BOLD]" : "");
    }
}

// Flyweight Factory
class FontFactory {
    private static final Map<String, Font> fontPool = new HashMap<>();

    public static Font getFont(String name, int size, boolean isBold) {
        String key = name + size + (isBold ? "B" : "");

        if (!fontPool.containsKey(key)) {
            System.out.printf("-- Creating NEW Font: %s %d %s%n",
                    name, size, isBold ? "[BOLD]" : "");
            fontPool.put(key, new Font(name, size, isBold));
        } else {
            System.out.printf("-- Reusing EXISTING Font: %s %d %s%n",
                    name, size, isBold ? "[BOLD]" : "");
        }

        return fontPool.get(key);
    }

    public static int getPoolSize() {
        return fontPool.size();
    }
}

// Client (Text Character)
class TextCharacter {
    private char character;
    private Font font;

    public TextCharacter(char c, String fontName, int size, boolean isBold) {
        this.character = c;
        this.font = FontFactory.getFont(fontName, size, isBold);
    }

    public void display() {
        font.display(String.valueOf(character));
    }
}

// Demo
public class TextEditor {
    public static void main(String[] args) {
        System.out.println("=== Text Editor with Flyweight Fonts ===\n");

        TextCharacter[] text = {
                new TextCharacter('H', "Arial", 12, false),
                new TextCharacter('e', "Arial", 12, false),
                new TextCharacter('l', "Times New Roman", 14, true),
                new TextCharacter('l', "Times New Roman", 14, true),
                new TextCharacter('o', "Arial", 12, false),
                new TextCharacter('!', "Courier New", 16, false),
                new TextCharacter(' ', "Arial", 12, false),
                new TextCharacter('W', "Arial", 12, true),
                new TextCharacter('o', "Times New Roman", 14, true),
                new TextCharacter('r', "Arial", 12, false),
                new TextCharacter('l', "Arial", 12, false),
                new TextCharacter('d', "Courier New", 16, false)
        };

        System.out.println("\n=== Rendering Text ===");
        for (TextCharacter tc : text) {
            tc.display();
        }

        System.out.printf("%nTotal unique fonts created: %d%n",
                FontFactory.getPoolSize());
    }
}