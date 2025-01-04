package com.lexadecimals.losersclub.repository;

import com.lexadecimals.losersclub.model.Album;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.lexadecimals.losersclub.TestDataUtil.*;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class AlbumRepositoryTest {

    @Autowired
    private AlbumRepository albumRepository;

    Album testAlbum1;
    Album testAlbum2;
    Album testAlbum3;

    @BeforeEach
    void setUp() {
        testAlbum1 = createTestAlbum1();
        testAlbum2 = createTestAlbum2();
        testAlbum3 = createTestAlbum3();
        albumRepository.save(testAlbum1);
        albumRepository.save(testAlbum2);
        albumRepository.save(testAlbum3);
    }

    @AfterEach
    void tearDown() {
        albumRepository.delete(testAlbum1);
        albumRepository.delete(testAlbum2);
        albumRepository.delete(testAlbum3);
    }

    @Test
    @DisplayName("POST /albums - when a new album is saved it can then be retrieved via id")
    void saveAlbumTest() {
        Album savedAlbum = albumRepository.findById(testAlbum1.getId()).orElse(null);
        assertNotNull(savedAlbum);
        assertEquals(testAlbum1.getArtist(), savedAlbum.getArtist());
        assertEquals(testAlbum1.getTitle(), savedAlbum.getTitle());
    }

    @Test
    @DisplayName("PUT /albums - when an album is updated it can then be retrieved via id")
    void updateAlbumTest() {
        testAlbum3.setPrice(15.99);
        Album updatedAlbum = albumRepository.findById(testAlbum3.getId()).orElse(null);
        assertNotNull(updatedAlbum);
        assertEquals(15.99, updatedAlbum.getPrice());
    }

    @Test
    @DisplayName("GET /albums/search?key=value returns album when given phrase found in artist or title")
    void getAlbumsBySearchTermTest() {
        Iterable<Album> foundAlbums = albumRepository.findByArtistContainsIgnoreCaseOrTitleContainsIgnoreCase("Cure", "Cure");
        Iterable<Album> foundAlbums2 = albumRepository.findByArtistContainsIgnoreCaseOrTitleContainsIgnoreCase("mo", "mo");
        assertNotNull(foundAlbums2);
        assertNotNull(foundAlbums);
        foundAlbums.forEach(album -> {
            assertEquals(testAlbum3.getArtist(),album.getArtist());
        });
        foundAlbums2.forEach(album -> {
            assertEquals(testAlbum2.getTitle(),album.getTitle());
        });

    }
}