package com.github.surajjannu.designpattern.invoker;

import com.github.surajjannu.designpattern.command.Command;

public class RemoteControl {

    public void pressButton(Command command) {
        command.execute();
    }
}
