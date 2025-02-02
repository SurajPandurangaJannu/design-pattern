package com.github.surajjannu.designpattern.concretecommand;

import com.github.surajjannu.designpattern.command.Command;
import com.github.surajjannu.designpattern.receiver.Device;

public class VolumeDownCommand implements Command {
    private final Device device;

    public VolumeDownCommand(Device device){
        this.device = device;
    }

    @Override
    public void execute() {
        device.volumeDown();
    }
}
