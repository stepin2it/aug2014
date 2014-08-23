package com.stepin2it.stepin2it.model;

import java.util.Date;



/** 
 * @author muhammad.bilal
 */

/**Model class for user daily check-ins*/
public class DailyCheckIns {

	
	public DailyCheckIns(){
	};
	
	private String date=null;
	private Integer mood=null;
	private Integer symptoms=null;
	private Integer cigarettes=null;
	private Integer glassesOfWater=null;
	private Integer exercise=null;
	private Integer medication=null;
	private Integer sleep=null;
	private String wellnessDairyNote=null;
	
	
	public DailyCheckIns(String date,int mood, int symptoms,int cigarettes, int glassesOfWater, int exercise, Integer medication , int sleep , String wellnessDairy){
		
		this.date =date;
		this.mood = mood;
		this.symptoms = symptoms;
		this.cigarettes = cigarettes;
		this.glassesOfWater = glassesOfWater;
		this.exercise = exercise;
		this.medication = medication;
		this.sleep = sleep;
		this.wellnessDairyNote = wellnessDairy;
		
	}
	
	
	
	public int getMood() {
		return mood;
	}
	public void setMood(int mood) {
		this.mood = mood;
	}
	public int getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(int symptoms) {
		this.symptoms = symptoms;
	}
	public int getCigarettes() {
		return cigarettes;
	}
	public void setCigarettes(int cigarettes) {
		this.cigarettes = cigarettes;
	}
	public int getGlassesOfWater() {
		return glassesOfWater;
	}
	public void setGlassesOfWater(int glassesOfWater) {
		this.glassesOfWater = glassesOfWater;
	}
	public int getExercise() {
		return exercise;
	}
	public void setExercise(int exercise) {
		this.exercise = exercise;
	}
	public Integer getMedication() {
		return medication;
	}
	public void setMedication(Integer medication) {
		this.medication = medication;
	}
	public int getSleep() {
		return sleep;
	}
	public void setSleep(int sleep) {
		this.sleep = sleep;
	}
	public String getWellnessDairyNote() {
		return wellnessDairyNote;
	}
	public void setWellnessDairyNote(String wellnessDairyNote) {
		this.wellnessDairyNote = wellnessDairyNote;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
