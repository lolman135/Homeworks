package homework29.app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public void insertEmployee(Employee employee) {
        String insertStatement = "INSERT INTO employees(name, age, position, salary) VALUES (?, ?, ?, ?);";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertStatement)) {

            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getAge());
            statement.setString(3, employee.getPosition());
            statement.setInt(4, employee.getSalary());

            statement.execute();

            System.out.println("Insert " + employee + " into table.");

        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    public List<Employee> getAllEmployees() {

        String getAllStatement = "SELECT * FROM employees;";
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(getAllStatement);

            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("position"),
                        resultSet.getInt("salary")
                );
                employees.add(employee);
            }

            System.out.println("Success: get all users!");

        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        return employees;
    }

    public Employee getEmployeeBtId(int id) {

        Employee employee = null;

        String getByIdStatement = "SELECT * FROM employees WHERE id = ?";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(getByIdStatement)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    employee = new Employee(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("age"),
                            resultSet.getString("position"),
                            resultSet.getInt("salary")
                    );
                } else {
                    System.out.println("User with id=" + id + " not found");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return employee;
    }

    public void updateEmployee(Employee employee){

        String updateStatement = "UPDATE employees SET name = ?, age = ?, position = ?, salary = ? WHERE id = ?";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateStatement)){

            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getAge());
            statement.setString(3, employee.getPosition());
            statement.setInt(4, employee.getSalary());
            statement.setInt(5, employee.getId());

            int amountOfUpdatedEmployees = statement.executeUpdate();
            System.out.println("Updated " + amountOfUpdatedEmployees + " rows.");

        } catch (SQLException e){
            System.out.println("Error:" + e.getMessage());
        }
    }

    public void deleteEmployee(int id){
        String deleteById = "DELETE FROM employees WHERE id = ?";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteById)){

            statement.setInt(1, id);
            int amountOfDeletedEmployees = statement.executeUpdate();
            System.out.println("Deleted " + amountOfDeletedEmployees + "rows");
        } catch (SQLException e){
            System.out.println("Error:" + e.getMessage());
        }
    }


}
