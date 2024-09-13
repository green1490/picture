package com.example.picture.data_layer;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.example.picture.model.Person;

@Repository("PersonRepo")
public class PersonRepo implements DataContext {
    ArrayList<Person> people = new ArrayList<Person>();

    @Override
    public int insertIntoDB(Person data) {
        boolean result = people.add(data);
        if (result == true) {
            return 1;
        }
        return -1;
    }
    
}
