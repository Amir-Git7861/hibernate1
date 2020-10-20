package com.wellsfargo.fsd.jw.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletB")
public class ServletB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	public ServletB() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String m1=request.getParameter("m1");
		System.out.println("ServletB: " +m1);
		String m2=(String)request.getAttribute("m2");
		System.out.println("ServletB: " +m2);
		String m3=" A msg from Servletm B";
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		out.println("<h3>Param from clent: " +m1+"</h3>");
		out.println("<h3>Attrib from ServletA: " +m2+"</h3>");
		out.println("<h3>Attrib from ServletB: " +m3+"</h3>");
		out.println("<hr/><a href='index.jsp'>Home</a>");
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
