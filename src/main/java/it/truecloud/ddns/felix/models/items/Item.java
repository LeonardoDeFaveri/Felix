package it.truecloud.ddns.felix.models.items;

import java.util.List;
import java.util.Objects;

import it.truecloud.ddns.felix.models.person.Person;

public abstract class Item {
    protected long id;
    protected String title;
    protected Person author;
    protected List<String> genres;
    protected int year, month;

    public Item(long id, String title, Person author, List<String> genres, int year, int month) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genres = genres;
        this.year = year;
        this.month = month;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Person getAuthor() {
        return author;
    }

    public List<String> getGenres() {
        return genres;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author.hashCode(), genres.hashCode(), year, month);
    }
}