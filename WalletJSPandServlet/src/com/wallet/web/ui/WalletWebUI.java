package com.wallet.web.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.wallet.web.bean.Bean;
import com.wallet.web.service.WalletWebServiceClass;

@WebServlet("/walletwebUI")
public class WalletWebUI extends HttpServlet {
	PreparedStatement pstmt;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Bean b = new Bean();
		PrintWriter out = response.getWriter();
		
		WalletWebServiceClass service = new WalletWebServiceClass();
		HttpSession session = request.getSession();
		b.setHolderContactNumber(Double.parseDouble(request.getParameter("holderContactNumber")));
		b.setPassWord(request.getParameter("passWord"));
		
		if(service.serveCheckPassword(b)==2) {
			out.println("logged in");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.html");
			dispatcher.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
