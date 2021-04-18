package com.example.songr;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.ArrayList;


@Controller
//Stretch Goals
public class SongrController {
    @GetMapping("/hello")
    public String string(@RequestParam(name="name", required=false, defaultValue="World") String name,Model m){
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
        ArrayList<Album> albums = new ArrayList<Album>();
        albums.add(new Album("anything","any one","https://i.ytimg.com/vi/mCPQspoRMxo/maxresdefault.jpg",10,150.0));
        albums.add(new Album("anything2","any one","https://www.iqraa.news/wp-content/uploads/2021/03/%D8%AA%D8%B1%D8%AF%D8%AF-%D9%82%D9%86%D8%A7%D8%A9-%D9%83%D8%B1%D8%A7%D9%85%D9%8A%D8%B4-%D8%B9%D9%84%D9%8A-%D9%86%D8%A7%D9%8A%D9%84-%D8%B3%D8%A7%D8%AA-%D9%88%D8%B9%D8%B1%D8%A8-%D8%B3%D8%A7%D8%AA-2021-1-1.jpg",20,250.0));
        albums.add(new Album("anything3","any one","https://i.ytimg.com/vi/ek68Del9bfw/maxresdefault.jpg",30,250.0));
        m.addAttribute("albums", albums);
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
            m.addAttribute("fact",Service.getJsonFromAPI(url));
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
}
