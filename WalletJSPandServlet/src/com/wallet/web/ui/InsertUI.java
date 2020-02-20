package com.wallet.web.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wallet.web.bean.Bean;
import com.wallet.web.service.WalletWebServiceClass;

@WebServlet("/insertui")
public class InsertUI extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			WalletWebServiceClass service = new WalletWebServiceClass();
			RequestDispatcher dispatcher = null;
			Bean b = new Bean();
			Random rand = new Random();
			if(request.getSession(false)==null) {
				out.println("session ended");
				dispatcher = request.getRequestDispatcher("Index.html");
				dispatcher.include(request, response);		
			}
			else {
				b.setHolderContactNumber(Double.parseDouble(request.getParameter("holderContactNumber")));
				b.setPassWord(request.getParameter("passWord"));
				b.setHolderName(request.getParameter("holderName"));
				b.setAccountBalance(Integer.parseInt(request.getParameter("accountBalance")));
				int accountNumber = rand.nextInt(Integer.MAX_VALUE)+1;
				b.setAccountNumber(accountNumber);
				if(service.serveInsert(b)==2) {
					out.println("account created");
					dispatcher = request.getRequestDispatcher("Logout.html");
					dispatcher.include(request, response);
				}
				else {
					out.println("account not created <br> try again");
					dispatcher = request.getRequestDispatcher("Login.html");
					dispatcher.include(request, response);
				}
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
