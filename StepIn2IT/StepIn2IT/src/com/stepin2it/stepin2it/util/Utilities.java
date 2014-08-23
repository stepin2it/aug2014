package com.stepin2it.stepin2it.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.database.Cursor;
import android.text.format.DateFormat;

import com.stepin2it.stepin2it.application.components.DataBaseHandler.TableAutoCollectedData;
import com.stepin2it.stepin2it.application.components.DataBaseHandler.TableDailyCheckIns;
import com.stepin2it.stepin2it.model.AutoCollectedData;
import com.stepin2it.stepin2it.model.DailyCheckIns;



/**
 * @author muhammad.bilal
 */

/** This class has utility methods */

public class Utilities {

	/**
	 * @return current date as string with Sqlite date format e.g  YYYY-MM-DD
	 */
	public static String getCurrentDateAsSqliteString(){

		return DateFormat.format("yyyy-MM-dd", new java.util.Date()).toString();		
	}

	public static Date convertStringToDate(String date) throws ParseException{

		return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	}


	public static DailyCheckIns[] convertToDailyCheckInsObjects(Cursor cursor){


		DailyCheckIns array[] = null;
		if(cursor != null){

			array = new DailyCheckIns[cursor.getCount()];
			int i=0;
			if(cursor.moveToFirst()){
				do{
					String date = cursor.isNull(TableDailyCheckIns.INDEX_DATE)  ? null : cursor.getString(TableDailyCheckIns.INDEX_DATE);
					Integer mood = cursor.isNull(TableDailyCheckIns.INDEX_MOOD) ? null : cursor.getInt(TableDailyCheckIns.INDEX_MOOD);
					Integer  symptoms= cursor.isNull(TableDailyCheckIns.INDEX_SYMPTOMS) ? null : cursor.getInt(TableDailyCheckIns.INDEX_SYMPTOMS);
					Integer cigarettes = cursor.isNull(TableDailyCheckIns.INDEX_CIGARETTES) ? null : cursor.getInt(TableDailyCheckIns.INDEX_CIGARETTES);
					Integer glassesOfWater = cursor.isNull(TableDailyCheckIns.INDEX_GLASSESOFWATER) ? null : cursor.getInt(TableDailyCheckIns.INDEX_GLASSESOFWATER);
					Integer exercise = cursor.isNull(TableDailyCheckIns.INDEX_EXERCISE) ? null : cursor.getInt(TableDailyCheckIns.INDEX_EXERCISE);
					Integer medication = cursor.isNull(TableDailyCheckIns.INDEX_MEDICATION) ? null : cursor.getInt(TableDailyCheckIns.INDEX_MEDICATION);
					Integer sleep = cursor.isNull(TableDailyCheckIns.INDEX_SLEEP) ? null : cursor.getInt(TableDailyCheckIns.INDEX_SLEEP);
					String wellnessDairyNote = cursor.isNull(TableDailyCheckIns.INDEX_WELLNESSDAIRYNOTE) ? null : cursor.getString(TableDailyCheckIns.INDEX_WELLNESSDAIRYNOTE);
					array[i] = new DailyCheckIns(date,mood, symptoms, cigarettes, glassesOfWater, exercise, medication, sleep, wellnessDairyNote);
					i++;
				}while(cursor.moveToNext());
			}

		}


		return array;
	}


	public static AutoCollectedData[] convertToAutoCollectedDataObjects(Cursor cursor){


		AutoCollectedData array[] = null;
		if(cursor != null){

			array = new AutoCollectedData[cursor.getCount()];
			int i=0;
			if(cursor.moveToFirst()){
				do{
					String date = cursor.isNull(TableAutoCollectedData.INDEX_DATE)  ? null : cursor.getString(TableAutoCollectedData.INDEX_DATE);
					Integer motion = cursor.isNull(TableAutoCollectedData.INDEX_MOTION) ? null : cursor.getInt(TableAutoCollectedData.INDEX_MOTION);
					Integer screenTime = cursor.isNull(TableAutoCollectedData.INDEX_SCREENTIME) ? null : cursor.getInt(TableAutoCollectedData.INDEX_SCREENTIME);
					Integer temperature = cursor.isNull(TableAutoCollectedData.INDEX_TEMPERATURE) ? null : cursor.getInt(TableAutoCollectedData.INDEX_TEMPERATURE);
					Integer weatherQuality = cursor.isNull(TableAutoCollectedData.INDEX_WEATHERQUALITY) ? null : cursor.getInt(TableAutoCollectedData.INDEX_WEATHERQUALITY);

					array[i] = new AutoCollectedData(date, motion, screenTime, temperature, weatherQuality);
					i++;
				}while(cursor.moveToNext());
			}

		}


		return array;
	}








}
