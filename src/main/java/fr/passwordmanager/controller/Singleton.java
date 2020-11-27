package fr.passwordmanager.controller;

import fr.passwordmanager.model.Password;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Classe qui garantit qu'il n'y aura qu'une seule instance pour récupérer une donnée dans tous les fichiers</p>
 *
 * @author Matteo DUFOUR
 * @author Matteo MUNOZ
 */
public final class Singleton {
    /**
     * L'instance du singleton
     */
    private static Singleton INSTANCE;

    /**
     * Le mot de passe global haché
     */
    private String info = null;

    /**
     * La liste des mots de passe
     */
    private List<Password> passwordList = new ArrayList<>();

    /**
     * <p>Constructeur du singleton</p>
     */
    private Singleton() {
    }

    /**
     * Getter pour l'instance
     *
     * @return Une instance
     */
    public static Singleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Singleton();
        }

        return INSTANCE;
    }

    /**
     * Getter pour l'info
     *
     * @return Une info
     */
    public String getInfo() {
        return info;
    }

    /**
     * Setter pour l'info
     *
     * @param info  Stocke l'info
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * Getter pour la liste de mots de passe
     *
     * @return La liste de mots de passe
     */
    public List<Password> getPasswordList() {
        return passwordList;
    }

    /**
     * Setter pour l'info
     *
     * @param passwordlist  Stocke la liste de mots de passe
     */
    public void setPasswordList(List<Password> passwordlist) {
        this.passwordList = passwordlist;
    }
}
