package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.models.Song;
import com.example.songr.repositories.AlbumsRepository;
import com.example.songr.repositories.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.ManyToOne;

@Controller
public class SongController {
    @Autowired
    SongsRepository songsRepository;

    @Autowired
    AlbumsRepository albumsRepository;

    @GetMapping("/songs")
    public String albums(Model m) {
        m.addAttribute("songs" ,songsRepository.findAll());
        System.out.println(songsRepository.findAll());
        return "songs";
    }

    @PostMapping("/song")
    public RedirectView addStudent(@RequestParam(value = "title") String title ,
                                   @RequestParam(value= "length") Double length,
                                   @RequestParam(value="trackNumber") int trackNumber,
                                   @RequestParam(value="albumId") int albumId){
        Album album = albumsRepository.findById(albumId).get();
        System.out.println(album);
        Song song = new Song(title,length,trackNumber,album);
        songsRepository.save(song);
        System.out.println(album);

        return  new RedirectView("/albumSongs/"+album.getId());
    }


}
