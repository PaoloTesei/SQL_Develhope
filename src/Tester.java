import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Tester{
    public static void main(String[] args) throws SQLException{

        Connection connection = null;
        try {
            String url       = "jdbc:mysql://localhost:3306/newdb";
            String user      = "developer";
            String password  = "Develhope1!";

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connecting to mySQL!");
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

