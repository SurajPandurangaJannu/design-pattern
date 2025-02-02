package com.github.surajjannu.designpattern.receiver;

public class Laptop implements Device{

    @Override
    public void turnOn() {
        System.out.println("Turning on Laptop");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off Laptop");
    }

    @Override
    public void volumeUp() {
        System.out.println("Increasing Laptop volume");
    }

    @Override
    public void volumeDown() {
        System.out.println("Decreasing Laptop volume");
    }
}
