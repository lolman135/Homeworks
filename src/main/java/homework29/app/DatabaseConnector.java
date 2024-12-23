package homework29.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {

    public static void init(){
        try(Connection connection = DriverManager
                .getConnection(DatabaseProperties.URL, DatabaseProperties.USER, DatabaseProperties.PASSWORD);
            Statement statement = connection.createStatement()) {

            String createStatement = "CREATE TABLE IF NOT EXISTS employees(" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "age INT, " +
                    "position VARCHAR(50), " +
                    "salary INT);";
            statement.execute(createStatement);

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DatabaseProperties.URL, DatabaseProperties.USER, DatabaseProperties.PASSWORD);
    }
}
