package com.wellsfargo.fsd.jw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/team")
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session=request.getSession();
		
		List<String> members=(List<String>) session.getAttribute("teamMembers");
		
		if(members==null) { 
			
			members=new ArrayList<String>();
		 }
		  
		  String memName=request.getParameter("member");
		 
		  if(memName!=null) {
			members.add(memName);
		  }
		
		session.setAttribute("teamMembers", members);
		
		request.getRequestDispatcher("teamPage.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
