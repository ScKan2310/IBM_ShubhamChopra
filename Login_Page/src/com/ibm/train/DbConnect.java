package com.ibm.train;

import java.io.IOException;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dbconnect")
public class DbConnect extends HttpServlet {
	PreparedStatement pstmt;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		String inputQuery= "insert into details values(?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindata?serverTimezone=UTC", "root", "");
			pstmt = dbCon.prepareStatement(inputQuery);
			pstmt.setString(1, userName);
			pstmt.setString(2, passWord);
			if(pstmt.executeUpdate()<0)
				System.out.println("Account Made");
		} catch (SQLException e) {
			System.out.println("problem while inputing" + e.getMessage());
		} catch (ClassNotFoundException e) { 
			System.out.println("problem class" + e.getMessage());
		}
		response.sendRedirect("Index.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
