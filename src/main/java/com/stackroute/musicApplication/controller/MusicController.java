package com.stackroute.musicApplication.controller;

import com.stackroute.musicApplication.domain.Music;
import com.stackroute.musicApplication.exceptions.MusicAlreadyExistsException;
import com.stackroute.musicApplication.exceptions.MusicNotFoundException;
import com.stackroute.musicApplication.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
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




    // method to save music
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



    // method to get all music
    @GetMapping("/user")
    public ResponseEntity<?> getAllMusic() throws MusicNotFoundException {
        ResponseEntity responseEntity;
        try {
            return new ResponseEntity<List<Music>>(musicService.getAllMusic(), HttpStatus.OK);
        }

        catch (Exception e)
        {
            e.getMessage();
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);

        }
        return responseEntity;

    }




    // method to delete music
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteMusic(@PathVariable int id) throws MusicNotFoundException {


        ResponseEntity responseEntity=null;
        try {
            return new ResponseEntity( musicService.deleteMusic(id), HttpStatus.OK);
        }

        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }

    }



    // method to update music
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







}
