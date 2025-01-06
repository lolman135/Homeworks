package homework31.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public boolean isValid(){
        return (title != null && !title.trim().isEmpty()) && (author != null && !author.trim().isEmpty());
    }
}
