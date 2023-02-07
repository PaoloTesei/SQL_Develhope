import java.sql.*;

public class TesterSQL02{
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "Develhope1!");
            Statement statement = connection.createStatement();
            System.out.println("Creating my first table");
            String createQuery = "CREATE TABLE IF NOT EXISTS students\n( student_id INT(10) NOT NULL AUTO_INCREMENT,\n  last_name VARCHAR(30),\n  first_name VARCHAR(25),\n  CONSTRAINT students_pk PRIMARY KEY (student_id)\n);\n";
            statement.executeUpdate(createQuery);
            System.out.println("Populating my first table");
            String populateQuery = "INSERT INTO students (last_name, first_name)\nVALUES ('Paolo', 'Tesei'),('Al', 'Pacino'),('Thomas', 'Turbato'),('Margot', 'Robbie');\n";
            statement.executeUpdate(populateQuery);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException exception) {
                System.out.println(exception.getMessage());
            }
        }


    }}