package fr.passwordmanager.model;

import java.util.Date;

public class Password {
    private String title;
    private String URL;
    private String username;
    private String email;
    private String password;
    private String description;
    private Date expiration_date;

    public Password(String title, String URL, String username, String email, String password, String description, Date expiration_date) {
        this.title = title;
        this.URL = URL;
        this.username = username;
        this.email = email;
        this.password = password;
        this.description = description;
        this.expiration_date = expiration_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }
}
