import com.col.util.jdbc.JDBCConnFactory;
import com.col.util.jdbc.JDBCConnPool;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

class JdbcConnPoolTest {

	@Test
	void test() throws SQLException {
		JDBCConnFactory factory = new JDBCConnFactory();
		Connection conn = factory.getConnection("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
//		conn.close();
		Connection conn2 = factory.getConnection("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
		conn2.close();
//		conn.close();
//		conn.close();
		Connection conn3 = factory.getConnection("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
		Statement stmt3 = conn3.createStatement();
		Map<String, JDBCConnPool> pools = factory.getJdbcConnPools();
		Connection conn1 = factory.getConnection("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from public.edge_table");
		while(rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
		}
		rs.close();
		stmt.close();
//		System.out.println(conn);
		conn.close();
		conn = factory.getConnection("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from public.edge_table");
		while(rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
		}
		rs.close();
		stmt.close();
		System.out.println(conn);
		conn.close();
	}

}
