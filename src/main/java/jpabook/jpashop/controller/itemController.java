package jpabook.jpashop.controller;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.dto.BookFormDto;
import jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class itemController {

    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createForm(Model model){
        model.addAttribute("BookFormDto",new BookFormDto());

        return "items/createItemForm";
    }
    @PostMapping("/items/new")
    public String create(BookFormDto bookFormDto){

        Book book = Book.createBook(bookFormDto);

        itemService.saveItem(book);

        return "redirect:/";
    }
    @GetMapping("/items")
    public String list(Model model){
        List<Item> items = itemService.findItem();
        model.addAttribute("items",items);
        return "items/itemList";
    }

    @GetMapping("items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId")Long itemId, Model model){
        Book item = (Book) itemService.findOne(itemId);

        BookFormDto bookFormDto =new BookFormDto();
        bookFormDto.setId(item.getId());
        bookFormDto.setName(item.getName());
        bookFormDto.setPrice(item.getPrice());
        bookFormDto.setIsbn(item.getIsbn());
        bookFormDto.setAuthor(item.getAuthor());

        model.addAttribute("bookFormDto",bookFormDto);
        return "items/updateItemForm";
    }@PostMapping("items/{itemId}/edit")
    public String updateItem(@PathVariable("itemId")Long itemId,@ModelAttribute("bookFormDto")BookFormDto bookFormDto) {

        itemService.updateItem(itemId,bookFormDto);

        return "redirect:/items";
    }
}
