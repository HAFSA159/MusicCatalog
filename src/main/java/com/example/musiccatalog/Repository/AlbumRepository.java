package com.example.musiccatalog.Repository;

import com.example.musiccatalog.Entity.Album;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends MongoRepository<Album, String> {

}
