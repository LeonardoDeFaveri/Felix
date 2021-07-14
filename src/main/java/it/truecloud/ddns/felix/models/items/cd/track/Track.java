package it.truecloud.ddns.felix.models.items.cd.track;

import java.util.Objects;

public class Track {
    private long id;
    private String name;
    private long duration;

    public Track(long id, String name, long duration) {
        this.name = name;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getDuration() {
        return duration;
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
