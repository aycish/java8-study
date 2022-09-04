package me.aycish.designpattern._01_singleton;

import java.io.Serializable;

public class Settings implements Serializable {
    private static Settings instance;
    /* eager initialization : 가벼운 클래스의 경우, synchronized 없이 사용할 수 있는 방법 */
    private static final Settings INSTANCE = new Settings();

    /* double checked locking 방법 */
    private static volatile Settings doubleCheckedInstance;
    private Settings() {}

    /* 생성에 추가적인 작업이 많은 경우*/
    public static synchronized Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }

        return instance;
    }

    /* Eager initialization */
    public static Settings getFinalInstance() {
        return INSTANCE;
    }

    /* double checked locking 사용 */
    public static Settings getDoubleCheckedLocking() {
        if (doubleCheckedInstance == null) {
            synchronized (Settings.class) {
                if (doubleCheckedInstance == null) {
                    doubleCheckedInstance = new Settings();
                }
            }
        }

        return doubleCheckedInstance;
    }

    /* static inner 클래스 사용 */
    private static class SettingsHolder {
        private static final Settings INNER_INSTANCE= new Settings();
    }

    public static  Settings getInnerClassInstance() {
        return SettingsHolder.INNER_INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
