package com.github.surajjannu.designpattern;

public class ChocolateDecorator extends CoffeeDecorator {

    public ChocolateDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() +", Chocolate";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 15;
    }
}
