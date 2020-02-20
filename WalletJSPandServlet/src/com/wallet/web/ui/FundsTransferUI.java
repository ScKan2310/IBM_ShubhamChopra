package com.wallet.web.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wallet.web.bean.Bean;
import com.wallet.web.service.WalletWebServiceClass;


@WebServlet("/fundstransferui")
public class FundsTransferUI extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		WalletWebServiceClass service = new WalletWebServiceClass();
		RequestDispatcher dispatcher = null;
		Random rand = new Random();
		Bean b = new Bean();
		if(request.getSession(false)==null) {
			out.println("session ended");
			dispatcher = request.getRequestDispatcher("Index.html");
			dispatcher.include(request, response);		
		}
		else {
			java.util.Date d = new java.util.Date();
			java.sql.Date d1 = new java.sql.Date(d.getTime());
			b.setTransactionTime(d1);
			
			b.setHolderContactNumber(Double.parseDouble(request.getParameter("senderContactNumber")));
			b.setTransctionAmount(Integer.parseInt(request.getParameter("transactionAmount")));
			if(service.serveWithdrawFromAccount(b)==2) {
				b.setHolderContactNumber(Double.parseDouble(request.getParameter("receiverContactNumber")));
				if(service.serveDepositInAccount(b)==2) {
					out.println("Amount Deposited");
				}
				else {
					out.println("Amount not deposited");
				}
			out.println("Amount Withrawn");
			dispatcher = request.getRequestDispatcher("Logout.html");
			dispatcher.include(request, response);
			}
			else {
				out.println("Amount not withdraw <br> try again");
				dispatcher = request.getRequestDispatcher("Login.html");
				dispatcher.include(request, response);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
