package sg.com.mices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.mices.entity.Item;
import sg.com.mices.entity.ItemRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public ItemService( ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item findById(int id){
        return itemRepository.findById(id).orElse(new Item());
    }

    public List<Item> findAll(){
        return StreamSupport.stream(
                itemRepository.findAll().spliterator(), false
        ).collect(Collectors.toList());
    }

    public Item save(Item item){
        return itemRepository.save(item);
    }

    public void delete(Item item){itemRepository.delete(item);}


}
