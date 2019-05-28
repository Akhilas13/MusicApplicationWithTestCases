package com.stackroute.unservice.controller;

import com.stackroute.unservice.domain.Music;

import com.stackroute.unservice.exceptions.MusicAlreadyExistsException;

import com.stackroute.unservice.exceptions.MusicNotFoundException;
import com.stackroute.unservice.service.MusicService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
@PropertySource("classpath:application.properties")


public class MusicController {


    MusicService musicService;
    @Autowired
    public MusicController(MusicService musicService) {

        this.musicService = musicService;
    }




   // @ApiOperation(value = "save music")
    @PostMapping("/user")
    public ResponseEntity<?> saveMusic(@RequestBody Music music) throws MusicAlreadyExistsException {
        ResponseEntity responseEntity;
        try {
            musicService.saveMusic(music);
            responseEntity = new ResponseEntity<String>("succesfully created", HttpStatus.CREATED);
        } catch (MusicAlreadyExistsException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();
          // throw ex;

        }
        return responseEntity; // represents complete http request including response body,status code and header
    }



    //@ApiOperation(value = "get all music")
    @GetMapping("/user")
    public ResponseEntity<?> getAllMusic() {
        ResponseEntity responseEntity;
        return new ResponseEntity<List<Music>>(musicService.getAllMusic(), HttpStatus.OK);
    }




    //@ApiOperation(value = "delete music")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteMusic(@PathVariable int id) {
        musicService.deleteMusic(id);
        return new ResponseEntity<String>("successfully deleted", HttpStatus.OK);
    }



    //@ApiOperation(value = "update music")
    @PutMapping("/user")
    public ResponseEntity<Music> updateMusic(@RequestBody Music music) throws MusicNotFoundException {
        ResponseEntity responseEntity;
        try {
            Music music1 = musicService.updateMusic(music);
            return new ResponseEntity<Music>(music1, HttpStatus.OK);
        } catch (MusicNotFoundException ex){
            throw ex;
            //responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
           // ex.printStackTrace();

        }

    }




//   // @ApiOperation(value = "get music by name")
//    @GetMapping("/user/{name}")
//    public ResponseEntity<List<Music>> getMusicByName(@PathVariable String name) throws Exception {
//        List<Music> music1 = musicService.getMusicByName(name);
//        return new ResponseEntity<List<Music>>(music1, HttpStatus.OK);
//
//
//    }
//



}








