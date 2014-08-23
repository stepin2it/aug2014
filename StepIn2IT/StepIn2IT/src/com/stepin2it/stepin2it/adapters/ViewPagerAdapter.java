package com.stepin2it.stepin2it.adapters;

import com.stepin2it.stepin2it.fragments.FragmentTab1;
import com.stepin2it.stepin2it.fragments.FragmentTab2;
import com.stepin2it.stepin2it.fragments.FragmentTab3;
import com.stepin2it.stepin2it.fragments.FragmentTab4;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter
{

	// Declare the number of ViewPager pages
	final int PAGE_COUNT = 4;

	public ViewPagerAdapter(FragmentManager fm)
	{
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0)
	{
		switch (arg0)
		{

		// Open FragmentTab1.java
		case 0:
			FragmentTab1 fragmenttab1 = new FragmentTab1();
			return fragmenttab1;

			// Open FragmentTab2.java
		case 1:
			FragmentTab2 fragmenttab2 = new FragmentTab2();
			return fragmenttab2;

			// Open FragmentTab3.java
		case 2:
			FragmentTab3 fragmenttab3 = new FragmentTab3();
			return fragmenttab3;

			// Open FragmentTab3.java
		case 3:
			FragmentTab4 fragmenttab4 = new FragmentTab4();
			return fragmenttab4;
		}
		return null;
	}

	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return PAGE_COUNT;
	}

}
