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
}
