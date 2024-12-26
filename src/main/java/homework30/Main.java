package homework30;

import homework30.dao.HomeworkDAO;
import homework30.dao.StudentDAO;
import homework30.entity.Homework;
import homework30.entity.Student;
import homework30.utils.HibernateUtil;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        try {

            Student student1 = new Student("John", "Doe", "john.doe@example.com");
            Homework homework1 = new Homework("Math Homework", 95, LocalDate.now().plusDays(7));

            // Связываем студента и домашнее задание
            student1.addHomework(homework1);

            // Сохраняем студента (домашнее задание сохранится каскадно)
            studentDAO.save(student1);

            System.out.println("Saved students: ");
            studentDAO.findAll().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutDown();
        }
    }
}
