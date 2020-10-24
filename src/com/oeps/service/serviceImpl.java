/**
 * 
 */
package com.oeps.service;


/**
 * 
 * Contract for the implementation of System Services.
 * 
 * @author S M Jayasekara - IT 19 1616 48
 *
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.*;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.oeps.model.*;
import com.oeps.util.*;

public class serviceImpl implements iService {
	
	public static final Logger log = Logger.getLogger(serviceImpl.class.getName());
	
	private static Connection connection;

	private static Statement statement;
	
	private PreparedStatement preparedStatement;
	
	

	
	/*
	 * implementation of login function
	 */
	@Override
	public user login(String id, String pwd) {
		
		user loggedUser = new user();
		
		try {
			
			connection = connectionUtil.getConnection();
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user where uId = '"+id+"' and password = '"+pwd+"'");
			
			rs.next();
				
				loggedUser.setuId(rs.getString(1));
				loggedUser.setName(rs.getString(2));
				loggedUser.setEmail(rs.getString(3));
				loggedUser.setMobile(rs.getString(4));
				loggedUser.setType(rs.getString(5));
				loggedUser.setDesignation(rs.getString(6));
				loggedUser.setPassword(rs.getString(7));
						
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		
		return loggedUser;

	}
	
	
	
	
	/*
	 * implementation of createEvent method
	 */
	public boolean createEvent(event e1) {
		
		boolean status = false;
		
		try {
			Connection connection = connectionUtil.getConnection();
			
			
			String sql = "INSERT INTO event (uId, title, date, time, venue, theme, package, summary, foods, liquor, sounds, participants, budget, entrance, additional, tags, status) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, e1.getuId());
			pst.setString(2, e1.getTitle());
			pst.setString(3, e1.getDate());
			pst.setString(4, e1.getTime());
			pst.setString(5, e1.getVenue());
			pst.setString(6, e1.getTheme());
			pst.setString(7, e1.getEpackage());
			pst.setString(8, e1.getSummary());
			pst.setString(9, e1.getFoods());
			pst.setString(10, e1.getLiquor());
			pst.setString(11, e1.getSounds());
			pst.setString(12, e1.getParticipants());
			pst.setString(13, e1.getBudget());
			pst.setString(14, e1.getEntrance());
			pst.setString(15, e1.getAdditional());
			pst.setString(16, e1.getTags());
			pst.setString(17, "0");
			
			int rs =pst.executeUpdate();
			
			if(rs > 0) {
				status = true;
			}
			
			connection.close();
			
			
		
			}catch(Exception e){
				log.log(Level.SEVERE, e.getMessage());
			}
		
		return status;
		
	}
	
	
	/*
	 * Implementation of approve event function
	 */
	public void approveEvent(int eId) {
		
		
		
		try {
		Connection connection = connectionUtil.getConnection();
		
		String sql = "update event set status = 1 where eId = '"+eId+"'";
		Statement stmt = connection.createStatement();
		
		int temp = stmt.executeUpdate(sql);
		
		
		}catch(SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		
	}
	
	
	/*
	 * Implementation of reject event function
	 */
	public void rejectEvent(int eId) {
		
		
		
		try {
		Connection connection = connectionUtil.getConnection();
		
		String sql = "update event set status = 2 where eId = '"+eId+"'";
		Statement stmt = connection.createStatement();
		
		int temp = stmt.executeUpdate(sql);
		
		
		}catch(SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		
	}
	
	
	/*
	 * Implementation of delete event function
	 */
	public void deleteEvent(int eId) {
		
		try {
			Connection connection = connectionUtil.getConnection();
			
			String sql = "delete from event where eId = '"+eId+"'";
			Statement stmt = connection.createStatement();
			
			int temp = stmt.executeUpdate(sql);
			
			
			}catch(SQLException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		
	}
	
	
	/*
	 * Implementation of  user register method
	 */
	public boolean register(user u2) {
		
		boolean status = false;
		
		try {
			
			Connection connection = connectionUtil.getConnection();
			
			String sql = "insert into user (uId, name, email, mobile, password) values (?,?,?,?,?)";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, u2.getuId());
			pst.setString(2, u2.getName());
			pst.setString(3, u2.getEmail());
			pst.setString(4, u2.getMobile());
			pst.setString(5, u2.getPassword());
			
			int rs =pst.executeUpdate();
			
			if(rs > 0) {
				status = true;
			}
			
			
		}catch(SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}	
		
		return status;
		
	}
	
	
	/*
	 * Implementation of  admin register method
	 */
	public boolean registerAdmin(user u2) {
		
		boolean status = false;
		
		try {
			
			Connection connection = connectionUtil.getConnection();
			
			String sql = "insert into user (uId, name, email, mobile, type, designation, password) values (?,?,?,?,?,?,?)";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, u2.getuId());
			pst.setString(2, u2.getName());
			pst.setString(3, u2.getEmail());
			pst.setString(4, u2.getMobile());
			pst.setString(5, "1");
			pst.setString(6, u2.getDesignation());
			pst.setString(7, u2.getPassword());
			
			int rs =pst.executeUpdate();
			
			if(rs > 0) {
				status = true;
			}
			
			
		}catch(SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}	
		
		return status;
		
	}
	
	
	/*
	 * Implementation of  book ticket method
	 */
	public void bookTicket(bookings b1) {
		
			try {
			
			Connection connection = connectionUtil.getConnection();
			
			String sql = "insert into bookings (uId, eId, qty, cost) values (?,?,?,?)";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, b1.getuId());
			pst.setString(2, b1.geteId());
			pst.setInt(3, b1.getQty());
			pst.setInt(4, b1.getCost());
			
		
			pst.executeUpdate();
		
			}catch(SQLException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			}	
		
		
	}
	
	
	/*
	 * Implementation of make payment method
	 */
	
	public void makePayment(payments p1) {
		
		try {
			
			Connection connection = connectionUtil.getConnection();
			
			String sql = "insert into payments (uId, cardNo, ccv, cardType, cost) values (?,?,?,?,?)";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, p1.getuId());
			pst.setString(2, p1.getCardNo());
			pst.setString(3, p1.getCcv());
			pst.setString(4, p1.getCardType());
			pst.setString(5, p1.getCost());
			
			pst.executeUpdate();
			
			
			String sql1 = "SELECT * FROM bookings ORDER BY bId DESC LIMIT 1";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql1);
			rs.next();
			
			String sql2 = "update bookings set status = 1 where bId = '"+rs.getString(1)+"'";
			Statement stmt1 = connection.createStatement();
			
			stmt1.executeUpdate(sql2);
			
			
		
			}catch(SQLException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			}	
		
	}
	
	
	
	/*
	 * Implementation of Update Event Function
	 */
	
	public void updateEvent(event e2) {
		
		try {
		Connection connection = connectionUtil.getConnection();
		
		int eId = Integer.parseInt(e2.geteId()); 
		String title = e2.getTitle();
		String date = e2.getDate();
		String time = e2.getTime();
		String venue = e2.getVenue();
		String theme = e2.getTheme();
		String pack = e2.getEpackage();
		String foods = e2.getFoods();
		String liquor = e2.getLiquor();
		String sounds = e2.getSounds();
		String participants = e2.getParticipants();
		String budget = e2.getBudget();
		String entrance = e2.getEntrance();
		
		String sql = " update event set title ='"+title+"', date ='"+date+"', time ='"+time+"', venue ='"+venue+"', theme ='"+theme+"', package ='"+pack+"', foods ='"+foods+"', liquor ='"+liquor+"', sounds ='"+sounds+"', participants ='"+participants+"', budget ='"+budget+"', entrance ='"+entrance+"' where eId ='"+eId+"' ";
		
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate(sql);
		
		
		}catch(SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		
		
	}
	
	
	
	/*
	 * Implementation of Change Password Function
	 */
	
	public boolean changePassword(user u3, String newPwd) {
		
		boolean status = false;
		
		try {
			Connection connection = connectionUtil.getConnection();
			
			String uId = u3.getuId();
			String cpwd = u3.getPassword();
		
			String sql = "select * from user where uId ='"+uId+"' ";
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			
			if(cpwd.equals(rs.getString("password"))) {
				
				String sql1 = "update user set password = '"+newPwd+"' where uId ='"+uId+"' ";
				
				Statement stmt1 = connection.createStatement();
				int query = stmt1.executeUpdate(sql1);
				
				if(query > 0) {
					 status = true;
				}
				
				
			}
			else {
				 status = false;
			}
			
		
		}catch(SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		
		return status;
	}
	
	
	

	/*
	 * Implementation of Update Profile Function
	 */
	
	public boolean updateProfile(user u4, String cuId) {
		
		boolean status = false;
		
		try {
			Connection connection = connectionUtil.getConnection();
			
			String uId = u4.getuId();
			String name = u4.getName();
			String email = u4.getEmail();
			String mobile = u4.getMobile();
			
			String sql = "update user set uId ='"+uId+"', name ='"+name+"', email ='"+email+"', mobile ='"+mobile+"' where uId ='"+cuId+"' ";
			
			Statement stmt = connection.createStatement();
			int query = stmt.executeUpdate(sql);
			
			if(query > 0) {
				status = true;
			}
				
		
		}catch(SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		
		return status;
		
	}
	
	
	
	/*
	 * Implementation of delete user function
	 */
	public void deleteUser(String uId) {
		
		try {
			Connection connection = connectionUtil.getConnection();
			
			String sql = "delete from user where uId = '"+uId+"'";
			Statement stmt = connection.createStatement();
			
			int temp = stmt.executeUpdate(sql);
			
			
			}catch(SQLException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		
	}
	
	
	/*
	 * Implementation of delete booking function
	 */
	public void deleteBooking(String bId1) {
		
		try {
			Connection connection = connectionUtil.getConnection();
			
			int bId = Integer.parseInt(bId1);
			
			String sql = "delete from bookings where bId = '"+bId+"'";
			Statement stmt = connection.createStatement();
			
			int temp = stmt.executeUpdate(sql);
			
			
			}catch(SQLException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		
	}
	
	
	
	/*
	 * Implementation of delete payment function
	 */
	public void deletePayment(String pId1) {
		
		try {
			Connection connection = connectionUtil.getConnection();
			
			int pId = Integer.parseInt(pId1);
			
			String sql = "delete from payments where pId = '"+pId+"'";
			Statement stmt = connection.createStatement();
			
			int temp = stmt.executeUpdate(sql);
			
			
			}catch(SQLException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		
	}
	
	
	
	/*
	 * Implementation of News Letter Subscription
	 */
	public void newsletter(newsLetter n1) {
		
		try {
			
			String email = n1.getEmail();
			
			Connection connection = connectionUtil.getConnection();
			
			String sql = "insert into newsletter (email) values ('"+email+"')";
			
			Statement stmt = connection.createStatement();
			
			stmt.execute(sql);		
			
		}catch(SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		
	}
	
	
	
		
}

	






