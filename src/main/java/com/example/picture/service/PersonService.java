package com.example.picture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.picture.data_layer.DataContext;
import com.example.picture.model.Person;

@Service
public class PersonService {
    private final DataContext context;
    
    @Autowired
    public PersonService(@Qualifier("PersonRepo") DataContext context) {
        this.context = context;
    }

    public boolean login(String name) {
        var logedIn = context.selectFromDB(name);
        return logedIn.isPresent();
    }

    public void logout() {

    }

    public boolean register(Person person) {
        return context.insertIntoDB(person);
    }
}
