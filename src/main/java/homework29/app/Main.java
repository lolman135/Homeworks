package homework29.app;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseConnector.init();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        Employee employee1 = new Employee("Max", 45, "Boss", 1500);
        Employee employee2 = new Employee("Daniel", 29, "HR", 900);
        Employee employee3 = new Employee("Marcus", 30, "IT", 1000);
        Employee employee4 = new Employee("Leo", 25, "IT", 1000);
        Employee employee5 = new Employee("Ronald", 22, "Sales", 700);

        employeeDAO.insertEmployee(employee1);
        employeeDAO.insertEmployee(employee2);
        employeeDAO.insertEmployee(employee3);
        employeeDAO.insertEmployee(employee4);
        employeeDAO.insertEmployee(employee5);

        List<Employee> employees = employeeDAO.getAllEmployees();
        employees.forEach(System.out::println);

        Employee concreteEmployee = employeeDAO.getEmployeeBtId(3);
        System.out.println(concreteEmployee);

        employee5 = new Employee(5, "John", 19, "Post", 900);
        employeeDAO.updateEmployee(employee5);

        employeeDAO.deleteEmployee(4);
    }
}
