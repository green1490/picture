package com.example.picture.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.picture.model.Person;
import io.swagger.v3.oas.annotations.Parameter;



@RestController()
public class User {
    
    @GetMapping
    public void login(@Parameter String name) {
        System.out.println(name);
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody Person person) {
        System.out.println(person.password());
        return ResponseEntity.ok("null");
    }
}
