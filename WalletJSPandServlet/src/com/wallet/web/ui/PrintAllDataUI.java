package com.wallet.web.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wallet.web.bean.Bean;
import com.wallet.web.service.WalletWebServiceClass;


@WebServlet("/printalldataui")
public class PrintAllDataUI extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		WalletWebServiceClass service = new WalletWebServiceClass();
		RequestDispatcher dispatcher = null;
		Bean b = new Bean();
		if(request.getSession(false)==null) {
			out.println("session ended");
			dispatcher = request.getRequestDispatcher("Index.html");
			
			dispatcher.include(request, response);		
		}
		else {
			List<Bean> bilers = service.serveGetAllData(b);
			for(Bean val : bilers) {
				out.println(val.printData() + "<br");
				out.println("*********  <br>");
	
			}
			dispatcher = request.getRequestDispatcher("Logout.html");
			dispatcher.include(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
