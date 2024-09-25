package com.example.picture.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.picture.data_layer.DataContext;
import com.example.picture.model.Person;
import com.example.picture.service.PersonService;
import io.swagger.v3.oas.annotations.Parameter;



@RestController()
public class User {
    DataContext context;
    PersonService service;

    @GetMapping
    public ResponseEntity<String> login(@Parameter String name) {
        if (service.login(name) == true) {
            return ResponseEntity.ok().body("Successful login!");
        }
        return ResponseEntity.badRequest().body("Wrong credentials!");
    }

    public User(DataContext context, PersonService service) {
        this.context = context;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody Person person) {
        var isSuccessful = service.register(person);
        if(isSuccessful) {
            return ResponseEntity.ok("Successful registration");
        }
        return ResponseEntity.internalServerError().body("Couldnt make the account");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        service.logout();
        return ResponseEntity.ok().body("Loged out!");
    }
}
