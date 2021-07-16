package it.truecloud.ddns.felix.models.genre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre {
    /**
     * Genre's name. It must be unique!
     */
    @Id
    private String name;

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {}

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
