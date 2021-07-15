package it.truecloud.ddns.felix.models.items.dvd;

import java.util.List;
import java.util.Objects;

import it.truecloud.ddns.felix.models.author.Author;
import it.truecloud.ddns.felix.models.items.Item;

public class DVD extends Item{
    private List<Author> authors;
    private List<String> genres;
    private String producer;
    private List<Author> actors;

    public DVD(Long id, String title, Integer year, Integer month,
        List<Author> authors, List<String> genres,String producer, List<Author> actors) {
        super(title, year, month);
        this.authors = authors;
        this.genres = genres;
        this.producer = producer;
        this.actors = actors;
    }

    public DVD() {}

    public List<Author> getAuthors() {
        return authors;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getProducer() {
        return producer;
    }

    public List<Author> getTracks() {
        return actors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public List<Author> getActors() {
        return actors;
    }

    public void setActors(List<Author> actors) {
        this.actors = actors;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        DVD dvd = (DVD) obj;
        return (dvd.title.equalsIgnoreCase(title) &&
            dvd.year == year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
    }
}
