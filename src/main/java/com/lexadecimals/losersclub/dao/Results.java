package com.lexadecimals.losersclub.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Results(long collectionId, String artistName, String collectionName, String artworkUrl160) {
}
