package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo {
	public static void main(String[] args) {
		Connection con=null;
		ResultSet rs=null;
		Statement st=null;
		
		try {
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/Students";
			String name="postgres";
			String pass="1234";
			con=DriverManager.getConnection(url,name,pass);
			st=con.createStatement();
			rs=st.executeQuery("SELECT * FROM Students");
			while(rs.next()){
				System.out.print("ID: " + rs.getInt("StuID"));
				System.out.print("Name: " + rs.getString("StuName"));
				System.out.print("Sex: " + rs.getString("Sex"));
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
}
