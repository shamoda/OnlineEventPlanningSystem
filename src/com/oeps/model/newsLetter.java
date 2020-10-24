package com.oeps.model;

/*
 * This is the newsLetter model class
 * 
 * @author S M Jayasekara - IT 19 1616 48
 */


public class newsLetter {
	
	private String nId;
	
	private String email;

	/**
	 * @return the nId
	 */
	public String getnId() {
		return nId;
	}

	/**
	 * @param nId the nId to set
	 */
	public void setnId(String nId) {
		this.nId = nId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "newsLetter [nId=" + nId + ", email=" + email + "]";
	}

}
