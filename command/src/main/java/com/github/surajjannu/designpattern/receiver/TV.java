package com.github.surajjannu.designpattern.receiver;

public class TV implements Device {

    @Override
    public void turnOn() {
        System.out.println("Turning on TV");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off TV");
    }

    @Override
    public void volumeUp() {
        System.out.println("Increasing TV volume");
    }

    @Override
    public void volumeDown() {
        System.out.println("Decreasing TV volume");
    }
}
