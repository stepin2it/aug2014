package com.stepin2it.stepin2it.util;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * @author muhammad.bilal
 */


/** This class is a wrapper for string and retrieving shared preferences */
public class SharedPreferencesManager {

	/**Constants */
	public static final String ACTIVATION_CODE = "activationCode";
	public static final String USER_NAME = "userName";
	public static final String TERMS_AND_CONDITIONS_FLAG = "TnC";
	public static final String PROGRESS_BAR_STATUS= "progressBar";
	public static final String GENDER = "gender";
	public static final String BIRTH_YEAR = "birthYear";
	public static final String HEIGHT = "height";
	public static final String WEIGHT = "weight";
	public static final String CIGARETTES = "cigarettes";


	private static final String PREFERENCE_NAME = "TempoPreference";
	private SharedPreferences profile =null;


	public SharedPreferencesManager(Context context){

		profile = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
	}


	public void save(String preference ,String value){

		SharedPreferences.Editor editor = profile.edit();
		editor.putString(preference, value);

		editor.commit();

	}


	public String get(String preference){

		return profile.getString(preference,null);

	}


}