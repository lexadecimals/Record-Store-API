package com.lexadecimals.losersclub.controller;

import com.lexadecimals.losersclub.service.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class AlbumController {

    @Autowired
    AlbumServiceImpl albumServiceImpl;
}
