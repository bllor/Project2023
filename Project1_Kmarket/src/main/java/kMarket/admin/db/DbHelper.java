package kMarket.admin.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;

public class DbHelper {
    protected Connection conn = null;
    protected PreparedStatement psmt = null;
    protected PreparedStatement psmt1 = null;
    protected Statement stmt = null;
    protected ResultSet rs = null;

    public Connection getConnection() {

        try {
            Context ctx = (Context) new InitialContext().lookup("java:comp/env");

            DataSource ds = (DataSource) ctx.lookup("jdbc/kMarketLocal");
            conn = ds.getConnection();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void close() throws SQLException {
        if(rs != null) {
            rs.close();
        }
        if(stmt != null) {
            stmt.close();
        }
        if(psmt != null) {
            psmt.close();
        }
        if(psmt1 != null) {
            psmt1.close();
        }
        if(conn != null) {
            conn.close();
        }
    }
}
