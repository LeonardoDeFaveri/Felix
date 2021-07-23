package it.truecloud.ddns.felix.models.items.cd.track;

import java.util.Objects;

/**
 * The class represent a single track of a CD.
 */
public class Track {
    private Long id;
    private String name;
    /**
     * Duration in seconds.
     */
    private Long duration;

    public Track(Long id, String name, Long duration) {
        this.name = name;
        this.duration = duration;
    }

    public Track() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getDuration() {
        return duration;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Track track = (Track) obj;
        return (track.name.equalsIgnoreCase(name) && track.duration == duration);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, duration);
    }
}