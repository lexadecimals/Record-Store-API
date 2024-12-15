package com.lexadecimals.losersclub.controller;

import com.lexadecimals.losersclub.model.Album;
import com.lexadecimals.losersclub.service.AlbumServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/albums")
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
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        Album albumReturnedFromDb = albumServiceImpl.addAlbum(album);
        return new ResponseEntity<>(albumReturnedFromDb, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> updateAlbum(
            @PathVariable Long id,
            @RequestBody Album album
            ) {
        try {
            Album updatedAlbum = albumServiceImpl.updateAlbum(id, album);
            return new ResponseEntity<>(updatedAlbum, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Not Found", "Album with id of " + id.toString() + " Not Found!");
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAlbumById(@PathVariable Long id)  {
            if (albumServiceImpl.deleteAlbumById(id)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                HttpHeaders headers = new HttpHeaders();
                headers.add("Not Found", "Album with Id of " + id + " not found");
                return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
            }
            //TODO: handle missing path variable
    }

}
