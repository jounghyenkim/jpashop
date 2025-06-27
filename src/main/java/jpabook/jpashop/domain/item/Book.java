package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jpabook.jpashop.dto.BookFormDto;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B")
@Getter @Setter
public class Book extends Item{
    private String author;
    private String isbn;

    public static Book createBook(BookFormDto bookFormDto){
        Book book =new Book();
        book.setName(bookFormDto.getName());
        book.setPrice(bookFormDto.getPrice());
        book.setAuthor(bookFormDto.getAuthor());
        book.setIsbn(bookFormDto.getIsbn());
        book.setStockQuantity(bookFormDto.getStockQuantity());
        return book;
    }
}
