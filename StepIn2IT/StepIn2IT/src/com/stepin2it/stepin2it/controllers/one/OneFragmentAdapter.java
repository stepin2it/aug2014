package com.stepin2it.stepin2it.controllers.one;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.stepin2it.stepin2it.R;
import com.viewpagerindicator.IconPagerAdapter;

public class OneFragmentAdapter extends FragmentPagerAdapter implements
		IconPagerAdapter
{
	protected static final String[] SNAPSHOTSCONTENT = new String[] { "Engineering", "Management",
			"Testing", "Business Analysts", };
	protected static final int[] ICONS = new int[] {
			R.drawable.perm_group_calendar, R.drawable.perm_group_camera,
			R.drawable.perm_group_device_alarms, R.drawable.perm_group_location };

	private int mCount = SNAPSHOTSCONTENT.length;

	public OneFragmentAdapter(FragmentManager fm)
	{
		super(fm);
	}

	@Override
	public Fragment getItem(int position)
	{
		return OneFragment.newInstance(SNAPSHOTSCONTENT[position % SNAPSHOTSCONTENT.length]);
	}

	@Override
	public int getCount()
	{
		return mCount;
	}

	@Override
	public CharSequence getPageTitle(int position)
	{
		return OneFragmentAdapter.SNAPSHOTSCONTENT[position % SNAPSHOTSCONTENT.length];
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