package homework30.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "homework")
@ToString(exclude = "student")
@NoArgsConstructor
@Getter
@Setter
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "mark")
    private int mark;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public Homework(String description, int mark, LocalDate deadline) {
        this.description = description;
        this.mark = mark;
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Homework homework = (Homework) o;
        return mark == homework.mark && Objects.equals(id, homework.id) && Objects.equals(description, homework.description) && Objects.equals(deadline, homework.deadline) && Objects.equals(student, homework.student);
    }

}
