package com.github.surajjannu.designpattern.example2;

public abstract class LogProcessor {

    private LogProcessor nextProcessor;

    public LogProcessor(LogProcessor logProcessor){
        this.nextProcessor = logProcessor;
    }

    public LogProcessor getNextProcessor() {
        return nextProcessor;
    }

    public abstract void log(LogLevel logLevel,String message);

}
