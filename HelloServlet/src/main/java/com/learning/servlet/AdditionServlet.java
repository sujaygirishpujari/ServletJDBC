package com.learning.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class AdditionServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("number1") != "" && request.getParameter("number2") != "") {
			long number1 = Long.parseLong(request.getParameter("number1"));
			long number2 = Long.parseLong(request.getParameter("number2"));
			try (PrintWriter out = response.getWriter()) {
				out.println("Addition of " + number1 + " & " + number2 + " is : " + (number1 + number2));
			}
		}
	}

}
