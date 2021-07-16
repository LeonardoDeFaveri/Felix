package it.truecloud.ddns.felix.models.items.dvd;

import java.util.List;

import it.truecloud.ddns.felix.models.items.Item;
import it.truecloud.ddns.felix.models.persons.actor.Actor;
import it.truecloud.ddns.felix.models.persons.author.Author;

public class DVD extends Item{
    private List<Author> authors;
    private List<String> genres;
    private String producer;
    private List<Actor> actors;

    public DVD(Long id, String title, Integer year, Integer month,
        List<Author> authors, List<String> genres,String producer, List<Actor> actors) {
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

    public List<Actor> getActors() {
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

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
