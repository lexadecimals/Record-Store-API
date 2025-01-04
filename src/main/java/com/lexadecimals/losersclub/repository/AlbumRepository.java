package com.lexadecimals.losersclub.repository;

import com.lexadecimals.losersclub.model.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
    Long removeById(Long id);
    Iterable<Album> findByItemsInStockGreaterThan(int stock);
    Iterable<Album> findByArtistLikeIgnoreCaseAndItemsInStockGreaterThan(String artist, int i);
    Iterable<Album> findByArtistContainsIgnoreCaseOrTitleContainsIgnoreCase(String searchTerm, String searchTerm1);
}