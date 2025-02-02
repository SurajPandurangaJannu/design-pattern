package com.github.surajjannu.designpattern;

import com.github.surajjannu.designpattern.command.Command;
import com.github.surajjannu.designpattern.concretecommand.TurnOffCommand;
import com.github.surajjannu.designpattern.concretecommand.TurnOnCommand;
import com.github.surajjannu.designpattern.concretecommand.VolumeDownCommand;
import com.github.surajjannu.designpattern.concretecommand.VolumeUpCommand;
import com.github.surajjannu.designpattern.invoker.KeyBoard;
import com.github.surajjannu.designpattern.invoker.RemoteControl;
import com.github.surajjannu.designpattern.receiver.Device;
import com.github.surajjannu.designpattern.receiver.Laptop;
import com.github.surajjannu.designpattern.receiver.TV;

public class Main {

    public static void main(String[] args) {
        final RemoteControl remoteInvoker = new RemoteControl();
        final Device tvReceiver = new TV();
        final Command tvTurnOnCommand = new TurnOnCommand(tvReceiver);
        final Command tvTurnOffCommand = new TurnOffCommand(tvReceiver);
        final Command tvVolumeUpCommand = new VolumeUpCommand(tvReceiver);
        final Command tvVolumeDownCommand = new VolumeDownCommand(tvReceiver);
        remoteInvoker.pressButton(tvTurnOnCommand);
        remoteInvoker.pressButton(tvVolumeUpCommand);
        remoteInvoker.pressButton(tvVolumeDownCommand);
        remoteInvoker.pressButton(tvTurnOffCommand);

        final KeyBoard keyBoardInvoker = new KeyBoard();
        final Device laptopReceiver = new Laptop();
        final Command laptopTurnOnCommand = new TurnOnCommand(laptopReceiver);
        final Command laptopTurnOffCommand = new TurnOffCommand(laptopReceiver);
        final Command laptopVolumeUpCommand = new VolumeUpCommand(laptopReceiver);
        final Command laptopVolumeDownCommand = new VolumeDownCommand(laptopReceiver);
        keyBoardInvoker.pressKey(laptopTurnOnCommand);
        keyBoardInvoker.pressKey(laptopVolumeUpCommand);
        keyBoardInvoker.pressKey(laptopVolumeDownCommand);
        keyBoardInvoker.pressKey(laptopTurnOffCommand);
    }
}
