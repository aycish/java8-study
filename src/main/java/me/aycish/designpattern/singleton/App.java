package me.aycish.designpattern.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        Settings settings = Settings.getInstance();
        Settings settings1 = Settings.getInstance();
        System.out.println(settings1 == settings);

        /* 싱글톤 파훼법 1 : reflection */
        Constructor<Settings> constructor = Settings.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Settings reflectedSettings = constructor.newInstance();
        System.out.println(reflectedSettings == settings);

        /* 싱글톤 파훼법 2 : Serialize */
        Settings serializedSettings = null;
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            out.writeObject(settings);
        }

        try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
            serializedSettings = (Settings) in.readObject();
        }

        System.out.println(settings == serializedSettings);
    }
}
