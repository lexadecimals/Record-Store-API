package com.lexadecimals.losersclub.dto;

import com.lexadecimals.losersclub.model.Album;

public class DTOMapper {

    public static Album mapToAlbum(AlbumDTO dto) {
        return Album.builder()
                .artist(dto.getArtist())
                .title(dto.getTitle())
                .genre(dto.getGenre())
                .yearOfRelease(dto.getYearOfRelease())
                .itemsInStock(dto.getItemsInStock())
                .price(dto.getPrice())
                .build();
    }

    public static AlbumDTO mapToAlbumDTO(Album album) {
        return AlbumDTO.builder()
                .artist(album.getArtist())
                .title(album.getTitle())
                .genre(album.getGenre())
                .yearOfRelease(album.getYearOfRelease())
                .itemsInStock(album.getItemsInStock())
                .price(album.getPrice())
                .build();
    }
}
