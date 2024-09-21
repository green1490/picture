package com.example.picture.api;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.picture.data_layer.PersonRepo;
import com.example.picture.model.Person;

@RestController
public class Admin {
    PersonRepo context;
    
    public Admin(PersonRepo context) {
        this.context = context;
    }

    @GetMapping("registration/user")
    public ResponseEntity<ArrayList<Person>> registeredUser() {
        return ResponseEntity.ok(context.selectAll());
    }
}
