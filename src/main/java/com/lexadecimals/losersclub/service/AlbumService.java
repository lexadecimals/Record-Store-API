package com.lexadecimals.losersclub.service;

import com.lexadecimals.losersclub.model.Album;

import java.util.Optional;

public interface AlbumService {

    Iterable<Album> getAllAlbums();
    Optional<Album> getAlbumById(Long id);
    Album addAlbum(Album album);
    Album updateAlbum(Long id, Album albumToUpdate);
    boolean deleteAlbumById(Long id);
}
