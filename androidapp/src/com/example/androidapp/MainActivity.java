package com.example.androidapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.androidapp.todos.contentprovider.TodosOverviewActivity;
import com.example.androidapp.utils.ImageCacheLoader;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	private Button mButton;
	private TextView mTextView;
	private PhotoResponse mPhotoResponse;
	private Context mContext;
	private ListView mListView;
	private ListView mLeftDrawerListView;
	private static final String TAG = MainActivity.class.getSimpleName();
	private ImageCacheLoader mImageCacheLoader;

	private ProgressDialog mProgressBar;

	private DrawerLayout mDrawerLayout;

	private Photos mPhotos;

	private String[] mCategories = new String[] { "popular", "highest_rated",
			"upcoming", "editors", "fresh_today", "fresh_yesterday", "fresh_week" };

	private ActionBarDrawerToggle mDrawerToggle;

	private boolean mIsDrawerOpen = false;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	
	private String mCategoryParam;
	

	public class CategoryAdapter extends ArrayAdapter<String> {
		public CategoryAdapter(Context context, int textViewResourceId,
				String[] categorylist) {
			super(context, textViewResourceId, categorylist);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub

			final int rownumber = position;
			View row = convertView;

			if (row == null) {
				LayoutInflater inflater = getLayoutInflater();
				row = inflater
						.inflate(R.layout.drawer_list_item, parent, false);
			}
			/*
			row.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					Log.d(TAG, "-------------------" + rownumber);

					Intent intent = new Intent(MainActivity.this,
							PhotoViewActivity.class);
					intent.putExtra("POSITION", rownumber);
					intent.putExtra("PHOTO_ID",
							mPhotos.getPhotos().get(rownumber).getId());
					intent.putExtra("PHOTOS", mPhotos);
					int requestCode = 0;
					startActivityForResult(intent, requestCode);
					// startActivity(intent);
				}

			});
			*/

			TextView category = (TextView) row.findViewById(R.id.text1);

			category.setText(mCategories[position]);

			return row;

		}
	}

	public class MyCustomAdapter extends ArrayAdapter<Photo> {
		public MyCustomAdapter(Context context, int textViewResourceId,
				List<Photo> photolist) {
			super(context, textViewResourceId, photolist);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub

			final int rownumber = position;
			View row = convertView;

			if (row == null) {
				LayoutInflater inflater = getLayoutInflater();
				row = inflater.inflate(R.layout.row_item, parent, false);
			}
			/*
			row.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					Log.d(TAG, "-------------------" + rownumber);

					Intent intent = new Intent(MainActivity.this,
							PhotoViewActivity.class);
					intent.putExtra("POSITION", rownumber);
					intent.putExtra("PHOTO_ID",
							mPhotos.getPhotos().get(rownumber).getId());
					intent.putExtra("PHOTOS", mPhotos);
					int requestCode = 0;
					startActivityForResult(intent, requestCode);
					// startActivity(intent);
				}

			});
			*/

			TextView title = (TextView) row.findViewById(R.id.title);

			TextView description = (TextView) row
					.findViewById(R.id.description);

			title.setText(mPhotos.getPhotos().get(position).getName());

			description.setText(mPhotos.getPhotos().get(position)
					.getDescription());

			int i = 0;

			ImageView imageView1 = (ImageView) row
					.findViewById(R.id.imageView1);
			mImageCacheLoader.DisplayImage(mPhotos.getPhotos().get(position)
					.getImage_url(), imageView1);
			// imageView1.setImageResource(R.drawable.ic_launcher);

			return row;

		}
	}

	public class DataLoadingTask extends AsyncTask<Integer, Integer, Long> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			mProgressBar = new ProgressDialog(MainActivity.this);
			mProgressBar.setTitle("Loading images");
			mProgressBar.show();

		}

		@Override
		protected Long doInBackground(Integer... params) {
			// TODO Auto-generated method stub
			String jsonFileUrl = ConstsIgnore.API_URL 
					+ "&feature=" + mCategoryParam 
					+ "&consumer_key="
					+ ConstsIgnore.CONSUMER_KEY;
			mPhotoResponse = ObjectsReader.readPhotoResponse(jsonFileUrl);
			mPhotos = new Photos(mPhotoResponse.getPhotos());
			mPhotos.setPhotos(mPhotoResponse.getPhotos());

			return null;
		}

		protected void onProgressUpdate(Integer... progress) {

		}

		protected void onPostExecute(Long result) {
			display();
			if (mProgressBar != null) {
				mProgressBar.dismiss();
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate was called");
		setContentView(R.layout.activity_drawer);
		mCategoryParam = "fresh_today";
		
		mTitle = mDrawerTitle = getTitle();
		mImageCacheLoader = new ImageCacheLoader(this);
		new DataLoadingTask().execute();
		mListView = (ListView) findViewById(R.id.listView1);
		
		mLeftDrawerListView = (ListView) findViewById(R.id.left_drawer);
		
		
		
		
		
		CategoryAdapter ca = new CategoryAdapter(this,
				R.layout.drawer_list_item, mCategories);
		mLeftDrawerListView.setAdapter(ca);
		// set up the drawer's list view with items and click listener
		mLeftDrawerListView.setOnItemClickListener(new DrawerItemClickListener());
		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		// set a custom shadow that overlays the main content when the drawer
		// opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		// enable ActionBar app icon to behave as action to toggle nav drawer
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		// ActionBarDrawerToggle ties together the the proper interactions
		// between the sliding drawer and the action bar app icon
		mDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
		mDrawerLayout, /* DrawerLayout object */
		R.drawable.ic_drawer, /* nav drawer image to replace 'Up' caret */
		R.string.drawer_open, /* "open drawer" description for accessibility */
		R.string.drawer_close /* "close drawer" description for accessibility */
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				Log.d(TAG, "onDrawerOpened was called");
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			// selectItem(0);
		}
		Log.w(TAG, "This is to illustrate warnings");

	}

	private void display() {
		// ListAdapter adapter =
		// createPhotosListAdapter(mPhotoResponse.getPhotos());
		// mListView.setAdapter(adapter);
   	 // Create a new fragment and specify the planet to show based on position
        // Insert the fragment by replacing any existing fragment
		
		MyCustomAdapter adapter = new MyCustomAdapter(this, R.layout.row_item,
				mPhotos.getPhotos());
		mListView.setAdapter(adapter);
		
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(MainActivity.this,
						PhotoViewActivity.class);
				intent.putExtra("POSITION", position);
				intent.putExtra("PHOTO_ID",
						mPhotos.getPhotos().get(position).getId());
				intent.putExtra("PHOTOS", mPhotos);
				int requestCode = 0;
				startActivityForResult(intent, requestCode);
				
			}
		});

	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		Intent intent = null;
		if (id == R.id.action_settings) {
			intent = new Intent(MainActivity.this, XmlParsingActivity.class);
			startActivity(intent);
			return true;
		} else if (id == R.id.action_database) {
			intent = new Intent(MainActivity.this, DatabaseActivity.class);
			startActivity(intent);
			return true;
		} else if (id ==R.id.action_todo) {
			intent = new Intent(MainActivity.this, TodosOverviewActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private ListAdapter createPhotosListAdapter(List<Photo> photos) {
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		for (Photo photo : photos) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("imageThumbnail", R.drawable.ic_launcher);
			map.put("photoTitle", photo.name);
			map.put("photoDescription", photo.description);
			data.add(map);
		}

		SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, data,
				R.layout.row_item, new String[] { "imageThumbnail",
						"photoTitle", "photoDescription" }, new int[] {
						R.id.imageView1, R.id.title, R.id.description });

		return adapter;
	}
	/*
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		Log.d(TAG, "onKeyDown was called");
		if (event.getAction() == KeyEvent.ACTION_DOWN) {
			if (keyCode == KeyEvent.KEYCODE_BACK) {
				if (!mIsDrawerOpen) {
					mDrawerLayout.openDrawer(Gravity.START);
					mIsDrawerOpen = true;
				} else {
					mDrawerLayout.closeDrawer(Gravity.START);
					mIsDrawerOpen = false;
				}
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	*/
	
    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }
    private void selectItem(int position) {

    	 // Create a new fragment and specify the planet to show based on position
        MyListFragment fragment = new MyListFragment(); // this fragment contains the list with all the "test" items

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                       .replace(R.id.content_frame, fragment)
                       .commit();
        
        mCategoryParam = mCategories[position];
        new DataLoadingTask().execute();
        
        // update selected item and title, then close the drawer
        mLeftDrawerListView.setItemChecked(position, true);
        setTitle(mCategories[position]);
        mDrawerLayout.closeDrawer(mLeftDrawerListView);
    }
    
	public void onBackPressed () {
		if (!mIsDrawerOpen) {
			mDrawerLayout.openDrawer(Gravity.START);
			mIsDrawerOpen = true;
		} else {
			mDrawerLayout.closeDrawers();
			mIsDrawerOpen = false;
		}
	}
}
