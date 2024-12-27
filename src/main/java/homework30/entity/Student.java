package homework30.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
@Data
@ToString(exclude = "homeworks")
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student", orphanRemoval = true)
    private Set<Homework> homeworks = new HashSet<>();

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void addHomework(final Homework homework) {
        homeworks.add(homework);
        homework.setStudent(this);
    }

    public void removeHomework(final Homework homework) {
        if (homework != null){
            homeworks.remove(homework);
        }
    }
}
