package com.stepin2it.stepin2it.controllers.achievements;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.stepin2it.stepin2it.R;
import com.stepin2it.stepin2it.controllers.two.TestFragment;
import com.viewpagerindicator.IconPagerAdapter;

public class AchievementsFragmentAdapter extends FragmentPagerAdapter implements
		IconPagerAdapter
{
	protected static final String[] ACHIEVEMENTSCONTENT = new String[] { "Engineering Fields", "Software Testing Training", "Project Management", "Business Analyst Training",
			"Enterprise Application Development", };
	protected static final int[] ICONS = new int[] {
			R.drawable.perm_group_calendar, R.drawable.perm_group_camera,
			R.drawable.perm_group_device_alarms, R.drawable.perm_group_location };

	private int mCount = ACHIEVEMENTSCONTENT.length;

	public AchievementsFragmentAdapter(FragmentManager fm)
	{
		super(fm);
	}

	@Override
	public Fragment getItem(int position)
	{
		return AchievementsFragment.newInstance(ACHIEVEMENTSCONTENT[position % ACHIEVEMENTSCONTENT.length]);
	}

	@Override
	public int getCount()
	{
		return mCount;
	}

	@Override
	public CharSequence getPageTitle(int position)
	{
		return AchievementsFragmentAdapter.ACHIEVEMENTSCONTENT[position % ACHIEVEMENTSCONTENT.length];
	}

	@Override
	public int getIconResId(int index)
	{
		return ICONS[index % ICONS.length];
	}

	public void setCount(int count)
	{
		if (count > 0 && count <= 10)
		{
			mCount = count;
			notifyDataSetChanged();
		}
	}
}