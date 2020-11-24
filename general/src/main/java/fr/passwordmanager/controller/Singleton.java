package fr.passwordmanager.controller;

import fr.passwordmanager.model.Password;

import java.util.ArrayList;
import java.util.List;

public final class Singleton {

    private static Singleton INSTANCE;
    private char[] info = null;
    private List<Password> passwordList = new ArrayList<>();

    private Singleton() {
    }

    public static Singleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Singleton();
        }

        return INSTANCE;
    }

    public char[] getInfo() {
        return info;
    }

    public void setInfo(char[] info) {
        this.info = info;
    }

    public List<Password> getPasswordList() {
        return passwordList;
    }

    public void setPasswordList(List<Password> passwordlist) {
        this.passwordList = passwordlist;
    }
}
