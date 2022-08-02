import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCtest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection(url, "postgres", "123456");
		conn.close();
		if(conn.isClosed()==false) {
		    conn.close();
		}
		System.out.println(conn);
	}
}
