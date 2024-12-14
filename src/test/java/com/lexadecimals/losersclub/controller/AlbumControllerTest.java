package com.lexadecimals.losersclub.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lexadecimals.losersclub.model.Album;
import com.lexadecimals.losersclub.service.AlbumServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.lexadecimals.losersclub.TestDataUtil.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
class AlbumControllerTest {

    List<Album> albums = new ArrayList<>();

    @Mock
    private AlbumServiceImpl albumServiceImplMock;

    @InjectMocks
    private AlbumController albumControllerMock;

    @Autowired
    private MockMvc mockMvcController;


    @BeforeEach
    void setUp() {
        mockMvcController = MockMvcBuilders.standaloneSetup(albumControllerMock).build();

        Album testAlbum1 = createTestAlbum1();
        Album testAlbum2 = createTestAlbum2();
        Album testAlbum3 = createTestAlbum3();
        albums.add(testAlbum1);
        albums.add(testAlbum2);
        albums.add(testAlbum3);
    }
    @Test
    @DisplayName("GET /albums/{id} responds with status code of 200 if found")
    void getAlbumByIdTest() throws Exception {
        //TODO: research option.ofnullable
        when(albumServiceImplMock.getAlbumById(2L)).thenReturn(Optional.of(albums.get(1)));

        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/albums/{id}", 2L))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}


