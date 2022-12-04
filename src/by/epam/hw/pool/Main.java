package by.epam.hw.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static final String QUERY = "SELECT * FROM users";
	public static void main(String[] args) throws SQLException, ConnectionPoolException{
		ConnectionPool pool = new ConnectionPool();
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			pool.initPoolData();
			con = pool.takeConnection();
			st = con.createStatement();
			rs = st.executeQuery(QUERY);
		
		while(rs.next()) {
			System.out.println(rs.getInt("id") + " - "  + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4));
		}
		pool.dispose();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
