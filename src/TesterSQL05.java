import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TesterSQL05{
    public static void main(String[] args) throws SQLException{

        Connection connection = null;
        List<Student> italian_students =new ArrayList();
        List<Student> german_students = new ArrayList();

        try {
            String url       = "jdbc:mysql://localhost:3306/newdb";
            String user      = "developer";
            String password  = "Develhope1!";

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connecting to mySQL!");


            Statement statement = connection.createStatement();
            String createItalianStudentView = "CREATE VIEW italian_students AS " +
                    "SELECT last_name, first_name " +
                    "FROM students " +
                    "WHERE country = 'Italy';";
            statement.executeUpdate(createItalianStudentView);

            String createGermanStudentView = "CREATE VIEW german_students AS " +
                    "SELECT last_name, first_name " +
                    "FROM students " +
                    "WHERE country = 'Germany';";
            statement.executeUpdate(createGermanStudentView);

            String useItalianStudentView = "SELECT * FROM italian_students; ";
            String useGermanStudentView = "SELECT * FROM german_students; ";

            ResultSet italianResultView = statement.executeQuery(useItalianStudentView);
            while (italianResultView.next()) {
              String name = italianResultView.getString("last_name");
              String surname = italianResultView.getString("first_name");
              Student italianStudent = new Student(name,surname);
              italian_students.add(italianStudent);
            }

            ResultSet germanResultView = statement.executeQuery(useGermanStudentView);
            while (germanResultView.next()) {
                String name = germanResultView.getString("last_name");
                String surname = germanResultView.getString("first_name");
                Student germanStudent = new Student(name,surname);
                german_students.add(germanStudent);
            }


            for (Student italianStudent : italian_students) {
                System.out.println("[Italian Student] - Name: " + italianStudent.getName() + ", Surname: " + italianStudent.getSurname());
            }

           for (Student germanStudent : german_students) {
               System.out.println("[German Student] Name: " + germanStudent.getName() + " Surname: " + germanStudent.getSurname());
           }


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