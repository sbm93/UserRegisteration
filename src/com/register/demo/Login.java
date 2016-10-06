package com.register.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.register.db.StoreUser;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String em = request.getParameter("email").trim();
		String pw = request.getParameter("password").trim();
		
		System.out.println(em+" "+pw);
		
		User varify;
		try {
			PrintWriter out = response.getWriter();
			varify = StoreUser.find(em, pw);
			
			System.out.println(varify.getUser());
			
			if(varify.getUser() == "Bad Query") {
				out.println("User name or password is incorrect!! " + varify.toString());
			} else {
				
				HttpSession session=request.getSession(true);				
		        session.setAttribute("email",varify.getEmail());

		        session.setAttribute("password",varify.getPassword());  
		        
		        String address = "/UserRegisteration/dashboard";
		        response.sendRedirect(address);
		        
//		        RequestDispatcher rd=request.getRequestDispatcher(address);  
//		        rd.forward(request, response);
//				out.println("Varified User " + varify.toString() +" ==== > " + session.getAttribute("email")+ " === > " + session.getAttribute("password"));
			}
			System.out.println("varify "+ varify);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
