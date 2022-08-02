import com.col.util.jdbc.JDBCConnFactory;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class ConnGetDataTableName {
    private Connection conn;
	@Test
	void test() throws SQLException {
		JDBCConnFactory factory = new JDBCConnFactory();
		conn = factory.getConnection("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
		Map tableName = getTableNames("public",conn);
		Iterator it = tableName.entrySet().iterator() ;
		while (it.hasNext()){
    		Map.Entry entry = (Map.Entry) it.next() ;
    		Object value = entry.getValue() ;
    		System.out.println(value);
		}
	}
	
	/**
     * 根据模式名获取该模式下所有表名
     * @author 
     * @param schemaName
     * @return
     * @throws <Long,String>
     */
    public Map<Long, String> getTableNames(String schemaName,Connection conn) throws SQLException  {
//        String sql = "select * from sys_class where (relkind = 'r' or relkind = 'f') and relnamespace = (select oid from sys_namespace where nspname= '" + schemaName + "')";
        String sql ="SELECT DISTINCT table_name, obj_description ( oid, '"+"pg_class"+"' ) AS table_alias FROM information_schema.tables t1, pg_class t2 WHERE  t1.table_name = t2.relname and table_schema ='" + schemaName + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Map<Long, String> tableNames = new HashMap<Long, String>();
        long i =0;
        while(rs.next()){
            i++;
            tableNames.put(i, rs.getString("table_name"))  ;
        }
        try {
            rs.close();
        } catch (SQLException e) {
//          logger.error(e.getMessage(),e);
        }
        try {
            stmt.close();
        } catch (SQLException e) {
//          logger.error(e.getMessage(),e);
        }
        return tableNames;
    }
    /**
     * 根据模式名获取该模式下所有视图名
     * @author 
     * @param schemaName
     * @return
     * @throws <Long,String>
     */
    public Map<Long, String> getViewNames(String schemaName,Connection conn) throws SQLException  {
//        String sql = "select * from sys_class where relkind = 'v' and relnamespace = (select oid from sys_namespace where nspname= '" + schemaName + "')";
        String sql = "select * from pg_views where schemaname= '" + schemaName + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Map<Long, String> viewNames = new HashMap<Long, String>();
        long i=0;
        while(rs.next()){
            i++;
            viewNames.put(i, rs.getString("viewname"))   ;
        }
        try {
            rs.close();
        } catch (SQLException e) {
//            logger.error(e.getMessage(),e);
        }
        try {
            stmt.close();
        } catch (SQLException e) {
//            logger.error(e.getMessage(),e);
        }
        return viewNames;
    }

}
