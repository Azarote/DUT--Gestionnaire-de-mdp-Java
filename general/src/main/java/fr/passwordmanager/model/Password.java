package fr.passwordmanager.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * <p>Classe qui gère le modèle des mots de passe</p>
 *
 * @author Matteo DUFOUR
 * @author Matteo MUNOZ
 */
public class Password implements Serializable {
    /**
     * Le titre d'un mot de passe
     */
    private String title;

    /**
     * Le nom d'utilisateur
     */
    private String username;

    /**
     * Le mot de passe
     */
    private String password;

    /**
     * Le lien du site
     */
    private String URL;

    /**
     * La description
     */
    private String description;

    /**
     * La date d'expiration du mot de passe
     */
    private int day;

    private int month;

    private int year;

    /**
     * <p>Constructeur de mot de passe</p>
     *
     * @param title Le titre du mot de passe
     * @param username Le nom d'utilisateur
     * @param password Le mot de passe
     * @param URL Le lien du site
     * @param expiration_date La date d'expiration
     * @param description La description
     */
    @JsonCreator
    public Password(@JsonProperty("title") String title,@JsonProperty("username") String username, @JsonProperty("password")String password, @JsonProperty("URL")String URL, @JsonProperty("description")String description, @JsonProperty("year")int year,@JsonProperty("month")int month,@JsonProperty("day")int day) {
        this.title = title;
        this.username = username;
        this.password = password;
        this.URL = URL;
        this.description = description;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Transforme en chaîne de caractères
     */
    @Override
    public String toString() {
        return "Password{" +
                "title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", URL='" + URL + '\'' +
                ", description='" + description + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    /**
     * Getter pour le titre
     *
     * @return Le titre
     */
    @JsonGetter("title")
    public String getTitle() {
        return title;
    }

    /**
     * Setter pour le titre
     *
     * @param title String qui stocke le titre
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter pour le nom d'utilisateur
     *
     * @return Le nom d'utilisateur
     */
    @JsonGetter("username")
    public String getUsername() {
        return username;
    }

    /**
     * Setter pour le nom d'utilisateur
     *
     * @param username String qui stocke le nom d'utilisateur
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter pour le mot de passe
     *
     * @return Le mot de passe
     */
    @JsonGetter("password")
    public String getPassword() {
        return password;
    }

    /**
     * Setter pour le mot de passe
     *
     * @param password String qui stocke le mot de passe
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter pour le lien du site
     *
     * @return Le lien du site
     */
    @JsonGetter("url")
    public String getURL() {
        return URL;
    }

    /**
     * Setter pour le lien du site
     *
     * @param URL String qui stocke le lien du site
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     * Getter pour la description
     *
     * @return La description
     */
    @JsonGetter("description")
    public String getDescription() {
        return description;
    }

    /**
     * Setter pour la description
     *
     * @param description String qui stocke la description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter pour la date d'expiration
     *
     * @return La date d'expiration
     */
    @JsonGetter("day")
    public int getDay() {
        return day;
    }
    @JsonGetter("month")
    public int getMonth() {
        return month;
    }
    @JsonGetter("year")
    public int getYear() {
        return year;
    }
}
