package com.lexadecimals.losersclub.service;

import com.lexadecimals.losersclub.dto.AlbumDTO;
import com.lexadecimals.losersclub.model.Album;

import java.util.Optional;

public interface AlbumService {

    Iterable<Album> getAllAlbums();
    Optional<Album> getAlbumById(Long id);
    Album addAlbum(AlbumDTO dto);
    Optional<Album>  updateAlbum(Long id, Album albumToUpdate);
    boolean deleteAlbumById(Long id);
    Iterable<Album> getAllInStock();
    Iterable<Album> getAllInStockByArtist(String name);
    Iterable<Album> getAlbumsBySearchTerm(String searchTerm);
}
