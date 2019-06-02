package com.stackroute.musicApplication.service;

import com.stackroute.musicApplication.domain.Music;

import com.stackroute.musicApplication.exceptions.MusicAlreadyExistsException;
import com.stackroute.musicApplication.exceptions.MusicNotFoundException;


import java.util.List;


public interface MusicService {

    public Music saveMusic(Music music) throws MusicAlreadyExistsException;

    public List<Music> getAllMusic();

    public List<Music> deleteMusic(int id) throws MusicNotFoundException;

    public Music updateMusic(Music music) throws MusicNotFoundException;

    public void setData(Music music);


}
