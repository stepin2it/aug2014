package com.stepin2it.stepin2it.controllers.checkinstep3;

import com.actionbarsherlock.app.SherlockActivity;
import com.stepin2it.stepin2it.R;
import com.stepin2it.stepin2it.controllers.checkinstep2.CheckinStep2Activity;
import com.stepin2it.stepin2it.controllers.checkinstep4.CheckinStep4Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CheckinStep3Activity extends SherlockActivity implements
		CustomSlider.CustomSliderPositionListener
{
	private Button buttonContinue;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		this.getSupportActionBar().hide();
		setContentView(R.layout.activity_checkin_step3);

		CustomSlider customSlider = (CustomSlider) this
				.findViewById(R.id.slider_vertical);

		customSlider.setPositionListener(this);

		buttonContinue = (Button) this.findViewById(R.id.buttonContinue);

		buttonContinue.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// Intent intent = new Intent(CheckinStep2Activity.this,
				// HomeActivity.class);
				Intent intent = new Intent(CheckinStep3Activity.this,
						CheckinStep4Activity.class);
				startActivity(intent);
			}
		});

	}

	@Override
	public void onPositionChange(float newPosition)
	{
		// TODO Auto-generated method stub
		TextView text = (TextView) findViewById(R.id.text);
		text.setText(String.valueOf(newPosition));
	}

}