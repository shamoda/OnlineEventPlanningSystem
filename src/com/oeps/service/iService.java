/**
 * 
 */
package com.oeps.service;

import java.sql.ResultSet;

import com.oeps.model.*;

/**
 * 
 * Contract for the declaration of System Services.
 * 
 * @author S M Jayasekara - IT 19 1616 48
 *
 */
public interface iService {
	
	/*
	 * Perform Log in function
	 */
	public user login(String id, String pwd);
	
	
	/*
	 * Creating new event
	 */
	public boolean createEvent(event e1);
	
	/*
	 * Approve event
	 */
	public void approveEvent(int eId);
	
	/*
	 * Reject event
	 */
	public void rejectEvent(int eId);

	/*
	 * Delete event
	 */
	public void deleteEvent(int eId);
	
	/*
	 * Register new user 
	 */
	public boolean register(user u2);
	
	/*
	 * Register new admin 
	 */
	public boolean registerAdmin(user u2);
	
	/*
	 * Book ticket
	 */
	public void bookTicket(bookings b1);
	
	/*
	 * make payment
	 */
	public void makePayment(payments p1);
	
	/*
	 * Update Event
	 */
	public void updateEvent(event e2);
	
	/*
	 * Change Password
	 */
	public boolean changePassword(user u3, String newPwd);
	
	/*
	 * Update Profile
	 */
	public boolean updateProfile(user u4, String cuId);
	
	/*
	 * delete User
	 */
	public void deleteUser(String uId);
	
	/*
	 * delete Booking
	 */
	public void deleteBooking(String bId);
	
	/*
	 * delete Payment
	 */
	public void deletePayment(String pId);
	
	/*
	 * News Letter Subscribes
	 */
	public void newsletter(newsLetter n1);
	
	
	
	
}
