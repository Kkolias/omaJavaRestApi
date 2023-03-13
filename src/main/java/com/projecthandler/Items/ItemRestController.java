package com.projecthandler.Items;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ItemRestController {
    
    @Autowired
   private ItemRepository itemRepository;


    @PostConstruct
    public void init() {
        itemRepository.save(
            new Item("ITEMI", 1, "todo", "empty")
        );
    }

    @GetMapping("/api/items/get-all")
    public List<Item> listAll() {
        return itemRepository.findAll();
    }
}
