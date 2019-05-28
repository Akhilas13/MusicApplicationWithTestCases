package com.stackroute.unservice.service;

import com.stackroute.unservice.domain.Music;

import com.stackroute.unservice.exceptions.MusicAlreadyExistsException;
import com.stackroute.unservice.exceptions.MusicNotFoundException;


import java.util.List;


public interface MusicService {


    public Music saveMusic(Music music) throws MusicAlreadyExistsException;
    
    public List<Music> getAllMusic();

    public List<Music> deleteMusic(int id);

    public Music updateMusic(Music music) throws MusicNotFoundException;

   // public List<Music> getMusicByName(String music) throws MusicNotFoundException;

    public void setData(Music music);



}
