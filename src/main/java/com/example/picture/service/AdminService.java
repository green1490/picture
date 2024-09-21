package com.example.picture.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import com.example.picture.data_layer.DataContext;
import com.example.picture.data_layer.PersonRepo;
import com.example.picture.model.Person;

@Service
public class AdminService {
    
    DataContext context;
    
    public AdminService(PersonRepo personRepo) {
        context = personRepo;
    }

    public ArrayList<Person> allRegisteredUser() {
        return context.selectAll();
    }
}
