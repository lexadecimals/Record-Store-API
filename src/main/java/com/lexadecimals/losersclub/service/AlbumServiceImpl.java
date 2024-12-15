package com.lexadecimals.losersclub.service;

import com.lexadecimals.losersclub.model.Album;
import com.lexadecimals.losersclub.repository.AlbumRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public Iterable<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public Optional<Album> getAlbumById(Long id) {
        return albumRepository.findById(id);
    }

    @Override
    @Transactional
    public Album addAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    @Transactional
    public Album updateAlbum(Long id, Album albumToUpdate) {
        return albumRepository.findById(id)
                .map(album -> {
                    album.setTitle(albumToUpdate.getTitle());
                    album.setArtist(albumToUpdate.getArtist());
                    album.setGenre(albumToUpdate.getGenre());
                    album.setPrice(albumToUpdate.getPrice());
                    album.setYearOfRelease(albumToUpdate.getYearOfRelease());
                    album.setItemsInStock(albumToUpdate.getItemsInStock());
                    return albumRepository.save(album);
                }).orElseThrow(NoSuchElementException::new);
    }

    @Override
    @Transactional
    public boolean deleteAlbumById(Long id) {
        Long rowsDeleted = albumRepository.removeById(id);
        return rowsDeleted > 0;
    }
}
