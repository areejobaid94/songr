package com.example.songr.repositories;

import com.example.songr.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AlbumsRepository extends JpaRepository<Album, Integer> {
}
