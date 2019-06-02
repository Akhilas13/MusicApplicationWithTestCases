package com.stackroute.musicApplication.seedData;

import com.stackroute.musicApplication.domain.Music;
import com.stackroute.musicApplication.repository.MusicRepository;
import com.stackroute.musicApplication.service.MusicService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;



@Component
@PropertySource("classpath:application.properties")
public class StartUpApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logs = Logger.getLogger(StartUpApplicationListener.class);
    private MusicRepository musicRepository;


    @Autowired
    MusicService musicService;
    Music track2;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //logs.info("Inserting data on start");

//        Music track1 = new Music(2,"Darkside","Singer : alan Walker");
//        musicRepository.save(track1);
        track2 = new Music(3, "walkthroughfire", "Singer : alanwalker");
        musicService.setData(track2);
//        Track track9 = new Track(Integer.parseInt(env.getProperty("trackid")),env.getProperty("name"),env.getProperty("comments"));
//        trackRepository.save(track9);

        logs.info("data successfully inserted");
    }
}
