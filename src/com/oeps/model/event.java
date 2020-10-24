/**
 * 
 */
package com.oeps.model;

/**
 * This is the event model class
 * 
 * @author S M Jayasekara - IT 19 1616 48
 *
 */
public class event {
	
	private String eId;
	
	private String uId;
	
	private String title;
	
	private String venue;
	
	private String date;
	
	private String time;
	
	private String theme;
	
	private String epackage;
	
	private String participants;
	
	private String summary;
	
	private String budget;
	
	private String entrance;
	
	private String tags;
	
	private String foods;
	
	private String sounds;
	
	private String liquor;
	
	private String status;
	
	private String additional;

	/**
	 * @return the eId
	 */
	public String geteId() {
		return eId;
	}

	/**
	 * @param eId the eId to set
	 */
	public void seteId(String eId) {
		this.eId = eId;
	}

	/**
	 * @return the uId
	 */
	public String getuId() {
		return uId;
	}

	/**
	 * @param uId the uId to set
	 */
	public void setuId(String uId) {
		this.uId = uId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the venue
	 */
	public String getVenue() {
		return venue;
	}

	/**
	 * @param venue the venue to set
	 */
	public void setVenue(String venue) {
		this.venue = venue;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * @return the epackage
	 */
	public String getEpackage() {
		return epackage;
	}

	/**
	 * @param epackage the epackage to set
	 */
	public void setEpackage(String epackage) {
		this.epackage = epackage;
	}

	/**
	 * @return the participants
	 */
	public String getParticipants() {
		return participants;
	}

	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(String participants) {
		this.participants = participants;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the budget
	 */
	public String getBudget() {
		return budget;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(String budget) {
		this.budget = budget;
	}

	/**
	 * @return the entrance
	 */
	public String getEntrance() {
		return entrance;
	}

	/**
	 * @param entrance the entrance to set
	 */
	public void setEntrance(String entrance) {
		this.entrance = entrance;
	}

	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * @return the foods
	 */
	public String getFoods() {
		return foods;
	}

	/**
	 * @param foods the foods to set
	 */
	public void setFoods(String foods) {
		this.foods = foods;
	}

	/**
	 * @return the sounds
	 */
	public String getSounds() {
		return sounds;
	}

	/**
	 * @param sounds the sounds to set
	 */
	public void setSounds(String sounds) {
		this.sounds = sounds;
	}

	/**
	 * @return the liquor
	 */
	public String getLiquor() {
		return liquor;
	}

	/**
	 * @param liquor the liquor to set
	 */
	public void setLiquor(String liquor) {
		this.liquor = liquor;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the additional
	 */
	public String getAdditional() {
		return additional;
	}

	/**
	 * @param additional the additional to set
	 */
	public void setAdditional(String additional) {
		this.additional = additional;
	}

	@Override
	public String toString() {
		return "event [eId=" + eId + ", uId=" + uId + ", title=" + title + ", venue=" + venue + ", date=" + date
				+ ", time=" + time + ", theme=" + theme + ", epackage=" + epackage + ", participants=" + participants
				+ ", summary=" + summary + ", budget=" + budget + ", entrance=" + entrance + ", tags=" + tags
				+ ", foods=" + foods + ", sounds=" + sounds + ", liquor=" + liquor + ", status=" + status
				+ ", additional=" + additional + "]";
	}
	

}
