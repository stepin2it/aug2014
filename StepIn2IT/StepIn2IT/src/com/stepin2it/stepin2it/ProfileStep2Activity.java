package com.stepin2it.stepin2it;

import java.util.Timer;
import java.util.TimerTask;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.MenuInflater;
import com.stepin2it.stepin2it.R;
import com.stepin2it.stepin2it.controllers.HomeActivity;
import com.stepin2it.stepin2it.controllers.checkinstep1.CheckinStep1Activity;

public class ProfileStep2Activity extends SherlockActivity
{

	private MenuItem mMenuDebug;

	private ImageView imageView1;
	
	private Button buttonContinue;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_step2);
		this.getSupportActionBar().hide();

		buttonContinue = (Button) this.findViewById(R.id.buttonContinue);

		buttonContinue.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent(ProfileStep2Activity.this, ProfileStep3Activity.class);
				startActivity(intent);
			}
		});

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		super.onCreateOptionsMenu(menu);
		if (FeaturesConfiguration.isDebug)
		{
			getSupportMenuInflater().inflate(R.menu.splash_menu, menu);
		}
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

		Intent intent = new Intent(ProfileStep2Activity.this,
				MainActivity.class);
		startActivity(intent);

		return false;
	}

}
