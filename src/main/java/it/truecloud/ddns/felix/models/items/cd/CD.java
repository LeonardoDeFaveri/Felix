package it.truecloud.ddns.felix.models.items.cd;

import java.util.List;
import java.util.Objects;

import it.truecloud.ddns.felix.models.items.Item;
import it.truecloud.ddns.felix.models.items.cd.track.Track;
import it.truecloud.ddns.felix.models.person.Person;

public class CD extends Item {
    private String producer;
    private List<Track> tracks;

    public CD(long id, String title, Person author, List<String> genres,
        int year, int month, String producer, List<Track> tracks) {
        super(id, title, author, genres, year, month);
        this.producer = producer;
        this.tracks = tracks;
    }

    public String getProducer() {
        return producer;
    }

    public List<Track> getTracks() {
        return tracks;
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