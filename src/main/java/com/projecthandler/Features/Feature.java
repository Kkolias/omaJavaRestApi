package com.projecthandler.Features;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.projecthandler.Items.Item;

@Entity
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public int orderNumber;
    public String status;
    public String description;
    
    @OneToMany(mappedBy="feature")
    public List<Item> items;

    public Feature() {}

    public Feature(String name, int orderNumber, String status, String description) {
        this.setName(name);
        this.setOrderNumber(orderNumber);
        this.setStatus(status);
        this.setDescription(description);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setCourse(Item item) {
        this.items.add(item);
    }

}
