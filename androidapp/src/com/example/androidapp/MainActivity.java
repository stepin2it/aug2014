package com.example.androidapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.androidapp.utils.ImageCacheLoader;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button mButton;
	private TextView mTextView;
	private PhotoResponse mPhotoResponse;
	private Context mContext;
	private ListView mListView;
	private static final String TAG = "MainActivity";
	private ImageCacheLoader mImageCacheLoader;
	
	private ProgressDialog mProgressBar;
	
	
	private Photos mPhotos;
	
	public class MyCustomAdapter extends ArrayAdapter<Photo>
	{
		public MyCustomAdapter(Context context, int textViewResourceId,	List<Photo> photolist)
		{
			super(context, textViewResourceId, photolist);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			// TODO Auto-generated method stub
			
			final int rownumber = position;
			View row = convertView;

			if (row == null)
			{
				LayoutInflater inflater = getLayoutInflater();
				row = inflater.inflate(R.layout.row_item, parent, false);
			}
			
			row.setOnClickListener(new View.OnClickListener()
			{
				
				@Override
				public void onClick(View v)
				{
					Log.d(TAG, "-------------------" + rownumber);
					
					 Intent intent = new Intent(MainActivity.this, PhotoViewActivity.class);
					 intent.putExtra("POSITION", rownumber);
					 intent.putExtra("PHOTO_ID", mPhotos.getPhotos().get(rownumber).getId());
					 intent.putExtra("PHOTOS", mPhotos);
					 int requestCode = 0;
					 startActivityForResult(intent, requestCode);
					 // startActivity(intent);
				}
				
			});

			TextView title = (TextView) row.findViewById(R.id.title);

			TextView description = (TextView) row
					.findViewById(R.id.description);

			title.setText(mPhotos.getPhotos().get(position).getName());

			description.setText(mPhotos.getPhotos().get(position).getDescription());
			
			int i = 0;

			ImageView imageView1 = (ImageView) row.findViewById(R.id.imageView1);
			mImageCacheLoader.DisplayImage(mPhotos.getPhotos().get(position).getImage_url(), imageView1);
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
			String jsonFileUrl = ConstsIgnore.API_URL + "&consumer_key=" + ConstsIgnore.CONSUMER_KEY;
			mPhotoResponse = ObjectsReader
					.readPhotoResponse(jsonFileUrl);
			mPhotos = new Photos(mPhotoResponse.getPhotos());
			mPhotos.setPhotos(mPhotoResponse.getPhotos()) ;
			
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
		setContentView(R.layout.activity_drawer);
		mImageCacheLoader = new ImageCacheLoader(this);
		new DataLoadingTask().execute();
		
		mListView = (ListView) findViewById(R.id.listView1);
		
		
		
		
	}
	private void display() {
		// ListAdapter adapter = createPhotosListAdapter(mPhotoResponse.getPhotos());
		// mListView.setAdapter(adapter);
		MyCustomAdapter adapter = new MyCustomAdapter(this, R.layout.row_item, mPhotos.getPhotos());
		mListView.setAdapter(adapter);
		
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
		if (id == R.id.action_settings) {
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
						"photoTitle", "photoDescription" },
				new int[] { R.id.imageView1, R.id.title,
						R.id.description });

		return adapter;
	}
}
