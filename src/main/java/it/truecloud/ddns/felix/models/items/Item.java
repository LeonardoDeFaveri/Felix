package it.truecloud.ddns.felix.models.items;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Item {
    protected String title;
    protected Integer year;
    protected Integer month;

    public Item(String title, Integer year, Integer month) {
        this.title = title;
        this.year = year;
        this.month = month;
    }

    public Item() {}

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMonth() {
        return month;
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
}