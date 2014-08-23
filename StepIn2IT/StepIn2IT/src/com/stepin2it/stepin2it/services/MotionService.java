package com.stepin2it.stepin2it.services;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;


/** 
 * @author muhammad.bilal
 */

/** This service collects user motion data by reading accelerometer data */

public class MotionService extends Service implements SensorEventListener{


	private SensorManager sensorManager;
	private Sensor accelerometer;
	private static float[] gravity;
	private static float total =0.0f;
	private static final float threshold = 1.5f;

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub

		final float alpha = 0.7f;

		// Isolate the force of gravity with the low-pass filter.
		gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
		gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
		gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];
		// Remove the gravity contribution with the high-pass filter.
		float x= event.values[0] - gravity[0];
		float y = event.values[1] - gravity[1];
		float z = event.values[2] - gravity[2];

		float motion = (float) java.lang.Math.sqrt(x*x + y*y +z*z);
		Log.d("MOTIONTEST","Motion : " + motion);

		if(motion > threshold ){	
			total+=motion;

		}

	}

	@Override
	public IBinder onBind(Intent intent) {

		return null;
	}

	@Override
	public void onCreate() {

		super.onCreate();

		gravity = new float[3];
		gravity[0]=gravity[1]=gravity[2]=0.0f;
		sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
		accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sensorManager.registerListener(this, accelerometer,SensorManager.SENSOR_DELAY_NORMAL);

	}


	@Override
	public void onDestroy() {

		super.onDestroy();
		sensorManager.unregisterListener(this);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		return START_STICKY;
	}

}

