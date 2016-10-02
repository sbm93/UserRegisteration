package com.register.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.register.db.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("here i m in get method");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println("here i m in post method");
		String un = request.getParameter("user");
		String pw = request.getParameter("password");
		String ag = request.getParameter("age");
		String gd = request.getParameter("gender");
		String ph = request.getParameter("phone");
		String em = request.getParameter("email");

		User user = new User(un, pw, ag, gd, ph, em);
//		System.out.println(un+ pw+ ag+ gd+ ph+ em);
		
		boolean store = false;

		try {
			store = StoreUser.RegisterUser(un, pw, ag, gd, ph, em);
			PrintWriter out = response.getWriter();
			if(store == true){				
				out.println("In If Condition!! " + user.toString());
				System.out.println("In If Condition!!");
			} else {
				out.println("Some Error Occured");
				
				System.out.println("In else conditon!!");
			}
			System.out.println(store);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
