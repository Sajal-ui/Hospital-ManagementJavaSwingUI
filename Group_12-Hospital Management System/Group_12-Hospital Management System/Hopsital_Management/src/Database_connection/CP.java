package Database_connection;
import java.sql.Connection;
import java.sql.DriverManager;
public class CP {
    static Connection con;
	public static Connection createC() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String password="Sajal123#";
            String url = "jdbc:mysql://localhost:3306/hospital";
            con= (Connection) DriverManager.getConnection(url, user, password);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return con;
    }
}
