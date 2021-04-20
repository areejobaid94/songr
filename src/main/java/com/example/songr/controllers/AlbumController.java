package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.models.Song;
import com.example.songr.repositories.AlbumsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    AlbumsRepository albumsRepository;

    @GetMapping("/albums")
    public String albums(Model m) {
        m.addAttribute("albums" ,albumsRepository.findAll());
        System.out.println(albumsRepository.findAll());
        return "albums.html";
    }

    @PostMapping("/album")
    public RedirectView addStudent(@RequestParam(value = "title") String title ,
                                   @RequestParam(value= "artist") String artist,
                                   @RequestParam(value="imageUrl") String imageUrl,
                                   @RequestParam(value="songCount") int songCount,
                                   @RequestParam(value="length") Double length){

        Album album = new Album(title,artist,imageUrl,songCount,length);
        albumsRepository.save(album);
        return  new RedirectView("/albums");
    }

    @RequestMapping(value = "/delete_album", method = RequestMethod.GET)
    public RedirectView handleDeleteUser(@RequestParam(value = "id") Integer id) {
        albumsRepository.deleteById(id);
        return new RedirectView("/albums");
    }

    @PostMapping("/album-update")
    public RedirectView updateStudent(@RequestParam(value = "title") String title ,
                                      @RequestParam(value= "artist") String artist,
                                      @RequestParam(value="imageUrl") String imageUrl,
                                      @RequestParam(value="songCount") int songCount,
                                      @RequestParam(value = "id" ) Integer id,
                                      @RequestParam(value="length") Double length){

        Album album = albumsRepository.findById(id).get();
        album.setArtist(artist);
        album.setTitle(title);
        album.setImageUrl(imageUrl);
        album.setSongCount(songCount);
        album.setLength(length);
        albumsRepository.save(album);
        return  new RedirectView("/albums");
    }

    @GetMapping("/albumSongs/{id}")
    public String getStudentById(@PathVariable(value="id") Integer id,Model m){
        m.addAttribute("album",albumsRepository.findById(id).get());
        return "AlbumDet";
    }
}
