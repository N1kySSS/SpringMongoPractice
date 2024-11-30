package com.example.mongoDB.model;

import com.example.mongoDB.config.StringListDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "games")
public class Game {

    @Id
    private String id;

    private String name;

    private String developer;

    private int price;

    private int releaseYear;

    @JsonDeserialize(using = StringListDeserializer.class)
    private List<String> genre;

    @JsonDeserialize(using = StringListDeserializer.class)
    private List<String> platforms;

    public Game() {}

    public Game(String name, String developer, int price, int releaseYear, List<String> genre, List<String> platforms) {
        this.name = name;
        this.developer = developer;
        this.price = price;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.platforms = platforms;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public List<String> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<String> platforms) {
        this.platforms = platforms;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", developer='" + developer + '\'' +
                ", price=" + price +
                ", releaseYear=" + releaseYear +
                ", genre=" + genre +
                ", platforms=" + platforms +
                '}';
    }
}
