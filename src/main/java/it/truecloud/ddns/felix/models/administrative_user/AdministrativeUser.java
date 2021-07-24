package it.truecloud.ddns.felix.models.administrative_user;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.truecloud.ddns.felix.models.administrative_user.role.Role;

/**
 * The classe represents a user with administrative privileges.
 * The privilege level can be one of these:
 * General User (0) [Not represented]:
 *      can see all items in the system
 *  Library Employee (1):
 *      can borrow and take up items, can do interlibrary
 *      exchanges, can add/remove/modify an item in its library, can
 *      register new users (Registered) and remove/modify them
 *  Library Super Employee (2):
 *      can add/remove/modify Library Employees
 *  Super User (3):
 *      can add/remove/modify Library Super Employees
 */
@Entity
@Table(name = "users")
public class AdministrativeUser implements Serializable {
    /**
     * User's email. It must be unique!
     */
    @Id
    private String email;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    private String surname;

    @JsonIgnore // This way password isn't return as an attribute of JSON Object
    private String password;
    
    @ManyToMany
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(name = "user_email"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    public AdministrativeUser(String email, String firstName, String secondName, String surname, List<Role> roles,
            String password) {
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.roles = roles;
        this.password = password;
    }

    public AdministrativeUser() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        AdministrativeUser administrativeUser = (AdministrativeUser) obj;
        return (administrativeUser.email.equals(email));
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}