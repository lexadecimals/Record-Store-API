package com.lexadecimals.losersclub.service;

import com.lexadecimals.losersclub.model.Album;
import com.lexadecimals.losersclub.repository.AlbumRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static com.lexadecimals.losersclub.TestDataUtil.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
class AlbumServiceImplTest {
    List<Album> albums = new ArrayList<>();

    @Mock
    AlbumRepository albumRepositoryMock;

    @InjectMocks
    AlbumServiceImpl albumServiceImpl;

    @BeforeEach
    public void setUp() {
        Album testAlbum1 = createTestAlbum1();
        Album testAlbum2 = createTestAlbum2();
        Album testAlbum3 = createTestAlbum3();
        albums.add(testAlbum1);
        albums.add(testAlbum2);
        albums.add(testAlbum3);
    }

    @Test
    @DisplayName("GET /albums returns all albums from the database")
    void getAllAlbumsTest() {
        Iterable<Album> iterableAlbums = albums;

        when(albumRepositoryMock.findAll()).thenReturn(iterableAlbums);
        Iterable<Album> actualResult = albumServiceImpl.getAllAlbums();
        assert(actualResult.equals(albums));
    }
}