package com.lexadecimals.losersclub.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@Data
@Builder
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "year_of_release")
    private int yearOfRelease;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String artist;
    @Column(name = "cover_art_url")
    private String coverArtUrl;
    @Column
    private String genre;
    @Column
    private double price;
    @Column(name = "items_in_stock")
    private int itemsInStock;

    public Album() {
    }
}
