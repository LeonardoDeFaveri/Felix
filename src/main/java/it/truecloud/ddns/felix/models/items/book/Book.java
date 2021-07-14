package it.truecloud.ddns.felix.models.items.book;

import java.util.List;
import java.util.Objects;

import it.truecloud.ddns.felix.models.items.Item;
import it.truecloud.ddns.felix.models.person.Person;

public class Book extends Item {
    private String editor;
    private String isbn10, isbn13;

    public Book(long id, String title, Person author, List<String> genres,
        int year, int month, String editor, String isbn10, String isbn13) {
        super(id, title, author, genres, year, month);
        this.editor = editor;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
    }

    public String getEditor() {
        return editor;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Book book = (Book) obj;
        return (book.isbn10.equalsIgnoreCase(isbn10) &&
            book.isbn13.equalsIgnoreCase(isbn13));
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn10, isbn13);
    }
}
