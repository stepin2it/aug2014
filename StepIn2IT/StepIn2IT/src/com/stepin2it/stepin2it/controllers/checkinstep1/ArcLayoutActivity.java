package com.stepin2it.stepin2it.controllers.checkinstep1;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.stepin2it.stepin2it.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class ArcLayoutActivity extends SherlockActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		// Get the view from activity_main.xml
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		this.getSupportActionBar().hide();
		setContentView(R.layout.activity_arclayout);
	}

}


