import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TesterSQL03 {
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        List<String> surnames = new ArrayList<>();
        try {
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "Develhope1!";

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connecting to mySQL!");

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT last_name, first_name FROM students;\n");

            while (rs.next()) {
                System.out.println(rs.getString("last_name"));
                surnames.add(rs.getString("first_name"));
            }
            System.out.println("All the surnames: " + surnames);
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

    }
}
