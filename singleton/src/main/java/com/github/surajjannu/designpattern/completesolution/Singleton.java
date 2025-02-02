package com.github.surajjannu.designpattern.completesolution;

import java.io.ObjectStreamException;
import java.io.Serializable;

public final class Singleton implements Cloneable, Serializable {

    private static volatile Singleton instance = null;
    private static boolean isSingletonObjectCreated = false;

    private Singleton() {
        if (!isSingletonObjectCreated || instance != null) {
            throw new RuntimeException("Cannot create.. Use getInstance()");
        }
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    isSingletonObjectCreated = true;
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone not supported");
    }

    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}
