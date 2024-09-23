package com.example.picture.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.picture.data_layer.PersonRepo;



@RestController
public class Picture {
    
    PersonRepo context;

    public Picture(PersonRepo context) {
        this.context = context;
    }

    // fix it
    @PostMapping("upload")
    public ResponseEntity<String> uploadData(@RequestBody com.example.picture.model.Picture pic) {
        var person = context.selectFromDB(pic.user().name());
        if (person.isPresent()) {
            return ResponseEntity.ok().body("Pic is uploaded");
        }
        return ResponseEntity.badRequest().body("Couldnt uploaded it");
    }
}
