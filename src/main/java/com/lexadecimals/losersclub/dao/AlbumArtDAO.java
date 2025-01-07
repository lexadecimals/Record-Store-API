package com.lexadecimals.losersclub.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class AlbumArtDAO {

    private static final String BASE_URL = "https://itunes.apple.com/search";
    public static void getWebClientResults() {

        WebClient client = WebClient.builder().baseUrl(BASE_URL).build();
        ObjectMapper mapper = new ObjectMapper();
        String res = null;
        try {
            res = client.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("")
                            .queryParam("term", "the+cure")
                            .queryParam("media", "music")
                            .queryParam("entity", "album")
                            .queryParam("limit", 3)
                            .build()
                    )
                    .accept()
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            AlbumResponse albumResponse = mapper.readValue(res, AlbumResponse.class);
            System.out.println("RES: " + albumResponse);
        } catch(WebClientResponseException e) {
            System.out.println(e.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
