package com.example.musiccatalog.Repository;

import com.example.musiccatalog.Entity.Music;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MusicRepository extends MongoRepository<Music, String> {

    List<Music> findByTitreContaining(String titre);
}
