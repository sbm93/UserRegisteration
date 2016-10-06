package com.register.db;

import java.sql.*;

import com.register.demo.*;

public class StoreUser {
	public static boolean RegisterUser(String un,String pw, String  ag, String gd, String ph, String em)  throws SQLException, ClassNotFoundException {
		System.out.println("RegisterUser DB CALL");
		
		Class.forName("org.h2.Driver");
    	Connection conn = DriverManager.
        		getConnection("jdbc:h2:~/test", "sa", "");
    	String SQLQuery = String.format("INSERT INTO USER VALUES (?,?,?,?,?,?)");
    	System.out.println(SQLQuery);
    	
    	PreparedStatement ps = conn.prepareStatement(SQLQuery);
	    ps.setString(1,un);
	    ps.setString(2,pw);
	    ps.setString(3,ag);
	    ps.setString(4,gd);
	    ps.setString(5,ph);
	    ps.setString(6,em);
	    
    	ps.executeUpdate();
    	

		System.out.println("Record is inserted into DBUSER table!");
		ps.close();
		conn.close();
		return true;
	}
	
	public static User find(String em, String pw) throws SQLException, ClassNotFoundException {
		System.out.println(em + "  " + pw);
		User user = new User();
		user.setEmail(em);
		user.setPassword(pw);
		
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.
        		getConnection("jdbc:h2:~/test", "sa", "");
		
		String selectQuery = "SELECT * FROM USER WHERE email LIKE ?";

		
		boolean flag=false;
	    PreparedStatement ps = conn.prepareStatement(selectQuery);
	    ps.setString(1,em+"%");
		ResultSet rs = ps.executeQuery();

		User toReturn = new User(); 
		while (rs.next()) {
			String ruser = rs.getString(1);
			String pass = rs.getString(2);
			String ag = rs.getString(3);
			String gd = rs.getString(4);
			String ph = rs.getString(5);
			String rem = rs.getString(6);

			if(pass.equals(pw)){

				toReturn.setAge(ag);
				toReturn.setEmail(rem);
				toReturn.setGender(gd);
				toReturn.setPassword(pass);
				toReturn.setPhone(ph);
				toReturn.setUser(ruser);
				
			}
			
		}
		rs.close();
		conn.close();
//		if(toReturn !== null){
			return toReturn;
//		}

	}
}
