package com.stepin2it.stepin2it;

import com.stepin2it.stepin2it.R;
import com.stepin2it.stepin2it.application.components.WeatherManager;
import com.stepin2it.stepin2it.controllers.BackportNavigationDrawerActivity;
import com.stepin2it.stepin2it.controllers.HomeActivity;
import com.stepin2it.stepin2it.controllers.ProfileActivityStep1;
import com.stepin2it.stepin2it.controllers.checkinstep1.ArcLayoutActivity;
import com.stepin2it.stepin2it.controllers.checkinstep1.CheckinStep1Activity;
import com.stepin2it.stepin2it.controllers.checkinstep3.CheckinStep3Activity;
import com.stepin2it.stepin2it.controllers.checkinstep4.CheckinStep4Activity;
import com.stepin2it.stepin2it.controllers.checkinstep5.CheckinStep5Activity;
import com.stepin2it.stepin2it.controllers.checkinstep6.CheckinStep6Activity;
import com.stepin2it.stepin2it.controllers.two.SnapshotsActivity;
import com.stepin2it.stepin2it.draggableviews.DragActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity
{
	private static final String TAG = "MainActivity";

	private Button button1;

	private Button button2;
	
	private Button button3;
	
	private Button button4;
	
	private Button button5;
	
	private Button button6;
	
	private Button button7;
	
	private Button button8;
	
	private Button button9;
	
	private Button button10;
	
	private TextView labelWeather;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		labelWeather = (TextView) this.findViewById(R.id.labelWeather);
		
		button1 = (Button) this.findViewById(R.id.button1);

		button2 = (Button) this.findViewById(R.id.button2);
		
		button3 = (Button) this.findViewById(R.id.button3);
		
		button4 = (Button) this.findViewById(R.id.button4);
		
		button5 = (Button) this.findViewById(R.id.button5);
		
		button6 = (Button) this.findViewById(R.id.button6);
		
		button7 = (Button) this.findViewById(R.id.button7);
		
		button8 = (Button) this.findViewById(R.id.button8);
		
		button9 = (Button) this.findViewById(R.id.button9);
		
		button10 = (Button) this.findViewById(R.id.button10);

		WeatherManager wm = new WeatherManager(MainActivity.this);
		
		button1.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub

				Intent intent = new Intent(MainActivity.this,
						HomeActivity.class);

				startActivity(intent);
			}
		});
		button2.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub

				Intent intent = new Intent(MainActivity.this,
						DragActivity.class);

				startActivity(intent);
			}
		});

		button3.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub

				Intent intent = new Intent(MainActivity.this,
						CheckinStep1Activity.class);

				startActivity(intent);
			}
		});
		button4.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{

//				Intent intent = new Intent(MainActivity.this,
//						SnapshotsActivity.class);
				
				Intent intent = new Intent(MainActivity.this,
						CheckinStep1Activity.class);

				startActivity(intent);
			}
		});
		
		button5.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{

//				Intent intent = new Intent(MainActivity.this,
//						SnapshotsActivity.class);
				
				Intent intent = new Intent(MainActivity.this,
						ArcLayoutActivity.class);

				startActivity(intent);
			}
		});
		
		button6.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, CheckinStep5Activity.class);
				startActivity(intent);
				
			}
		});
		
		button7.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, CheckinStep3Activity.class);
				startActivity(intent);
				
			}
		});
		
		button8.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, ExpandableList1.class);
				startActivity(intent);
				
			}
		});
		
		button9.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, GraphDebug.class);
				startActivity(intent);
				
			}
		});
		
		button10.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(MainActivity.this, ProfileActivityStep1.class);
				startActivity(intent);
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);

		return true;
	}

}
