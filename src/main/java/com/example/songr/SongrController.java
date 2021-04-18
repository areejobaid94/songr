package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class SongrController {
    @GetMapping("/hello")
    public String string(){
        return "HelloWord";
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

}
