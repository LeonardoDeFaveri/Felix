package it.truecloud.ddns.felix.models.items.dvd;

import java.util.List;
import java.util.Objects;

import it.truecloud.ddns.felix.models.items.Item;
import it.truecloud.ddns.felix.models.person.Person;

public class DVD extends Item{
    private String producer;
    private List<Person> actors;

    public DVD(long id, String title, Person author, List<String> genres,
        int year, int month, String producer, List<Person> actors) {
        super(id, title, author, genres, year, month);
        this.producer = producer;
        this.actors = actors;
    }

    public String getProducer() {
        return producer;
    }

    public List<Person> getTracks() {
        return actors;
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
