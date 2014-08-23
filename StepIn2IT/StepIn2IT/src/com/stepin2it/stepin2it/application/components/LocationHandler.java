package com.stepin2it.stepin2it.application.components;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;


public class LocationHandler {


	private LocationManager manager= null;
	
	public LocationHandler(Context context){
	
		manager= (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
	}
	
	public Location getCurrentLocation(){
		
		return manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		
	}
	

}
