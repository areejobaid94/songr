package com.example.songr.repositories;

import com.example.songr.models.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongsRepository extends CrudRepository<Song, Integer> {
}
