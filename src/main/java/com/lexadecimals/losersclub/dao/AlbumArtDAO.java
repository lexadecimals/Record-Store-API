package com.lexadecimals.losersclub.dao;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class AlbumArtDAO {

    private static final String BASE_URL = "https://itunes.apple.com/search";
    public static void getWebClientResults() {

        WebClient client = WebClient.builder().baseUrl(BASE_URL).build();
        AlbumResponse res = null;
        try {
            res = client.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("")
                            .queryParam("term", "chanel+orange+frank+ocean")
                            .queryParam("media", "music")
                            .queryParam("entity", "album")
                            .queryParam("count", 1)
                            .build()
                    )
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(AlbumResponse.class)
                    .block();
            System.out.println("RES: " + res);
        } catch(WebClientResponseException e) {
            System.out.println(e.getMessage());
        }


    }
}
