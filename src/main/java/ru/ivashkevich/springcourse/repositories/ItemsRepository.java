package ru.ivashkevich.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ivashkevich.springcourse.models.Item;
import ru.ivashkevich.springcourse.models.Person;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer>{
        List<Item> findByOwner(Person owner);

        List<Item> findByName(String name);
}
