package fr.passwordmanager.controller;

public final class Singleton {

    private static Singleton INSTANCE;
    private char[] info = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Singleton();
        }

        return INSTANCE;
    }

    public static Singleton getINSTANCE() {
        return INSTANCE;
    }

    public static void setINSTANCE(Singleton INSTANCE) {
        Singleton.INSTANCE = INSTANCE;
    }

    public char[] getInfo() {
        return info;
    }

    public void setInfo(char[] info) {
        this.info = info;
    }
}
