package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.UserDetails;


//@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response )throws ServerException,IOException
	{
		
		String name=request.getParameter("fname");
		String email=request.getParameter("uemail");
		String password=request.getParameter("upassword");
		
		UserDetails us=new UserDetails(); 
		us.setName(name);
		us.setEmail(email);
		us.setPassword(password);
		
		UserDAO dao=new UserDAO(DBConnect.getConn());
		boolean f=dao.addUser(us);
		HttpSession session;
		
		if(f)
		{
				 session=request.getSession();
				session.setAttribute("reg-sucess", "Registration Sucessfully..!");
				response.sendRedirect("register.jsp");
		}
		
		else
		{
			session=request.getSession();
			session.setAttribute("reg-failed", "Something Wronged..");
			response.sendRedirect("register.jsp");


		}
	}
	
}
