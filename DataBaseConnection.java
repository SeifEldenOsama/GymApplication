package GymApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataBaseConnection {

	private final static String Url="jdbc:sqlserver://LAPTOP-FHP65JJJ\\SQLSERVER;databaseName=gym;integratedsecurity=true;encrypt=false";

    public static Connection Connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection Con=DriverManager.getConnection(Url);
            return Con;
        } catch (SQLException | ClassNotFoundException E) {
            System.out.println(E.getMessage());
            return null;
        }
    }	
}
