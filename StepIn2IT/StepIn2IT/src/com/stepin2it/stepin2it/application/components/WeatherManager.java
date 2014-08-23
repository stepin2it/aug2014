package com.stepin2it.stepin2it.application.components;

import java.io.IOException;

import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.stepin2it.stepin2it.model.Weather;
import com.stepin2it.stepin2it.util.JSONParser;

/**
 * @author muhammad.bilal
 * 
 */

public class WeatherManager
{

	private static final String TAG = "WeatherManager";
	private final String LATITUDE = "latitude";
	private final String LONGITUDE = "longitude";
	private String weatherUrl = "http://api.openweathermap.org/data/2.5/weather?lat="
			+ LATITUDE + "&lon=" + LONGITUDE + "&mode=json&units=metric";
	private Context context = null;

	public WeatherManager(Context context)
	{
		this.context = context;
	}

	public void getWeartherData()
	{

		try
		{

			LocationHandler locationHandler = new LocationHandler(context);
			Location location = locationHandler.getCurrentLocation();

			String latitude = String.valueOf(location.getLatitude());
			String longitude = String.valueOf(location.getLongitude());

			weatherUrl = weatherUrl.replace(LATITUDE, latitude);
			weatherUrl = weatherUrl.replace(LONGITUDE, longitude);

			String dataString = HttpRequestHandler
					.requestHttpResponse(weatherUrl);

			Log.d(TAG, "---------" + weatherUrl);
			Weather weather = new JSONParser().parseWeatherJson(dataString);

		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

}
