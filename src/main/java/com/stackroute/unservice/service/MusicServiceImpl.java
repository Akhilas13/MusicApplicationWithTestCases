package com.stackroute.unservice.service;

import com.stackroute.unservice.domain.Music;

import com.stackroute.unservice.exceptions.MusicAlreadyExistsException;
import com.stackroute.unservice.exceptions.MusicNotFoundException;
import com.stackroute.unservice.repository.MusicRepository;
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


    @Override
    public Music saveMusic(Music music) throws MusicAlreadyExistsException {
        if (musicRepository.existsById(music.getId())) {
            throw new MusicAlreadyExistsException(" Music already exists..");
        }
        Music savedMusic = musicRepository.save(music);
        return savedMusic;
    }

    @Override
    public List<Music> getAllMusic() {
        return musicRepository.findAll();

    }

    @Override
    public List<Music> deleteMusic(int id) {
    musicRepository.deleteById(id);
    return null;

    }

    @Override
    public Music updateMusic(Music music) throws MusicNotFoundException{
        if (musicRepository.existsById(music.getId())) {
            throw new MusicNotFoundException("Music not found.. ");
        }

        Music savedMusic = musicRepository.save(music);
        return savedMusic;

    }
//
//    @Override
//    public List<Music> getMusicByName(String name) throws MusicNotFoundException {
//        List<Music> listOfTracks = null;
//        listOfTracks = musicRepository.getMusicByName(name);
//        if (listOfTracks.equals(null))
//        {
//            throw new MusicNotFoundException("Music not found exception");
//        }
//        return listOfTracks;
//    }

    @Override
    public void setData(Music music){
        if(!musicRepository.existsById(music.getId())){
            musicRepository.save(music);
        }
    }




}







