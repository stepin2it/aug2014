package com.stepin2it.stepin2it.model;

public class Weather {

	
	public Weather(){
	}
	
	public Weather(float temperature, float temperatureMin, float temperatureMax, float humidity, float pressure, int weatherId){
		

		this.temperature = temperature;
		this.temperatureMin = temperatureMin;
		this.temperatureMax = temperatureMax;
		this.humidity = humidity;
		this.pressure = pressure;
		this.weatherId = weatherId;
		
	}
	

	private float temperature;
	private float temperatureMin;
	private float temperatureMax;
	private float humidity;
	private float pressure;
	private int weatherId;
	
	

	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public float getTemperatureMin() {
		return temperatureMin;
	}
	public void setTemperatureMin(float temperatureMin) {
		this.temperatureMin = temperatureMin;
	}
	public float getTemperatureMax() {
		return temperatureMax;
	}
	public void setTemperatureMax(float temperatureMax) {
		this.temperatureMax = temperatureMax;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	public int getWeatherId() {
		return weatherId;
	}
	public void setWeatherId(int weatherId) {
		this.weatherId = weatherId;
	}
	
	
	
}
