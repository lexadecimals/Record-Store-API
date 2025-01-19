package com.lexadecimals.losersclub.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AlbumDetails(long collectionId, @JsonProperty("collectionName") String title , @JsonProperty("artistName") String artist, String artworkUrl60, String artworkUrl100) {
}
