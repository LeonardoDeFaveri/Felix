package it.truecloud.ddns.felix.models.items.book;

import java.util.List;

import javax.persistence.JoinTable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import it.truecloud.ddns.felix.models.genre.Genre;
import it.truecloud.ddns.felix.models.items.Item;
import it.truecloud.ddns.felix.models.persons.author.Author;
import it.truecloud.ddns.felix.models.publisher.Publisher;

@Entity
@Table(name = "books")
public class Book extends Item {
    @ManyToMany
    @JoinTable(
        name = "authors_books",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    @ManyToMany
    @JoinTable(
        name = "genres_books",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns =  @JoinColumn(name = "genre_name")
    )
    private List<Genre> genres;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher", referencedColumnName = "name")
    private Publisher editor;

    @Column(name = "isbn_10")
    private String isbn10;

    @Column(name = "isbn_13")
    private String isbn13;

    public Book(Long id, String title, Integer year, Integer month, List<Author> authors,
        List<Genre> genres, Publisher editor, String isbn10, String isbn13) {
        super(title, year, month);
        this.id = id;
        this.authors = authors;
        this.genres = genres;
        this.editor = editor;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
    }

    public Book() {}

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public Publisher getEditor() {
        return editor;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void setEditor(Publisher editor) {
        this.editor = editor;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }
}