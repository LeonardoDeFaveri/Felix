package it.truecloud.ddns.felix.models.editor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "editors")
public class Editor {
    @Id
    private String name;

    public Editor(String name) {
        this.name = name;
    }

    public Editor() {}

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
