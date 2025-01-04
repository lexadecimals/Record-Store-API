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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.lexadecimals.losersclub.TestDataUtil.*;
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

    ObjectMapper mapper = new ObjectMapper();

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

//    test HTTP request mapping:

    @Test
    @DisplayName("GET /albums responds with status code of 200")
    void getAllAlbumsTest() throws Exception {
        // TODO: check 'when'

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/albums"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("GET /albums/{id} responds with status code of 200 if found")
    void getAlbumByIdTest_status200() throws Exception {

        when(albumServiceImplMock.getAlbumById(2L)).thenReturn(Optional.of(albums.getFirst()));
        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/albums/{id}", 2L))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("GET /albums/{id} responds with status code of 405 if not found")
    void getAlbumByIdTest_status405() throws Exception {
        // TODO: check 'when'

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/albums/{id}", 15L))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("POST /api/v1/albums/ returns status 201 after album is created")
    void postAlbumTest_status201() throws Exception {
        // TODO: check 'when'
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.post("/api/v1/albums")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(albums.getFirst())))
                .andExpect(MockMvcResultMatchers.status().isCreated()
                );
    }

    @Test
    @DisplayName("PUT /api/v1/albums/{id} returns status code 204 after album is successfully updated")
    void putAlbumTest_status204() throws Exception {
        Album updatedAlbum = albums.getFirst();
        updatedAlbum.setPrice(3.99);

        when(albumServiceImplMock.updateAlbum(1L, updatedAlbum)).thenReturn(Optional.of(updatedAlbum));

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.put("/api/v1/albums/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(updatedAlbum)))
                .andExpect(MockMvcResultMatchers.status().isNoContent()
                );
    }

    @Test
    @DisplayName("PUT /api/v1/albums/{id} returns status code 404 if album with id is not found")
    void putAlbumTest_status404() throws Exception {
        Album updatedAlbum = albums.getFirst();
        updatedAlbum.setPrice(3.99);

        when(albumServiceImplMock.updateAlbum(1L, updatedAlbum)).thenReturn(Optional.of(updatedAlbum));

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.put("/api/v1/albums/15")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(updatedAlbum)))
                .andExpect(MockMvcResultMatchers.status().isNotFound()
                );
    }

    @Test
    @DisplayName("DELETE /api/v1/albums/{id} returns status code 204 if album is successfully deleted")
    void deleteAlbumTest_status204() throws Exception {
        // TODO: check .then

        when(albumServiceImplMock.deleteAlbumById(1L)).thenReturn(true);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.delete("/api/v1/albums/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isNoContent()
                );
    }

    @Test
    @DisplayName("DELETE /api/v1/albums/{id} returns status code of 404 if id is not found")
    void deleteAlbumTest_status405() throws Exception {
        // TODO: check .then
        when(albumServiceImplMock.deleteAlbumById(15L)).thenReturn(false);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.delete("/api/v1/albums/{id}", 15L))
                .andExpect(MockMvcResultMatchers.status().isNotFound()
                );
    }

}


