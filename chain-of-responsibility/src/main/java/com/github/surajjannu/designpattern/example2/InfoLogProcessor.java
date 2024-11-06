package com.github.surajjannu.designpattern.example2;

public class InfoLogProcessor extends LogProcessor {

    public InfoLogProcessor(LogProcessor logProcessor){
        super(logProcessor);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if (logLevel == LogLevel.INFO){
            System.out.println(LogLevel.INFO + " :: " + message);
        }else {
            if (null != getNextProcessor()){
                getNextProcessor().log(logLevel,message);
            }
        }
    }
}
