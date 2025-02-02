package com.github.surajjannu.designpattern.invoker;

import com.github.surajjannu.designpattern.command.Command;

public class KeyBoard {

    public void pressKey(Command command) {
        command.execute();
    }
}
