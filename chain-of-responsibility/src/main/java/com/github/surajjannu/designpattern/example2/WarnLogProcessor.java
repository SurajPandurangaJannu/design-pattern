package com.github.surajjannu.designpattern.example2;

public class WarnLogProcessor extends LogProcessor {

    public WarnLogProcessor(LogProcessor logProcessor){
        super(logProcessor);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if (logLevel == LogLevel.WARN){
            System.out.println(LogLevel.WARN + " :: " + message);
        }else {
            if (null != getNextProcessor()){
                getNextProcessor().log(logLevel,message);
            }
        }
    }
}
