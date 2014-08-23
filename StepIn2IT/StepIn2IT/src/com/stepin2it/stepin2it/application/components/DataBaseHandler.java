package com.stepin2it.stepin2it.application.components;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.stepin2it.stepin2it.model.AutoCollectedData;
import com.stepin2it.stepin2it.model.DailyCheckIns;
import com.stepin2it.stepin2it.util.Utilities;


/**
 * @author muhammad.bilal
 */


/** This class handles database and tables creation*/
public class DataBaseHandler extends SQLiteOpenHelper{


	// Database version
	private static final int DATABASE_VERSION = 1;
	// Database name
	private static final String DATABASE_NAME = "TempoDB";

	// Tables 
	private static final String TABLE_DAILY_CHECKINS = "dailyCheckIns";
	private static final String TABLE_AUTO_COLLECTED_DATA = "autoCollectedData";

	// dailyCheckIns table columns names 
	public static class TableDailyCheckIns{
		public static final String COL_DATE = "date";
		public static final String COL_MOOD= "mood";
		public static final String COL_SYMPTOMS= "symptoms";
		public static final String COL_CIGARETTES = "cigarettes";
		public static final String COL_GLASSESOFWATER = "glassesOfWater";
		public static final String COL_EXERCISE = "exercise";
		public static final String COL_MEDICATION = "medication";
		public static final String COL_SLEEP = "sleep";
		public static final String COL_WELLNESSDAIRYNOTE = "wellnessDairyNote";
		
		public static final int INDEX_DATE=0;
		public static final int INDEX_MOOD=1;
		public static final int INDEX_SYMPTOMS=2;
		public static final int INDEX_CIGARETTES=3;
		public static final int INDEX_GLASSESOFWATER=4;
		public static final int INDEX_EXERCISE=5;
		public static final int INDEX_MEDICATION=6;
		public static final int INDEX_SLEEP=7;
		public static final int INDEX_WELLNESSDAIRYNOTE=8;
	}

	// autoCollectedData table columns names
	public static class TableAutoCollectedData{
		public static final String COL_DATE = "date";
		public static final String COL_MOTION = "motion";
		public static final String COL_SCREENTIME = "screenTime";
		public static final String COL_TEMPERATURE = "temperature";
		public static final String COL_WEATHERQUALITY = "weatherQuality";
		
		
		public static final int INDEX_DATE=0;
		public static final int INDEX_MOTION=1;
		public static final int INDEX_SCREENTIME=2;
		public static final int INDEX_TEMPERATURE=3;
		public static final int INDEX_WEATHERQUALITY=4;


	}



	// autoCollectedData table creation string 
	String CREATE_AUTO_COLLECTED_DATA_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_AUTO_COLLECTED_DATA + "("
			+ TableAutoCollectedData.COL_DATE + " TEXT PRIMARY KEY," + TableAutoCollectedData.COL_MOTION + " INTEGER,"
			+ TableAutoCollectedData.COL_SCREENTIME + " INTEGER," + TableAutoCollectedData.COL_TEMPERATURE + " INTEGER," +
			TableAutoCollectedData.COL_WEATHERQUALITY + " INTEGER" +" )";


	// dailyCheckIns table creation string 
	String CREATE_DAILY_CHECKINS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_DAILY_CHECKINS + "("
			+ TableDailyCheckIns.COL_DATE + " TEXT PRIMARY KEY," + TableDailyCheckIns.COL_MOOD + " INTEGER,"
			+ TableDailyCheckIns.COL_SYMPTOMS + " INTEGER," + TableDailyCheckIns.COL_CIGARETTES + " INTEGER," +
			TableDailyCheckIns.COL_GLASSESOFWATER + " INTEGER," + TableDailyCheckIns.COL_EXERCISE + " INTEGER," +
			TableDailyCheckIns.COL_MEDICATION + " INTEGER," + TableDailyCheckIns.COL_SLEEP + " INTEGER," +
			TableDailyCheckIns.COL_WELLNESSDAIRYNOTE + " TEXT" +" )";


	public DataBaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		// executing autoCollectedData table creation command
		db.execSQL(CREATE_AUTO_COLLECTED_DATA_TABLE);

		//executing dailyCheckIns table creation command
		db.execSQL(CREATE_AUTO_COLLECTED_DATA_TABLE);


	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


		// Drop older tables if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_AUTO_COLLECTED_DATA);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_DAILY_CHECKINS);

		// Create tables again
		onCreate(db);

	}

	public long saveDailyCheckInsObject(DailyCheckIns obj){

		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values =  new ContentValues();
		values.put(TableDailyCheckIns.COL_DATE,Utilities.getCurrentDateAsSqliteString());
		values.put(TableDailyCheckIns.COL_MOOD, obj.getMood());
		values.put(TableDailyCheckIns.COL_SYMPTOMS, obj.getSymptoms());
		values.put(TableDailyCheckIns.COL_CIGARETTES, obj.getCigarettes());
		values.put(TableDailyCheckIns.COL_GLASSESOFWATER, obj.getGlassesOfWater());
		values.put(TableDailyCheckIns.COL_EXERCISE, obj.getExercise());
		values.put(TableDailyCheckIns.COL_MEDICATION, obj.getMedication());
		values.put(TableDailyCheckIns.COL_SLEEP, obj.getSleep());
		values.put(TableDailyCheckIns.COL_WELLNESSDAIRYNOTE, obj.getWellnessDairyNote());

		long rowId =db.insert(TABLE_DAILY_CHECKINS, null, values);
		db.close();

		return rowId;

	}
	
	public long saveAutoCollectedDataObject(AutoCollectedData obj){

		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values =  new ContentValues();
		values.put(TableAutoCollectedData.COL_DATE,Utilities.getCurrentDateAsSqliteString());
		values.put(TableAutoCollectedData.COL_MOTION, obj.getMotion());
		values.put(TableAutoCollectedData.COL_SCREENTIME, obj.getScreenTime());
		values.put(TableAutoCollectedData.COL_TEMPERATURE, obj.getTemperature());
		values.put(TableAutoCollectedData.COL_WEATHERQUALITY, obj.getWeatherQuality());
		
		
		long rowId =db.insert(TABLE_AUTO_COLLECTED_DATA, null, values);
		db.close();

		return rowId;

	}


	public long insert (String tableName , String []col ,  String []val){

		SQLiteDatabase db =this.getWritableDatabase();

		ContentValues values = new ContentValues();
		for(int i=0 ; i< col.length ;i++){
			values.put(col[i], val[i]);
		}

		long rowId =db.insert(tableName, null, values);
		db.close();

		return rowId;
	}


	public int update(String tableName , String []col ,  String []val ,String whereClause, String []whereArgs){

		SQLiteDatabase db= this.getWritableDatabase();

		ContentValues values = new ContentValues();
		for(int i=0 ; i< col.length ;i++){
			values.put(col[i], val[i]);
		}

		int rowsAffected =db.update(tableName, values, whereClause, whereArgs);
		db.close();

		return rowsAffected;
	}


	/**
	 * This Method can insert or update based upon the date if entries have been inserted or not 
	 * @param tableName :  name of the table to do operation 
	 * @param col : columns of table  
	 * @param val : mapping of column values 
	 * @param Date : Date for which to update table entry. null if want to use current date.
	 */
	public void insertOrUpdate(String tableName ,  String []col ,  String []val , String Date){

		SQLiteDatabase db = this.getReadableDatabase();
		if(Date == null)
			Date = Utilities.getCurrentDateAsSqliteString();
		Cursor cursor =db.query(tableName, new String[] {TableDailyCheckIns.COL_DATE}, TableDailyCheckIns.COL_DATE + "=?",new String []{Date}, null, null, null);
		if(cursor != null && cursor.getCount() >0){

			update(tableName, col, val, TableDailyCheckIns.COL_DATE + "=?", new String [] {Date});
		}
		else{
			
			insert(tableName, col, val);		
		}
		db.close();
	}

	
	public int deleteRows(String tableName , String whereClause, String []whereArgs ){
		
		SQLiteDatabase db= this.getWritableDatabase();
		int rowsAffected = db.delete(tableName, whereClause, whereArgs);
		db.close();
		
		return rowsAffected;
		
	}
	
	/**
	 * gets the DailyCheckIns object for current date
	 * @return
	 */
	public DailyCheckIns getTodaysDailyCheckIns(){
		
		SQLiteDatabase db  = this.getReadableDatabase(); 
		Cursor cursor = db.query(TABLE_DAILY_CHECKINS, null, TableDailyCheckIns.COL_DATE +"=?", new String[]{Utilities.getCurrentDateAsSqliteString()}, null, null, null);
		DailyCheckIns obj[] =Utilities.convertToDailyCheckInsObjects(cursor);
		db.close();
		
		return obj != null ? obj[0] : null;
		
	
	}
	
	/**
	 * gets the AutoCollectedData object for current date
	 * @return
	 */
	public AutoCollectedData getTodaysAutoCollectedData(){
		
		SQLiteDatabase db  = this.getReadableDatabase(); 
		Cursor cursor = db.query(TABLE_AUTO_COLLECTED_DATA, null, TableAutoCollectedData.COL_DATE +"=?", new String[]{Utilities.getCurrentDateAsSqliteString()}, null, null, null);
		AutoCollectedData obj[]= Utilities.convertToAutoCollectedDataObjects(cursor);
		db.close();
		
		return obj !=null ? obj[0] : null;
	}
	
	/**
	 * gets the DailyCheckIn objects for the specified date range
	 * @param minDate  lower range of date to search for in table 
	 * @param maxDate  higher range of date to search for in table
	 * @return
	 */
	public DailyCheckIns[] getDailyCheckInsBasedOnDateRanges(String minDate ,String maxDate ){
		
		SQLiteDatabase db  = this.getReadableDatabase(); 
		Cursor cursor = db.query(TABLE_DAILY_CHECKINS, null, TableDailyCheckIns.COL_DATE +">=? AND " + TableDailyCheckIns.COL_DATE + "<=?", new String[]{minDate ,maxDate}, null, null, null);
		DailyCheckIns obj[]= Utilities.convertToDailyCheckInsObjects(cursor);
		db.close();
		
		return obj;
	}
	
	
	/**
	 * gets the AutoCollectedData objects for the specified date range
	 * @param minDate  lower range of date to search for in table 
	 * @param maxDate  higher range of date to search for in table
	 * @return
	 */
	public AutoCollectedData[] getAutoCollectedDataBasedOnDateRanges(String minDate ,String maxDate ){
		
		SQLiteDatabase db  = this.getReadableDatabase(); 
		Cursor cursor = db.query(TABLE_AUTO_COLLECTED_DATA, null, TableAutoCollectedData.COL_DATE +">=? AND " + TableAutoCollectedData.COL_DATE + "<=?", new String[]{minDate ,maxDate}, null, null, null);
		AutoCollectedData obj[]= Utilities.convertToAutoCollectedDataObjects(cursor);
		db.close();
		
		return obj;
	}
}
