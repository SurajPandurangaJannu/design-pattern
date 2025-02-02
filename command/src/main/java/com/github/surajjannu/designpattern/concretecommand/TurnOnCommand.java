package com.github.surajjannu.designpattern.concretecommand;

import com.github.surajjannu.designpattern.command.Command;
import com.github.surajjannu.designpattern.receiver.Device;

public class TurnOnCommand implements Command {
    private final Device device;

    public TurnOnCommand(Device device){
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}
