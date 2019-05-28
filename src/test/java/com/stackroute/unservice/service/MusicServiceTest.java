package com.stackroute.unservice.service;

import com.stackroute.unservice.domain.Music;
import com.stackroute.unservice.exceptions.MusicAlreadyExistsException;
import com.stackroute.unservice.exceptions.MusicNotFoundException;
import com.stackroute.unservice.repository.MusicRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;



public class MusicServiceTest {
    private Music music;

    //Create a mock for UserRepository
    @Mock
    private MusicRepository musicRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private MusicServiceImpl musicService;
    List<Music> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        music = new Music();
        music.setId(101);
        music.setName("sajdaa");
        music.setComments("Good");
        list = new ArrayList<>();
        list.add(music);


    }

    @Test
    public void saveMusicTestSuccess() throws MusicAlreadyExistsException {

        when(musicRepository.save((Music) any())).thenReturn(music);
            Music savedUser = musicService.saveMusic(music);
        Assert.assertEquals(music,savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(musicRepository,times(1)).save(music);

    }

    @Test//(expected = MusicAlreadyExistsException.class)
    public void saveMusicTestFailure() throws MusicAlreadyExistsException {
        when(musicRepository.save((Music)any())).thenReturn(music);
        Music savedMusic = musicService.saveMusic(music);
        System.out.println("saveUser" + savedMusic);
        Assert.assertEquals(music,savedMusic);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void getAllMusicTestSuccess(){

        musicRepository.save(music);
        //stubbing the mock to return specific data
        when(musicRepository.findAll()).thenReturn(list);
        List<Music> userlist = musicService.getAllMusic();
        Assert.assertEquals(list,userlist);
    }

    @Test
    public void getAllMusicTestFailure() throws MusicAlreadyExistsException{
        when(musicRepository.save((Music)any())).thenReturn(null);
         musicService.getAllMusic();


    }


    @Test
    public void updateMusicTestSuccess(){

        when(musicRepository.save((Music) any())).thenReturn(music);
        try {
            Music updateMusic = musicService.updateMusic(music);
        } catch (MusicNotFoundException e) {
            e.printStackTrace();
        }
        // Assert.assertEquals(music,updateMusic);

        //verify here verifies that userRepository save method is only called once
        verify(musicRepository,times(1)).save(music);

    }


    @Test
    public void updateMusicTestFailure() throws MusicNotFoundException{
        when(musicRepository.save((Music)any())).thenReturn(music);
        Music updateMusic = musicService.updateMusic(music);
        Assert.assertEquals(music,updateMusic);


    }


    @Test
    public void deleteMusicTestSuccess(){

        musicRepository.save(music);
        //stubbing the mock to return specific data
        when(musicRepository.findAll()).thenReturn(list);
         musicService.deleteMusic(101);
        //Assert.assertEquals(list,userlist);

    }

    @Test
    public void deleteMusicTestFailure() throws MusicNotFoundException {

        musicRepository.save(music);
        when(musicRepository.findAll()).thenReturn(null);
        musicService.deleteMusic(1);

    }




//
//    @Test
//    public void getMusicByNameTestSuccess() throws Exception{
//
//        musicRepository.save(music);
//        //stubbing the mock to return specific data
//        when(musicRepository.findAll()).thenReturn(list);
//        musicService.getMusicByName("sajdaa");
//        //Assert.assertEquals(list,userlist);
//
//    }

//    @Test
//
//    public void getMusicByNameTestFailure() throws Exception{
//
//        when(musicRepository.getMusicByName((Music)any())).thenReturn(null);
//        Music getMusic = musicService.getMusicByName("agfd");
//        Assert.assertEquals(music,getMusic);
//
//    }




}
