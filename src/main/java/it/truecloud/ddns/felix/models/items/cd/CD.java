package it.truecloud.ddns.felix.models.items.cd;

import java.util.List;

import it.truecloud.ddns.felix.models.items.Item;
import it.truecloud.ddns.felix.models.items.cd.track.Track;
import it.truecloud.ddns.felix.models.persons.author.Author;

public class CD extends Item {
    private List<Author> authors;
    private List<String> genres;
    private String producer;
    private List<Track> tracks;

    public CD(Long id, String title, Integer year, Integer month,
        List<Author> authors, List<String> genres, String producer, List<Track> tracks) {
        super(title, year, month);
        this.authors = authors;
        this.genres = genres;
        this.producer = producer;
        this.tracks = tracks;
    }

    public CD() {}

    public List<Author> getAuthors() {
        return authors;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getProducer() {
        return producer;
    }

    public List<Track> getTracks() {
        return tracks;
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

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}