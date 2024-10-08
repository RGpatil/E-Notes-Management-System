package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.User.UserDetails;

public class UserDAO {
	
		private static  Connection conn;

		public UserDAO(Connection conn) {
			super();
			this.conn=conn;
		}


		public static boolean addUser(UserDetails us)
		{
			boolean f=false;
			try 
			{
				String query="insert into user(name,email,password) values(?,?,?)";
				
				PreparedStatement ps=conn.prepareStatement(query);
				ps.setString(1,us.getName());
				ps.setString(2,us.getEmail());
				ps.setString(3,us.getPassword());
				int i=ps.executeUpdate();
				
				if(i==1)
				{
					f=true;
				}
				
				
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			
			
			return f;
		}
		
		
		
		public boolean loginUser(UserDetails us) 
		{
			boolean f=false;
			
			
			try {
				
			String query="select * from user where email=? and password=?";				
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,us.getEmail());
			ps.setString(2,us.getPassword());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				f=true;
			}
				
			
			
			} catch (Exception e)
			{
				e.printStackTrace();
				
			}
			
			return f;
		}

}


