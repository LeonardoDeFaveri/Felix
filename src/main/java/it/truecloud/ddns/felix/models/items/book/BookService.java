package it.truecloud.ddns.felix.models.items.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Retrieves all the book in the system.
     * @return
     */
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}