package com.example.androidapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
	
	public class DataLoadingTask extends AsyncTask<Integer, Integer, Long> {

		@Override
		protected Long doInBackground(Integer... params) {
			// TODO Auto-generated method stub
			String jsonFileUrl = ConstsIgnore.API_URL + "&consumer_key=" + ConstsIgnore.CONSUMER_KEY;
			mPhotoResponse = ObjectsReader
					.readPhotoResponse(jsonFileUrl);
			return null;
		}

		protected void onProgressUpdate(Integer... progress) {

		}

		protected void onPostExecute(Long result) {
			display();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mButton = (Button) findViewById(R.id.button1);
		mTextView = (TextView) findViewById(R.id.textView1);

		mButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				mTextView.setText("Button was clicked");
				new DataLoadingTask().execute();
			}
		});
		
		mListView = (ListView) findViewById(R.id.listView1);
		
		
		
		
	}
	private void display() {
		ListAdapter adapter = createPhotosListAdapter(mPhotoResponse.getPhotos());
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
