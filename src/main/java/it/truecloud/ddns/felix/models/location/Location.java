package it.truecloud.ddns.felix.models.location;

import java.util.List;
import java.util.Objects;

import it.truecloud.ddns.felix.models.items.Item;

public class Location {
    private long id;
    private String city, address;
    private List<Item> items;

    public Location(long id, String city, String address, List<Item> items) {
        this.id = id;
        this.city = city;
        this.address = address;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Location location = (Location) obj;
        return (location.city.equalsIgnoreCase(city) &&
            location.address.equalsIgnoreCase(address));
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, address);
    }
}