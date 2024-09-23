package com.example.picture.data_layer;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.example.picture.model.Person;

@Repository("PersonRepo")
public class PersonRepo implements DataContext {
    ArrayList<Person> people = new ArrayList<Person>();

    @Override
    public boolean insertIntoDB(Person data) {
        boolean result = people.add(data);
        return result;
    }

    @Override
    public boolean removeFromDB(Person data) {
        boolean result = people.remove(data);
        return result;
    }

    @Override
    public Optional<Person> selectFromDB(String name) {
        for(var item: people) {
            if(item.name().equals(name)) {
                return Optional.of(item);
            }
        }
        return Optional.of(null);
    }

    @Override
    public ArrayList<Person> selectAll() {
        return people;
    }
}
