package com.lexadecimals.losersclub.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AlbumResponse(List<Results> results) {
}
