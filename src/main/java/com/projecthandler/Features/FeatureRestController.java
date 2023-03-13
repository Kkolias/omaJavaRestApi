package com.projecthandler.Features;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projecthandler.Items.Item;
import com.projecthandler.Items.ItemRepository;
import com.projecthandler.Params.ItemToFeature;

@RestController
@CrossOrigin(origins = "*")
public class FeatureRestController {

    @Autowired
    private FeatureRepository featureRepository;

    @Inject
    private ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        featureRepository.save(
                new Feature("Testi", 1, "todo", "empty"));
    }

    @GetMapping("/api/feature/get-all")
    public List<Feature> listAll() {
        return featureRepository.findAll();
    }

    @RequestMapping(
    value = "/api/feature/create-item-to-freature", 
    method = RequestMethod.POST)
    @ResponseBody
    public Feature createItemToFeature(@RequestBody ItemToFeature payload) {
        Feature feature = featureRepository.findById(payload.featureId).orElse(null);

        Item newItem = itemRepository.save(new Item(payload.name, payload.orderNumber, payload.status, payload.description));
    
        feature.items.add(newItem);
        featureRepository.save(feature);

        return featureRepository.findById(payload.featureId).orElse(null);
    }

}
