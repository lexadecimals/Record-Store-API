package com.lexadecimals.losersclub.service;

import com.lexadecimals.losersclub.dao.AlbumArtDAO;
import com.lexadecimals.losersclub.dao.AlbumDetails;

import java.util.List;
import java.util.Optional;


public class Utils {

    public static Optional<List<AlbumDetails>> fetchAlbumFromItunes(String searchTerm) {
        String formattedSearchTerm = searchTerm.replaceAll("\\+", " ");
        return Optional.ofNullable(AlbumArtDAO.getWebClientResults(formattedSearchTerm).results());
    }
}
