package it.truecloud.ddns.felix.models.Registered;

import java.util.Objects;

/**
 * The class represents a user registered into the library system.
 */
public class Registered {
    private Long id;
    private String firstName, secondName, surname;
    private Long dateOfBirth;
    
    public Registered(Long id, String firstName, String secondName, String surname, Long dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public Registered() {}

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
    }

    public Long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(Long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Registered registered = (Registered) obj;
        return (registered.firstName.equalsIgnoreCase(firstName) &&
            registered.secondName.equalsIgnoreCase(secondName) &&
            registered.surname.equalsIgnoreCase(surname) &&
            registered.dateOfBirth == dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, surname, dateOfBirth);
    }
}