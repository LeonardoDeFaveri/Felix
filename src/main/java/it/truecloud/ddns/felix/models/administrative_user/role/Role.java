package it.truecloud.ddns.felix.models.administrative_user.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    private Integer id;
    private String name;

    @Column(name = "from_datetime")
    private Long from;
    @Column(name = "to_datetime")
    private Long to;

    public Role(Integer id, String name, Long from, Long to) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
    }

    public Role() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Role role = (Role) obj;
        return (role.id == id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}