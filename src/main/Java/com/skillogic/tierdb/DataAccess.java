package com.skillogic.tierdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;

import com.skillogic.pojos.UserPojo;
import com.skillogic.tierprojservlet.RegistrationServlet;

public class DataAccess {
	private static final String USER_INSERT="insert into users(user_name, user_email, user_contact, user_gender, user_city, user_address, user_hobbies) values(?,?,?,?,?,?,?)";
	public int insert(UserPojo up) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Srimanbanala20#");
		pstmt=con.prepareStatement(USER_INSERT);
		
		pstmt.setString(1, up.getUserName() );
		pstmt.setString(2,up.getUserEmail());
		pstmt.setString(3, up.getUserNumber());
		pstmt.setString(4,up.getGender());
		pstmt.setString(5,up.getCity());
		pstmt.setString(6, up.getAddress());
		pstmt.setString(7,up.getHobbies());
		
		result=pstmt.executeUpdate();
		
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException se) {
		se.printStackTrace();
	}finally {
		if(pstmt!=null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	return result;}
}
