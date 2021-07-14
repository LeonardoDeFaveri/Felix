package it.truecloud.ddns.felix.models.person;

import java.util.Objects;

public class Person {
    private long id;
    private String firstName;
    private String secondName;
    private String surname;
    private long dateOfBirth;
    
    public Person(long id, String firstName, String secondName, String surname, long dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public long getId() {
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

    public long getDateOfBirth() {
        return dateOfBirth;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Person author = (Person) obj;
        return (author.firstName.equals(firstName) &&
            author.secondName.equals(secondName) &&
            author.surname.equals(surname) &&
            author.dateOfBirth == dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, surname, dateOfBirth);
    }
}
