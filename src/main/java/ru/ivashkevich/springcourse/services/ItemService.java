package ru.ivashkevich.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivashkevich.springcourse.models.Item;
import ru.ivashkevich.springcourse.models.Person;
import ru.ivashkevich.springcourse.repositories.ItemsRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Item> findByOwner(Person owner){
        return itemsRepository.findByOwner(owner);
    }

    public List<Item> findByName(String name){
        return itemsRepository.findByName(name);
    }
}
