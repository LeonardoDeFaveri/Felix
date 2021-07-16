package it.truecloud.ddns.felix.models.items;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    protected String title;
    protected Integer year;
    protected Integer month;

    public Item(String title, Integer year, Integer month) {
        this.title = title;
        this.year = year;
        this.month = month;
    }

    public Item() {}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Item item = (Item) obj;
        return (item.title.equalsIgnoreCase(title) &&
            item.year == year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
    }
}