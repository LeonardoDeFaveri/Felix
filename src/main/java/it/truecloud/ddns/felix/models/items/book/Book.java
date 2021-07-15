package it.truecloud.ddns.felix.models.items.book;

import java.util.List;
import java.util.Objects;

import javax.persistence.JoinTable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import it.truecloud.ddns.felix.models.author.Author;
import it.truecloud.ddns.felix.models.editor.Editor;
import it.truecloud.ddns.felix.models.genre.Genre;
import it.truecloud.ddns.felix.models.items.Item;

@Entity
@Table(name = "books")
public class Book extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @JoinColumn(name = "editor", referencedColumnName = "name")
    private Editor editor;

    @Column(name = "isbn_10")
    private String isbn10;

    @Column(name = "isbn_13")
    private String isbn13;

    public Book(Long id, String title, Integer year, Integer month, List<Author> authors,
        List<Genre> genres, Editor editor, String isbn10, String isbn13) {
        super(title, year, month);
        this.id = id;
        this.authors = authors;
        this.genres = genres;
        this.editor = editor;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
    }

    public Book() {}

    public Long getId() {
        return id;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public Editor getEditor() {
        return editor;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
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
