import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TesterSQL04{
    public static void main(String[] args) throws SQLException{

        Connection connection = null;
        try {
            String url       = "jdbc:mysql://localhost:3306/newdb";
            String user      = "developer";
            String password  = "Develhope1!";

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connecting to mySQL!");

            Statement statement = connection.createStatement();
            System.out.println("Altering a table, adding new column");
            String alterQuery = "ALTER TABLE students " +
                    "ADD country VARCHAR(30);";
            statement.executeUpdate(alterQuery);
            String populateQuery1 = "UPDATE students " +
                    "SET country = 'Italy' " +
                    "WHERE student_id <= '2';";
            String populateQuery2 = "UPDATE students " +
                    "SET country = 'Germany' " +
                    "WHERE student_id > '2' AND student_id <= '4';";
            statement.executeUpdate(populateQuery1);
            statement.executeUpdate(populateQuery2);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                if(connection !=null )
                    connection.close();
            }catch(SQLException exception){
                System.out.println(exception.getMessage());
            }
        }

    }
}
