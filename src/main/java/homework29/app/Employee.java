package homework29.app;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    private int id;
    private String name;
    private int age;
    private String position;
    private int salary;

    public Employee(String name, int age, String position, int salary) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.salary = salary;
    }
}
