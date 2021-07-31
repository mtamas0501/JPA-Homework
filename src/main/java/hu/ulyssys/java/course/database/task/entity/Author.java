package hu.ulyssys.java.course.database.task.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "author")
public class Author extends AbstractProperty implements Serializable {

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name="last_name" , nullable = false)
    private String lastName;
    @Column(name="username" , nullable = false)
    private String username;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
