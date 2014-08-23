package com.stepin2it.stepin2it.controllers;

import static android.widget.Toast.LENGTH_SHORT;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.stepin2it.stepin2it.androidlibrary.ConstsIgnore;
import com.stepin2it.stepin2it.androidlibrary.ObjectsReader;
import com.stepin2it.stepin2it.androidlibrary.Photo;
import com.stepin2it.stepin2it.androidlibrary.PhotoResponse;
import com.stepin2it.stepin2it.androidlibrary.Photos;
import com.stepin2it.stepin2it.androidlibrary.utils.ImageCacheLoader;
import com.stepin2it.stepin2it.R;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import com.stepin2it.stepin2it.adapters.ViewPagerAdapter;
import com.stepin2it.stepin2it.adapters.feeds.FeedsBaseAdapter;
import com.stepin2it.stepin2it.controllers.achievements.AchievementsFragmentAdapter;
import com.stepin2it.stepin2it.controllers.one.OneFragmentAdapter;
import com.stepin2it.stepin2it.controllers.two.TwoFragmentAdapter;
import com.stepin2it.stepin2it.controllers.two.TestFragment;
import com.stepin2it.stepin2it.controllers.two.TestFragmentAdapter;
import com.stepin2it.stepin2it.customviews.stickylistheaders.StickyListHeadersListView;
import com.stepin2it.stepin2it.customviews.stickylistheaders.StickyListHeadersListView.OnHeaderClickListener;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TitlePageIndicator;
import com.viewpagerindicator.TitlePageIndicator.IndicatorStyle;

public class BackportNavigationDrawerFragment extends SherlockFragment
		implements AdapterView.OnItemClickListener, OnHeaderClickListener
{
	private static final String TAG = "BackportNavigationDrawerFragment";
	private DrawerLayout mDrawerLayout;
	private ListView listView;
	private TextView mContent;
	private FeedsBaseAdapter mFeedsAdapter;
	private LinearLayout mFeedsContainer;
	private StickyListHeadersListView mStickyList;
	private ListView mListView;
	private ActionBarHelper mActionBarHelper;

	private SherlockActionBarDrawerToggle mDrawerToggle;

	private static final Random RANDOM = new Random();

	// these are for tabspager
	LinearLayout mTabsPager;
	OneFragmentAdapter mOneAdapter;
	TwoFragmentAdapter mAdapter;

	AchievementsFragmentAdapter mAchievementsAdapter;
	ViewPager mPager;
	PageIndicator mIndicator;
	TitlePageIndicator mTitlePageIndicator;
	private List<Photo> mPhotos = new ArrayList<Photo>();
	private ProgressDialog mProgressBar;
	private PhotoResponse mPhotoResponse;
	private String mCategoryParam;
	private ImageCacheLoader mImageCacheLoader;
	private Context mContext;
	public static Fragment newInstance()
	{
		Fragment f = new BackportNavigationDrawerFragment();
		return f;
	}
	public class DataLoadingTask extends AsyncTask<Integer, Integer, Long> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

		}

		@Override
		protected Long doInBackground(Integer... params) {
			// TODO Auto-generated method stub
			
			String jsonFileUrl = ConstsIgnore.API_URL 
					+ "&feature=" + mCategoryParam 
					+ "&consumer_key="
					+ ConstsIgnore.CONSUMER_KEY;
			mPhotoResponse = ObjectsReader.readPhotoResponse(jsonFileUrl);
			if (mPhotoResponse != null) {
				mPhotos = mPhotoResponse.getPhotos();
			} else {
				Log.e(TAG, "PhotoRespone object was null");
			}

			
			return null;
		}

		protected void onProgressUpdate(Integer... progress) {

		}

		protected void onPostExecute(Long result) {
			display();

		}
	}
	protected void display() {
		
		Log.d(TAG, "display was called");
		return;
	}
	public class MyCustomAdapter extends ArrayAdapter<Photo> {
		public MyCustomAdapter(Context context, int textViewResourceId,
				List<Photo> photolist) {
			super(context, textViewResourceId, photolist);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			final int rownumber = position;
			View row = convertView;

			if (row == null) {
				LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
					      (Context.LAYOUT_INFLATER_SERVICE);
				row = inflater.inflate(R.layout.row_item, parent, false);
			}

			TextView title = (TextView) row.findViewById(R.id.title);

			TextView description = (TextView) row
					.findViewById(R.id.description);

			title.setText(mPhotos.get(position).getName());

			description.setText(mPhotos.get(position)
					.getDescription());

			int i = 0;

			ImageView imageView1 = (ImageView) row
					.findViewById(R.id.imageView1);
			mImageCacheLoader.DisplayImage(mPhotos.get(position)
					.getImage_url(), imageView1);
			// imageView1.setImageResource(R.drawable.ic_launcher);

			return row;

		}
	}
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		Log.d(this.getClass().getSimpleName(), "BackportNavigationDrawerFragment : onCreate");
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		setHasOptionsMenu(true);
		mContext = this.getActivity().getBaseContext();
		// mImageCacheLoader = new ImageCacheLoader(mContext);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		Log.d(this.getClass().getSimpleName(), "BackportNavigationDrawerFragment : onCreateView");
		View view = inflater.inflate(
				R.layout.fragment_backportnavigationdrawer_layout, container,
				false);
		
		
		mDrawerLayout = (DrawerLayout) view.findViewById(R.id.drawer_layout);
		listView = (ListView) view.findViewById(R.id.left_drawer);
		mContent = (TextView) view.findViewById(R.id.content_text);
		mFeedsContainer = (LinearLayout) view.findViewById(R.id.feedsContainer);
		// mFeedsContainer.setVisibility(View.GONE);
		mListView = (ListView) view.findViewById(R.id.list);
		/*
		mStickyList.setOnItemClickListener(this);
		mStickyList.setOnHeaderClickListener(this);

		mStickyList.addHeaderView(inflater.inflate(
				R.layout.feedscontainer_list_header_one, null));
		mStickyList.addFooterView(inflater.inflate(
				R.layout.feedscontainer_list_footer_one, null));
		mFeedsAdapter = new FeedsBaseAdapter(this.getActivity());
		mStickyList.setEmptyView(view.findViewById(R.id.empty));

		mStickyList.setAdapter(mFeedsAdapter);
		*/
		mDrawerLayout.setDrawerListener(new DemoDrawerListener());
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		listView.setAdapter(new ArrayAdapter<String>(this.getActivity(),
				android.R.layout.simple_list_item_1, DebugData.TITLES));
		listView.setOnItemClickListener(new DrawerItemClickListener());
		listView.setCacheColorHint(0);
		listView.setScrollingCacheEnabled(false);
		listView.setScrollContainer(false);
		listView.setFastScrollEnabled(true);
		listView.setSmoothScrollbarEnabled(true);

		mActionBarHelper = createActionBarHelper();
		mActionBarHelper.init();

		// ActionBarDrawerToggle provides convenient helpers for tying together
		// the
		// prescribed interactions between a top-level sliding drawer and the
		// action bar.
		mDrawerToggle = new SherlockActionBarDrawerToggle(this.getActivity(),
				mDrawerLayout, R.drawable.ic_drawer_light,
				R.string.drawer_open, R.string.drawer_close);
		mDrawerToggle.syncState();

		mTabsPager = (LinearLayout) view.findViewById(R.id.tabspager);
		mPager = (ViewPager) view.findViewById(R.id.pager);
		mTitlePageIndicator = (TitlePageIndicator) view
				.findViewById(R.id.indicator);
		
		
		mTabsPager.setVisibility(View.VISIBLE);
		mContent.setVisibility(View.GONE);
		// mFeedsContainer.setVisibility(View.GONE);
		mOneAdapter = new OneFragmentAdapter(
				BackportNavigationDrawerFragment.this
						.getSherlockActivity()
						.getSupportFragmentManager());

		mPager.setAdapter(mOneAdapter);

		mTitlePageIndicator.setViewPager(mPager);

		final float density = getResources().getDisplayMetrics().density;
		mTitlePageIndicator.setBackgroundColor(0xFF33B5E5);
		mTitlePageIndicator.setFooterColor(0xFF474F4E);
		mTitlePageIndicator.setFooterLineHeight(1 * density); // 1dp
		mTitlePageIndicator.setFooterIndicatorHeight(3 * density); // 3dp
		mTitlePageIndicator
				.setFooterIndicatorStyle(IndicatorStyle.None);
		mTitlePageIndicator.setTextColor(0xAA000000);
		mTitlePageIndicator.setSelectedColor(0xFF000000);
		mTitlePageIndicator.setSelectedBold(true);

		
		return view;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
	{
		inflater = ((SherlockFragmentActivity) getActivity())
				.getSupportMenuInflater();
		inflater.inflate(R.menu.main, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		/*
		 * The action bar home/up action should open or close the drawer.
		 * mDrawerToggle will take care of this.
		 */
		if (mDrawerToggle.onOptionsItemSelected(item))
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	/**
	 * This list item click listener implements very simple view switching by
	 * changing the primary content text. The drawer is closed when a selection
	 * is made.
	 */
	private class DrawerItemClickListener implements
			ListView.OnItemClickListener
	{
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id)
		{
			mContent.setText(DebugData.DEBUGDATA[position]);

			switch (position)
			{
			case 0:
			{
				Log.d(TAG, "Position 0 was selected");
				/*
				mTabsPager.setVisibility(View.GONE);
				mContent.setVisibility(View.GONE);
				mFeedsContainer.setVisibility(View.VISIBLE);
				*/
				mTabsPager.setVisibility(View.VISIBLE);
				mContent.setVisibility(View.GONE);
				mFeedsContainer.setVisibility(View.GONE);
				mOneAdapter = new OneFragmentAdapter(
						BackportNavigationDrawerFragment.this
								.getSherlockActivity()
								.getSupportFragmentManager());

				mPager.setAdapter(mOneAdapter);

				mTitlePageIndicator.setViewPager(mPager);

				final float density = getResources().getDisplayMetrics().density;
				mTitlePageIndicator.setBackgroundColor(0xFF33B5E5);
				mTitlePageIndicator.setFooterColor(0xFF474F4E);
				mTitlePageIndicator.setFooterLineHeight(1 * density); // 1dp
				mTitlePageIndicator.setFooterIndicatorHeight(3 * density); // 3dp
				mTitlePageIndicator
						.setFooterIndicatorStyle(IndicatorStyle.None);
				mTitlePageIndicator.setTextColor(0xAA000000);
				mTitlePageIndicator.setSelectedColor(0xFF000000);
				mTitlePageIndicator.setSelectedBold(true);
			}

				break;

			case 1:
			{
				Log.d(TAG, "Position 1 was selected");
				mTabsPager.setVisibility(View.VISIBLE);
				mContent.setVisibility(View.GONE);
				// mFeedsContainer.setVisibility(View.GONE);

				// this is for tabspager

				mAdapter = new TwoFragmentAdapter(
						BackportNavigationDrawerFragment.this
								.getSherlockActivity()
								.getSupportFragmentManager());

				mPager.setAdapter(mAdapter);

				mTitlePageIndicator.setViewPager(mPager);

				final float density = getResources().getDisplayMetrics().density;
				mTitlePageIndicator.setBackgroundColor(0xFF33B5E5);
				mTitlePageIndicator.setFooterColor(0xFF474F4E);
				mTitlePageIndicator.setFooterLineHeight(1 * density); // 1dp
				mTitlePageIndicator.setFooterIndicatorHeight(3 * density); // 3dp
				// mTitlePageIndicator
				// .setFooterIndicatorStyle(IndicatorStyle.Underline);

				mTitlePageIndicator
						.setFooterIndicatorStyle(IndicatorStyle.None);
				mTitlePageIndicator.setTextColor(0xAA000000);
				mTitlePageIndicator.setSelectedColor(0xFF000000);
				mTitlePageIndicator.setSelectedBold(true);
			}

				break;

			case 2:
			{
				Log.d(TAG, "Position 2 was selected");
				mTabsPager.setVisibility(View.VISIBLE);
				mContent.setVisibility(View.GONE);
				// mFeedsContainer.setVisibility(View.GONE);
				mAchievementsAdapter = new AchievementsFragmentAdapter(
						BackportNavigationDrawerFragment.this
								.getSherlockActivity()
								.getSupportFragmentManager());

				mPager.setAdapter(mAchievementsAdapter);

				mTitlePageIndicator.setViewPager(mPager);

				final float density = getResources().getDisplayMetrics().density;
				mTitlePageIndicator.setBackgroundColor(0xFF33B5E5);
				mTitlePageIndicator.setFooterColor(0xFF474F4E);
				mTitlePageIndicator.setFooterLineHeight(1 * density); // 1dp
				mTitlePageIndicator.setFooterIndicatorHeight(3 * density); // 3dp
				/*
				 * mTitlePageIndicator
				 * .setFooterIndicatorStyle(IndicatorStyle.Underline);
				 */
				mTitlePageIndicator
						.setFooterIndicatorStyle(IndicatorStyle.None);
				mTitlePageIndicator.setTextColor(0xAA000000);
				mTitlePageIndicator.setSelectedColor(0xFF000000);
				mTitlePageIndicator.setSelectedBold(true);
			}
				break;
			case 3:
			{
				Log.d(TAG, "Position 3 was selected");
				mContent.setVisibility(View.VISIBLE);
				mTabsPager.setVisibility(View.GONE);
				mFeedsContainer.setVisibility(View.VISIBLE);
				new DataLoadingTask().execute();
				
				MyCustomAdapter adapter = new MyCustomAdapter(mContext, R.layout.row_item,
						mPhotos);
				mListView.setAdapter(adapter);
			}
				break;
			case 4:
			{
				mContent.setVisibility(View.VISIBLE);
				mTabsPager.setVisibility(View.GONE);
				mFeedsContainer.setVisibility(View.GONE);
			}
				break;
			case 5:
			{
				mContent.setVisibility(View.VISIBLE);
				mTabsPager.setVisibility(View.GONE);
				mFeedsContainer.setVisibility(View.GONE);
			}
				break;
			case 6:
			{
				mContent.setVisibility(View.VISIBLE);
				mTabsPager.setVisibility(View.GONE);
				mFeedsContainer.setVisibility(View.GONE);
			}
				break;
			default:
				mTabsPager.setVisibility(View.GONE);
				mTabsPager.setVisibility(View.GONE);
				mContent.setVisibility(View.VISIBLE);
				break;
			}

			mActionBarHelper.setTitle(DebugData.TITLES[position]);
			mDrawerLayout.closeDrawer(listView);
		}
	}

	/**
	 * A drawer listener can be used to respond to drawer events such as
	 * becoming fully opened or closed. You should always prefer to perform
	 * expensive operations such as drastic relayout when no animation is
	 * currently in progress, either before or after the drawer animates.
	 * 
	 * When using ActionBarDrawerToggle, all DrawerLayout listener methods
	 * should be forwarded if the ActionBarDrawerToggle is not used as the
	 * DrawerLayout listener directly.
	 */
	private class DemoDrawerListener implements DrawerLayout.DrawerListener
	{
		@Override
		public void onDrawerOpened(View drawerView)
		{
			mDrawerToggle.onDrawerOpened(drawerView);
			mActionBarHelper.onDrawerOpened();
		}

		@Override
		public void onDrawerClosed(View drawerView)
		{
			mDrawerToggle.onDrawerClosed(drawerView);
			mActionBarHelper.onDrawerClosed();
		}

		@Override
		public void onDrawerSlide(View drawerView, float slideOffset)
		{
			mDrawerToggle.onDrawerSlide(drawerView, slideOffset);
		}

		@Override
		public void onDrawerStateChanged(int newState)
		{
			mDrawerToggle.onDrawerStateChanged(newState);
		}
	}

	/**
	 * Create a compatible helper that will manipulate the action bar if
	 * available.
	 */
	private ActionBarHelper createActionBarHelper()
	{
		return new ActionBarHelper();
	}

	private class ActionBarHelper
	{
		private final ActionBar mActionBar;
		private CharSequence mDrawerTitle;
		private CharSequence mTitle;

		private ActionBarHelper()
		{
			mActionBar = ((SherlockFragmentActivity) getActivity())
					.getSupportActionBar();
		}

		public void init()
		{
			mActionBar.setDisplayHomeAsUpEnabled(true);
			mActionBar.setHomeButtonEnabled(true);
			mTitle = mDrawerTitle = getActivity().getTitle();
		}

		/**
		 * When the drawer is closed we restore the action bar state reflecting
		 * the specific contents in view.
		 */
		public void onDrawerClosed()
		{
			mActionBar.setTitle(mTitle);
		}

		/**
		 * When the drawer is open we set the action bar to a generic title. The
		 * action bar should only contain data relevant at the top level of the
		 * nav hierarchy represented by the drawer, as the rest of your content
		 * will be dimmed down and non-interactive.
		 */
		public void onDrawerOpened()
		{
			mActionBar.setTitle(mDrawerTitle);
		}

		public void setTitle(CharSequence title)
		{
			mTitle = title;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id)
	{
		/*
		 * Toast.makeText(getActivity(), "Item " + position + " clicked!",
		 * LENGTH_SHORT).show();
		 */
	}

	@SuppressLint("NewApi")
	@Override
	public void onHeaderClick(StickyListHeadersListView l, View header,
			int itemPosition, long headerId, boolean currentlySticky)
	{
		/*
		 * Toast.makeText(getActivity(), "header " + headerId,
		 * Toast.LENGTH_SHORT) .show();
		 */
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
		{
			/*
			mStickyList.smoothScrollToPositionFromTop(
					mFeedsAdapter.getSectionStart(itemPosition)
							+ mStickyList.getHeaderViewsCount(),
					-mStickyList.getPaddingTop());
					*/
		}
	}

}
