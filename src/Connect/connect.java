package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {
	public static Connection con = null;
	private static connect instance= new connect();
	
	public static connect getInstance() {
		return instance;
	}
	public Connection connect() throws SQLException {
            
		String url ="jdbc:sqlserver://localhost:1433;dataBaseName=QLBHDAD";
		String user="sa";
		String password="sa";
		con = DriverManager.getConnection(url, user, password);
		return con;
	}
	public void disconnect() {
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
	public static Connection getConnection() {
		return con;
	}
}