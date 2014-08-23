package com.stepin2it.stepin2it.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.stepin2it.stepin2it.model.Weather;

public class JSONParser
{

	public JSONParser()
	{
	}

	private static class WeatherJsonTags
	{

		public static final String TAG_WEATHER_ID = "id";
		public static final String TAG_WEATHER = "weather";
		public static final String TAG_MAIN = "main";
		public static final String TAG_TEMP = "temp";
		public static final String TAG_PRESSURE = "pressure";
		public static final String TAG_TEMP_MIN = "temp_min";
		public static final String TAG_TEMP_MAX = "temp_max";
		public static final String TAG_HUMIDITY = "humidity";

	}

	public Weather parseWeatherJson(String jsonString)
	{

		Weather weatherObj = null;
		try
		{

			JSONObject jsonObject = new JSONObject(jsonString);
			JSONArray weather = jsonObject
					.getJSONArray(WeatherJsonTags.TAG_WEATHER);

			JSONObject weatherObject = weather.getJSONObject(0);

			int weatherId = Integer.parseInt(weatherObject
					.getString(WeatherJsonTags.TAG_WEATHER_ID));

			JSONObject mainObject = jsonObject
					.getJSONObject(WeatherJsonTags.TAG_MAIN);

			float temp = Float.parseFloat(mainObject
					.getString(WeatherJsonTags.TAG_TEMP));
			float pressure = Float.parseFloat(mainObject
					.getString(WeatherJsonTags.TAG_PRESSURE));
			float tempMin = Float.parseFloat(mainObject
					.getString(WeatherJsonTags.TAG_TEMP_MIN));
			float tempMax = Float.parseFloat(mainObject
					.getString(WeatherJsonTags.TAG_TEMP_MAX));
			float humidity = Float.parseFloat(mainObject
					.getString(WeatherJsonTags.TAG_HUMIDITY));

			weatherObj = new Weather(temp, tempMin, tempMax, humidity,
					pressure, weatherId);
		} catch (JSONException e)
		{
			Log.d("TEMPO", e.getMessage());
		}

		return weatherObj;
	}

}
