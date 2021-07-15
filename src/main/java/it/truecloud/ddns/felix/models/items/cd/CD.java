package it.truecloud.ddns.felix.models.items.cd;

import java.util.List;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import it.truecloud.ddns.felix.models.author.Author;
import it.truecloud.ddns.felix.models.items.Item;
import it.truecloud.ddns.felix.models.items.cd.track.Track;

public class CD extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Long getId() {
        return id;
    }

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

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        CD cd = (CD) obj;
        return (cd.title.equalsIgnoreCase(title) &&
            cd.year == year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
    }    
}