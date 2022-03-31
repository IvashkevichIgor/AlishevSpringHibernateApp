package ru.ivashkevich.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.ivashkevich.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", 32, "tom@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Jack", 25, "jack@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Diana", 18, "diana@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Stephen", 74, "stephen@mail.com"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(person -> person.getId() == id);
    }
}
