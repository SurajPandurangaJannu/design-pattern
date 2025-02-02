package com.github.surajjannu.designpattern.holderpattern;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

    private static boolean allowObjectCreationViaConstructor = false;

    private Singleton() {
        if (!allowObjectCreationViaConstructor) {
            throw new RuntimeException("Cannot create.. Use getInstance()");
        }
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    static class SingletonHolder {

        private static final Singleton instance;

        static {
            Singleton.allowObjectCreationViaConstructor = true;
            instance = new Singleton();
            Singleton.allowObjectCreationViaConstructor = false;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone not supported");
    }

    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}
