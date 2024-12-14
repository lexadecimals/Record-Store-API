package com.lexadecimals.losersclub.controller;

import com.lexadecimals.losersclub.model.Album;
import com.lexadecimals.losersclub.service.AlbumServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    AlbumServiceImpl albumServiceImpl;

    @GetMapping
    public ResponseEntity<Iterable<Album>> getAllAlbums() {
        // TODO: customise response for empty list
        Iterable<Album> allAlbums = albumServiceImpl.getAllAlbums();

        return new ResponseEntity<>(allAlbums, HttpStatus.OK);
    }
}
