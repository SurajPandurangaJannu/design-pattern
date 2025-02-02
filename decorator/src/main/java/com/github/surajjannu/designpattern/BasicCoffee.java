package com.github.surajjannu.designpattern;

public class BasicCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Coffee";
    }

    @Override
    public double getCost() {
        return 15;
    }
}
