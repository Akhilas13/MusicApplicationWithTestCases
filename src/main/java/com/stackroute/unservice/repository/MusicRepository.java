package com.stackroute.unservice.repository;

import com.stackroute.unservice.domain.Music;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MusicRepository extends MongoRepository<Music,Integer> {

//    @Query(value = "select * from music where name = ?1", nativeQuery = true)
//    public List<Music> getMusicByName(String music);

}
