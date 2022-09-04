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

        /* 리플렉션 파훼법 막아보기 : enum */
        EnumSettings enumSettings = EnumSettings.INSTANCE;
        // 생성자를 가져오지 못한다.
        /* Constructor<EnumSettings> constructor1 = EnumSettings.class.getConstructor();
        constructor1.setAccessible(true);
        EnumSettings reflectedEnumSettings = constructor1.newInstance(); */

        EnumSettings reflectedEnumSettings = null;
        Constructor<?>[] declaredConstructors = EnumSettings.class.getDeclaredConstructors();
        for (Constructor<?> cons : declaredConstructors) {
            cons.setAccessible(true);
            reflectedEnumSettings = (EnumSettings) cons.newInstance("INSTANCE");
        }

        System.out.println(enumSettings == reflectedEnumSettings);
    }
}
