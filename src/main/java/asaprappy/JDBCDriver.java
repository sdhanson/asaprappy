package asaprappy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDriver {
	public static Connection conn = null;
	public static ResultSet rs = null;
	public static PreparedStatement ps = null;
	// I CHANGED THE ROOT PASSWORD TO MINE
	private static String connectionPath = "jdbc:mysql://localhost:3306/asap_db?user=root&password=Zyadcvnhgb6&useSSL=false&allowPublicKeyRetrieval=True";
	public static void connect(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(connectionPath);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("connection error cnfe: " + cnfe.getMessage());
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("connection error sqle: " + sqle.getMessage());
			sqle.printStackTrace();
		}
	}
	
	public static void close(){
		try{
			if (rs!=null){
				rs.close();
				rs = null;
			}
			if(conn != null){
				conn.close();
				conn = null;
			}
			if(ps != null ){
				ps = null;
			}
		}catch(SQLException sqle){
			System.out.println("Connection close error sqle: ");
			sqle.printStackTrace();
		}
	}

}
