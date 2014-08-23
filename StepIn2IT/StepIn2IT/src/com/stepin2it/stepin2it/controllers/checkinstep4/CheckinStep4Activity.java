package com.stepin2it.stepin2it.controllers.checkinstep4;

import com.actionbarsherlock.app.SherlockActivity;
import com.stepin2it.stepin2it.R;
import com.stepin2it.stepin2it.controllers.HomeActivity;
import com.stepin2it.stepin2it.controllers.checkinstep3.CheckinStep3Activity;
import com.stepin2it.stepin2it.controllers.checkinstep5.CheckinStep5Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CheckinStep4Activity extends SherlockActivity implements
		WheelModel.Listener
{
	private Button buttonContinue;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		this.getSupportActionBar().hide();
		setContentView(R.layout.activity_checkin_step4);

		//ClickWheel wheel = (ClickWheel) findViewById(R.id.wheel);
		// wheel.getModel().addListener(this);
		buttonContinue = (Button) this.findViewById(R.id.buttonContinue);

		buttonContinue.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// Intent intent = new Intent(CheckinStep2Activity.this,
				// HomeActivity.class);
				Intent intent = new Intent(CheckinStep4Activity.this,
						CheckinStep5Activity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public void onDialPositionChanged(WheelModel sender, int nicksChanged)
	{
		TextView text = (TextView) findViewById(R.id.text);
		text.setText(sender.getCurrentNick() + "");
	}
}