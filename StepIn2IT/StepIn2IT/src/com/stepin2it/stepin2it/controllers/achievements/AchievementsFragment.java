package com.stepin2it.stepin2it.controllers.achievements;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public final class AchievementsFragment extends Fragment
{
	private static final String ACHIEVEMENTS_KEY_CONTENT = "AchievementsFragment:Content";

	public static AchievementsFragment newInstance(String content)
	{
		AchievementsFragment fragment = new AchievementsFragment();

		StringBuilder builder = new StringBuilder();

		builder.append(content).append("Software Testing, Engineering Programming Languages, Project Management");
		builder.deleteCharAt(builder.length() - 1);
		fragment.mContent = builder.toString();

		return fragment;
	}

	private String mContent = "???";

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		if ((savedInstanceState != null)
				&& savedInstanceState.containsKey(ACHIEVEMENTS_KEY_CONTENT))
		{
			mContent = savedInstanceState.getString(ACHIEVEMENTS_KEY_CONTENT);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		TextView text = new TextView(getActivity());
		text.setGravity(Gravity.CENTER);
		// text.setText(mContent);
		text.setText("Courses : Engineering Fields : Tab1");
		text.setTextSize(20 * getResources().getDisplayMetrics().density);
		text.setPadding(20, 20, 20, 20);

		LinearLayout layout = new LinearLayout(getActivity());
		layout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT));
		layout.setGravity(Gravity.CENTER);
		layout.addView(text);

		return layout;
	}

	@Override
	public void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);
		outState.putString(ACHIEVEMENTS_KEY_CONTENT, mContent);
	}
}
