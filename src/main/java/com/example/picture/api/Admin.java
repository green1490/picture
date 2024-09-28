package com.example.picture.api;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.picture.data_layer.PersonRepo;
import com.example.picture.model.Person;

import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class Admin {
    PersonRepo context;
    
    public Admin(PersonRepo context) {
        this.context = context;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("api/list/users")
    public ResponseEntity<ArrayList<Person>> registeredUser() {
        return ResponseEntity.ok(context.selectAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("api/list/{user}")
    public ResponseEntity<String> userPassword(@Parameter String user) {
        Optional<Person> person = context.selectFromDB(user);
        if (person.isPresent()) {
            return ResponseEntity.ok(person.get().name());
        }
        return ResponseEntity.ok("Wrong user name!");
    }
}
