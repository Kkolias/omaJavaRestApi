package com.projecthandler.Testi;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class TestiRestController {

   @Autowired
   private TestiRepository testiRepository;


    @PostConstruct
    public void init() {
        testiRepository.save(
            new Testi("Testi", 20)
        );
    }

    @GetMapping("/api/testi/get-all")
    public List<Testi> listAll() {
        return testiRepository.findAll();
    }

    
}
