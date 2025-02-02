package com.github.surajjannu.designpattern.enumpattern;

public enum Singleton {
    INSTANCE;

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
