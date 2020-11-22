package fr.passwordmanager.model;

import java.io.Serializable;

public class Password implements Serializable {
    private String title;
    private String username;
    private String password;
    private String URL;
    private String description;
    private String expiration_date;

    public Password(String title, String username, String password, String URL, String description, String expiration_date) {
        this.title = title;
        this.username = username;
        this.password = password;
        this.URL = URL;
        this.description = description;
        this.expiration_date = expiration_date;
    }

    @Override
    public String toString() {
        return "Password{" +
                "title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", URL='" + URL + '\'' +
                ", description='" + description + '\'' +
                ", expiration_date='" + expiration_date + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }
}
