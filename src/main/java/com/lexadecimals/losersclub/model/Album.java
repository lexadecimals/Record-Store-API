package com.lexadecimals.losersclub.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "year_of_release")
    private int yearOfRelease;
    @Column
    private String title;
    @Column
    private String artist;
    @Column
    private String genre;
    @Column
    private double price;

    public Album() {
    }

    public Album(double price, String genre, String artist, String title, int yearOfRelease) {
        this.price = price;
        this.genre = genre;
        this.artist = artist;
        this.title = title;
        this.yearOfRelease = yearOfRelease;
    }

    public static class AlbumBuilder{}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
