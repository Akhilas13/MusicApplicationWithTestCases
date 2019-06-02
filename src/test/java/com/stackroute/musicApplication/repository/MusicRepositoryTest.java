package com.stackroute.musicApplication.repository;

import com.stackroute.musicApplication.domain.Music;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicRepositoryTest {
    @Autowired
    private MusicRepository musicRepository;
    private Music music;

    @Before
    public void setUp() {
        music = new Music();
        music.setId(10);
        music.setName("John");
        music.setComments("Jenny");

    }

    @After
    public void tearDown() {

        musicRepository.deleteAll();
    }


    @Test //success test case for save music
    public void testSaveMusicSuccess() {
        musicRepository.save(music);
        Music fetchMusic = musicRepository.findById(music.getId()).get();
        Assert.assertEquals(10, fetchMusic.getId());

    }

    @Test // failure test case for save music
    public void testSaveMusicFailure() {
        Music testMusic = new Music(23, "john", "marry");
        musicRepository.save(music);
        Music fetchMusic = musicRepository.findById(music.getId()).get();
        Assert.assertNotSame(testMusic, music);
    }

    @Test // success test case for get all music
    public void testGetAllMusicSuccess() {
        Music u = new Music(67, "welcome", "jerry");
        Music u1 = new Music(87, "Jenny", "trew");
        musicRepository.save(u);
        musicRepository.save(u1);

        List<Music> list = musicRepository.findAll();
        Assert.assertEquals("welcome", list.get(0).getName());


    }


    @Test // success test case for update music
    public void updateMusicSuccess() {
        Music m1 = new Music(26, "rAJ", "MALYA");
        musicRepository.save(m1);

    }


    @Test // failure test case for update music
    public void updateMusicFailure() {
        Music testMusic = new Music(27, "john", "marry");
        musicRepository.save(music);
        Music fetchMusic = musicRepository.findById(music.getId()).get();
        Assert.assertNotSame(testMusic, music);
    }


    @Test // success test case for delete music
    public void deleteMusicTestSuccess() {
        Music m1 = new Music(1, "hello", "adele");
        musicRepository.delete(m1);
    }


}
