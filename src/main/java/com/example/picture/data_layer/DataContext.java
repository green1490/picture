package com.example.picture.data_layer;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Component;
import com.example.picture.model.Person;

@Component
public interface DataContext {
    boolean insertIntoDB(Person data);
    boolean removeFromDB(Person data);
    Optional<Person> selectFromDB(String data);
    ArrayList<Person> selectAll();
}
