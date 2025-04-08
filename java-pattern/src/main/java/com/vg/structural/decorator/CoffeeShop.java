package com.vg.structural.decorator;

// Component Interface
interface Coffee {
    String getDescription();
    double getCost();
}

// Concrete Component
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple coffee";
    }

    @Override
    public double getCost() {
        return 2.00;
    }
}

// Base Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + " + milk";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.50;
    }
}

class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + " + whipped cream";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.75;
    }
}

class CaramelDecorator extends CoffeeDecorator {
    public CaramelDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + " + caramel";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.65;
    }
}

// Client
public class CoffeeShop {
    public static void main(String[] args) {
        // Base coffee
        Coffee coffee = new SimpleCoffee();
        printCoffee(coffee);

        // Add milk
        coffee = new MilkDecorator(coffee);
        printCoffee(coffee);

        // Add whipped cream
        coffee = new WhippedCreamDecorator(coffee);
        printCoffee(coffee);

        // Add caramel (fancy coffee!)
        coffee = new CaramelDecorator(coffee);
        printCoffee(coffee);
    }

    private static void printCoffee(Coffee coffee) {
        System.out.printf("%-40s $%.2f%n",
                coffee.getDescription(),
                coffee.getCost());
    }
}