package com.github.surajjannu.designpattern.example2;

public class ErrorLogProcessor extends LogProcessor {

    public ErrorLogProcessor(LogProcessor logProcessor){
        super(logProcessor);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if (logLevel == LogLevel.ERROR){
            System.out.println(LogLevel.ERROR + " :: " + message);
        }else {
            if (null != getNextProcessor()){
                getNextProcessor().log(logLevel,message);
            }
        }
    }
}
