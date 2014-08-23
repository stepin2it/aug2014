package com.stepin2it.stepin2it;

import java.util.Timer;
import java.util.TimerTask;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.MenuInflater;
import com.stepin2it.stepin2it.R;
import com.stepin2it.stepin2it.controllers.HomeActivity;
import com.stepin2it.stepin2it.controllers.checkinstep1.CheckinStep1Activity;

public class TutorialActivity extends SherlockActivity
{

	private MenuItem mMenuDebug;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		this.getSupportActionBar().hide();

		TimerTask timerTask;
		Timer timer;

		timerTask = new TimerTask() {

		        @Override
		        public void run() {
		            startActivity(new Intent(TutorialActivity.this, CheckinStep1Activity.class));
		            finish();
		        }
		    };

		timer = new Timer();
		timer.schedule(timerTask, 2 * 1000); 
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		super.onCreateOptionsMenu(menu);
		getSupportMenuInflater().inflate(R.menu.splash_menu, menu);
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// If this callback does not handle the item click,
		// onPerformDefaultAction
		// of the ActionProvider is invoked. Hence, the provider encapsulates
		// the
		// complete functionality of the menu item.
		
		Intent intent = new Intent(TutorialActivity.this, MainActivity.class);
		startActivity(intent);
		
		return false;
	}

}
