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
public class SongrController {

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


}