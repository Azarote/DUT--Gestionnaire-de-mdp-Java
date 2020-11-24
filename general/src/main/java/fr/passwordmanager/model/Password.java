package fr.passwordmanager.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Password implements Serializable {
    private String title;
    private String username;
    private String password;
    private String URL;
    private String description;
    private String expiration_date;

     @JsonCreator
    public Password(@JsonProperty("title") String title,@JsonProperty("username") String username, @JsonProperty("password")String password, @JsonProperty("URL")String URL, @JsonProperty("description")String description, @JsonProperty("expiration_date")String expiration_date) {
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
    @JsonGetter("title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @JsonGetter("username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @JsonGetter("password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @JsonGetter("url")
    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    @JsonGetter("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @JsonGetter("expiration_date")
    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }
}
