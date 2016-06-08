package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Student;
import getConnection.dbConnection;

public class getAllStudent {
	static Connection con=dbConnection.getInstance().getConnection();;
	static PreparedStatement pre;
	static Statement st;
	static ResultSet rs;
	private ArrayList<Student> student=new ArrayList<>();
	
	public ArrayList<Student> getStudent(Student stu) {	
		try {
			String sql="SELECT * FROM tbstudent ORDER BY id";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				stu=new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setSex(rs.getString("sex"));
				student.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return student;
	}
	
	public boolean removeStudent(Student stu) throws Exception {
		String sql="DELETE FROM tbstudent WHERE id=?";
		pre=con.prepareStatement(sql);
		pre.setInt(1,stu.getId());
		int rowEffected=pre.executeUpdate();
		
		if(rowEffected>0)
			return true;
		
		return false;
	}
	
	public boolean updateStudent(Student stu) throws Exception {
		String sql="UPDATE tbStudent SET name=?,sex=? WHERE id=?";
		pre=con.prepareStatement(sql);		
		pre.setString(1, stu.getName());
		pre.setString(2, stu.getSex());
		pre.setInt(3,stu.getId());
		int rowEffected=pre.executeUpdate();
		
		if(rowEffected>0)
			return true;
		
		return false;
	}
	
	public boolean insertStudent(Student stu) throws SQLException{
		String sql="INSERT INTO tbStudent VALUES(?,?,?)";
		pre=con.prepareStatement(sql);
		pre.setInt(1,stu.getId());
		pre.setString(2, stu.getName());
		pre.setString(3, stu.getSex());
		int rowEffected=pre.executeUpdate();
		
		if(rowEffected>0)
			return true;
		
		return false;
	}
	
	public String searchStudent(Student stu) throws SQLException{
		String sql="SELECT * FROM tbstudent WHERE id=?";
		pre=con.prepareStatement(sql);
		pre.setInt(1,stu.getId());
		rs=pre.executeQuery();
		while(rs.next()){
			stu.setId(rs.getInt("id"));
			stu.setName(rs.getString("name"));
			stu.setSex(rs.getString("sex"));
		}
		
		return stu.toString();
	}
}
