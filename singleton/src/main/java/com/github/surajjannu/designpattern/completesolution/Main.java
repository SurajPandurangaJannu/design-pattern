package com.github.surajjannu.designpattern.completesolution;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            final Class<?> aClass = Class.forName("com.github.surajjannu.designpattern.completesolution.Singleton");
            final Constructor<?> constructor = aClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            final Singleton reflectionSingleton = (Singleton) constructor.newInstance();
            print("reflectionSingleton", reflectionSingleton);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(Main::createSingleton);
        executorService.submit(Main::createSingleton);
        executorService.submit(Main::createSingleton);
        executorService.submit(Main::createSingleton);
        executorService.submit(Main::createSingleton);

        final Singleton s1 = Singleton.getInstance();
        print("s1", s1);

        final Singleton s2 = Singleton.getInstance();
        print("s2", s2);

        try {
            final Singleton clonedSingleton = (Singleton) s2.clone();
            print("clonedSingleton", clonedSingleton);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/tmp/s2.txt"));
        objectOutputStream.writeObject(s2);

        final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/tmp/s2.txt"));
        final Singleton deserializedSingleton = (Singleton) objectInputStream.readObject();
        print("deserializedSingleton", deserializedSingleton);

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);

        try {
            final Class<?> aClass = Class.forName("com.github.surajjannu.designpattern.completesolution.Singleton");
            final Constructor<?> constructor = aClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            final Singleton reflectionSingleton = (Singleton) constructor.newInstance();
            print("reflectionSingleton", reflectionSingleton);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void createSingleton() {
        final Singleton singleton = Singleton.getInstance();
        print("Singleton", singleton);
    }

    public static void print(String objectName, Singleton object) {
        System.out.printf("Object %s :: HashCode %d%n", objectName, object.hashCode());
    }
}
