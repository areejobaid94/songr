package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.repositories.AlbumsRepository;
import com.example.songr.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.InetSocketAddress;
import java.net.URL;
import java.util.ArrayList;

@Controller
//Stretch Goals
public class SongrController {

    @Autowired
    AlbumsRepository albumsRepository;

    @GetMapping("/hello")
    public String string(@RequestParam(name="name", required=false, defaultValue="World") String name, Model m){
        m.addAttribute("name", name.toUpperCase());
        return "HelloWord";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/capitalize/{word}")
    public String greeting(Model m, @PathVariable("word") String word ) {
        m.addAttribute("word", word.toUpperCase());
        return "Capitalize";
    }

    @GetMapping("/albums")
    public String albums(Model m) {
        m.addAttribute("albums" ,albumsRepository.findAll());
        return "albums.html";
    }

    //Stretch Goals
    @PostMapping("/hello")
    public String postHello(@RequestParam(name="name", required=false, defaultValue="World") String name,Model m){
        m.addAttribute("name", name.toUpperCase());
        return "HelloWord";
    }

    //Stretch Goals
    @GetMapping("/fact")
    public String postFact(@RequestParam(name="num", required=false, defaultValue="1") int num,Model m){
        try {
            URL url = new URL("http://numbersapi.com/"+ num);
            m.addAttribute("fact", Service.getJsonFromAPI(url));
        }catch (Exception ex){
            System.out.println(ex);
        }
        return "fact";
    }

    //Stretch Goals
    @GetMapping("/getBaseUrl")
    public ResponseEntity<String> getBaseUrl(@RequestHeader HttpHeaders headers) {
        InetSocketAddress host = headers.getHost();
        String url = "http://" + host.getHostName() + ":" + host.getPort();
        return new ResponseEntity<String>(String.format("Base URL = %s", url), HttpStatus.OK);
    }

    @GetMapping("/addStudent")
    public String getAddStudentView(){
        return "addStudent.html";
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
}