package com.example.picture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.picture.data_layer.DataContext;

@Service
public class PersonService {
    private final DataContext context;
    
    @Autowired
    public PersonService(@Qualifier("PersonRepo") DataContext context) {
        this.context = context;
    }

    public boolean login() {
        return false;
    }
}
