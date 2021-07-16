package it.truecloud.ddns.felix.models.items.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.truecloud.ddns.felix.Configuration;

@RestController
@RequestMapping(path = Configuration.END_POINT + "books/")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Retrieves all the books in the system.
     * @return
     */
    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }
}