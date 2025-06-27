package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.dto.BookFormDto;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }
    @Transactional
    public void updateItem(Long itemId, BookFormDto bookFormDto){
        Book findItem = (Book) itemRepository.findOne(itemId);
        findItem.setPrice(bookFormDto.getPrice());
        findItem.setName(bookFormDto.getName());
        findItem.setStockQuantity(bookFormDto.getStockQuantity());
        findItem.setAuthor(bookFormDto.getAuthor());
        findItem.setIsbn(bookFormDto.getIsbn());
    }
    public List<Item> findItem(){
        return itemRepository.findAll();
    }
    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }
}
