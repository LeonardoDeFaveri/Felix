package it.truecloud.ddns.felix.models.publisher;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The class represents a books publisher.
 */
@Entity
@Table(name = "publishers")
public class Publisher {
    /**
     * Publisher's name. It must be unique!
     */
    @Id
    private String name;

    public Publisher(String name) {
        this.name = name;
    }

    public Publisher() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(obj);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
