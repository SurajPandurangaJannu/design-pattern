package com.github.surajjannu.designpattern.enumpattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {
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

        final Singleton reflectionSingleton = Enum.valueOf(Singleton.class, "INSTANCE");
        print("reflectionSingleton", reflectionSingleton);

        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/tmp/s2.txt"));
        objectOutputStream.writeObject(s2);

        final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/tmp/s2.txt"));
        Singleton serializableSingleton = (Singleton) objectInputStream.readObject();
        print("serializableSingleton", serializableSingleton);

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);
    }

    private static void createSingleton() {
        final Singleton singleton = Singleton.getInstance();
        print("Singleton", singleton);
    }

    public static void print(String objectName, Singleton object) {
        System.out.printf("Object %s :: HashCode %d%n", objectName, object.hashCode());
    }
}
