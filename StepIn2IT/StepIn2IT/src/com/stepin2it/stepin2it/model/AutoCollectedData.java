package com.stepin2it.stepin2it.model;

import java.util.Date;

/**
 * @author muhammad.bilal
 */


/** Model class for auto collected data from internet and sensors */
public class AutoCollectedData {

	
	public AutoCollectedData(){
	}
	
	private String date =null;
	private Integer motion=null;
	private Integer screenTime=null;
	private Integer temperature=null;
	private Integer weatherQuality=null;
	
	
	public AutoCollectedData(String date ,int motion , int screenTime, int temperature, int weatherQuality){
		
		this.date= date;
		this.motion = motion;
		this.screenTime = screenTime;
		this.temperature = temperature;
		this.weatherQuality = weatherQuality;

	}
	
	
	public int getMotion() {
		return motion;
	}
	public void setMotion(int motion) {
		this.motion = motion;
	}
	public int getScreenTime() {
		return screenTime;
	}
	public void setScreenTime(int screenTime) {
		this.screenTime = screenTime;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getWeatherQuality() {
		return weatherQuality;
	}
	public void setWeatherQuality(int weatherQuality) {
		this.weatherQuality = weatherQuality;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
