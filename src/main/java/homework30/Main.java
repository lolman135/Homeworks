package homework30;

import homework30.dao.StudentDAO;
import homework30.entity.Homework;
import homework30.entity.Student;
import homework30.utils.HibernateUtil;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        try {

            Student student1 = new Student("Garold", "Mercer", "garold.man@example.com");
            Student student2 = new Student("Jane", "Smith", "jane.smith@example.com");
            Student student3 = new Student("Emily", "Jones", "emily.jones@example.com");

            Homework homework1 = new Homework("Math Homework", 95,
                    LocalDate.now().plusDays(7));
            Homework homework2 = new Homework("Physics Homework", 90,
                    LocalDate.now().plusDays(10));
            Homework homework3 = new Homework("Chemistry Homework", 85,
                    LocalDate.now().plusDays(5));
            Homework homework4 = new Homework("English Homework", 87,
                    LocalDate.now().plusDays(6));

            student1.addHomework(homework1);
            student1.addHomework(homework4);
            student2.addHomework(homework3);
            student3.addHomework(homework2);

            studentDAO.save(student1);
            studentDAO.save(student2);
            studentDAO.save(student3);

            System.out.println("Saved students: ");
            studentDAO.findAll().forEach(System.out::println);

            System.out.println("Saved homework assignments: ");

            student1.setLastName("Smith");
            studentDAO.update(student1);
            System.out.println("Updated student: " + studentDAO.findById(student1.getId()));

            System.out.println("Students after update and delete: ");
            studentDAO.findAll().forEach(System.out::println);

            studentDAO.deleteById(3L);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutDown();
        }
    }
}
