package com.lexadecimals.losersclub.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDTO {
    private String title;
    private String artist;
    private String genre;
    private double price;
    private int yearOfRelease;
    private int itemsInStock;
}
