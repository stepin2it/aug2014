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
import android.widget.EditText;
import android.widget.ImageView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.MenuInflater;
import com.stepin2it.stepin2it.R;
import com.stepin2it.stepin2it.controllers.HomeActivity;
import com.stepin2it.stepin2it.controllers.checkinstep1.CheckinStep1Activity;

public class ProfileStep1Activity extends SherlockActivity
{

	private MenuItem mMenuDebug;

	private ImageView imageView1;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_step1);
		this.getSupportActionBar().hide();
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		final EditText input = new EditText(this);
		builder.setView(input);
		builder.setMessage(R.string.label_profile_step1_dialog_message)
				.setTitle(R.string.label_profile_step1_dialog_title);

		builder.setPositiveButton(R.string.label_cancel,
				new DialogInterface.OnClickListener()
				{
					public void onClick(DialogInterface dialog, int id)
					{
						// User clicked OK button
						Intent intent = new Intent(ProfileStep1Activity.this,
								ProfileStep2Activity.class);
						
						startActivity(intent);
					}
				});
		builder.setNegativeButton(R.string.label_submit,
				new DialogInterface.OnClickListener()
				{
					public void onClick(DialogInterface dialog, int id)
					{
						// User cancelled the dialog
						Intent intent = new Intent(ProfileStep1Activity.this,
								ProfileStep2Activity.class);
						startActivity(intent);
					}
				});

		AlertDialog dialog = builder.create();

		dialog.show();
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

		Intent intent = new Intent(ProfileStep1Activity.this,
				MainActivity.class);
		startActivity(intent);

		return false;
	}

}
