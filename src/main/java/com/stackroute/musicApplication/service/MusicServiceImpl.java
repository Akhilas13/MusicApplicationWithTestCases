package com.stackroute.musicApplication.service;

import com.stackroute.musicApplication.domain.Music;

import com.stackroute.musicApplication.exceptions.MusicAlreadyExistsException;
import com.stackroute.musicApplication.exceptions.MusicNotFoundException;
import com.stackroute.musicApplication.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MusicServiceImpl implements MusicService {

    MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    // save music
    @Override
    public Music saveMusic(Music music) throws MusicAlreadyExistsException {
        if (musicRepository.existsById(music.getId())) {
            throw new MusicAlreadyExistsException(" Music already exists..");
        }
        Music savedMusic = musicRepository.save(music);
        return savedMusic;
    }

    // display all music
    @Override
    public List<Music> getAllMusic() {
        return musicRepository.findAll();

    }

    // delete music by id
    @Override
    public List<Music> deleteMusic(int id) throws MusicNotFoundException{
        musicRepository.deleteById(id);
        return null;

    }

    // update music by id
    @Override
    public Music updateMusic(Music music) throws MusicNotFoundException{
        if (musicRepository.existsById(music.getId())) {
            throw new MusicNotFoundException("Music not found.. ");
        }

        Music savedMusic = musicRepository.save(music);
        return savedMusic;

    }
    // seed data

    @Override
    public void setData(Music music){
        if(!musicRepository.existsById(music.getId())){
            musicRepository.save(music);
        }
    }




}