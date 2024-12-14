package com.lexadecimals.losersclub.controller;

import com.lexadecimals.losersclub.model.Album;
import com.lexadecimals.losersclub.service.AlbumServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id) {
        return albumServiceImpl.getAlbumById(id)
                .map(album -> new ResponseEntity<>(album, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> addAlbum(@RequestBody Album album) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
