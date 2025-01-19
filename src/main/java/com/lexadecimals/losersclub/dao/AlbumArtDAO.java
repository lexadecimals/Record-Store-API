package com.lexadecimals.losersclub.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class AlbumArtDAO {

    private static final String BASE_URL = "https://itunes.apple.com/search";
    //return optional?
    public static AlbumResponse getWebClientResults(String searchTerm) {

        WebClient client = WebClient.builder().baseUrl(BASE_URL).build();
        ObjectMapper mapper = new ObjectMapper();
        AlbumResponse albumResponse;
        String res = null;
        try {
            res = client.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("")
                            .queryParam("term", "{searchTerm}")
                            .queryParam("media", "music")
                            .queryParam("entity", "album")
                            .queryParam("limit", 1)
                            .build(searchTerm)
                    )
                    .accept()
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
             albumResponse = mapper.readValue(res, AlbumResponse.class);
            return albumResponse;
        } catch(WebClientResponseException e) {
            System.out.println(e.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
