package com.example.androidapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import com.example.androidapp.StackOverflowXmlParser;
import com.example.androidapp.StackOverflowXmlParser.Entry;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.webkit.WebView;

public class XmlParsingActivity extends Activity {
	
	 // Implementation of AsyncTask used to download XML feed from stackoverflow.com.
    private class DownloadXmlTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... urls) {
            try {
                	loadXmlFromNetwork(urls[0]);
            } catch (IOException e) {
                Log.d(this.getClass().getSimpleName(), getResources().getString(R.string.connection_error));
            } catch (XmlPullParserException e) {
                Log.d(this.getClass().getSimpleName(), getResources().getString(R.string.xml_error));
            }
			return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Displays the HTML string in the UI via a WebView
        }
    }
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xmlparsing);
		new DownloadXmlTask().execute(ConstsIgnore.STACKOVERFLOW_URL);
	
	}

	// Given a string representation of a URL, sets up a connection and gets
	// an input stream.
	private InputStream downloadUrl(String urlString) throws IOException {
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setReadTimeout(10000 /* milliseconds */);
		conn.setConnectTimeout(15000 /* milliseconds */);
		conn.setRequestMethod("GET");
		conn.setDoInput(true);
		// Starts the query
		conn.connect();
		InputStream stream = conn.getInputStream();
		return stream;
	}
	
	protected void loadXmlFromNetwork(String urlString) throws XmlPullParserException, IOException {
		InputStream stream = null;
		StackOverflowXmlParser stackOverflowXmlParser = new StackOverflowXmlParser();
		List<Entry> entries = null;
		String title = null;
		String url = null;
		String summary = null;
		Calendar rightNow = Calendar.getInstance();
		DateFormat formatter = new SimpleDateFormat("MMM dd h:mmaa");

		try {
			stream = downloadUrl(ConstsIgnore.STACKOVERFLOW_URL);
			entries = stackOverflowXmlParser.parse(stream);
			// Makes sure that the InputStream is closed after the app is
			// finished using it.
			
		} 

		
		finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// StackOverflowXmlParser returns a List (called "entries") of Entry
		// objects.
		// Each Entry object represents a single post in the XML feed.
		// This section processes the entries list to combine each entry with
		// HTML markup.
		// Each entry is displayed in the UI as a link that optionally includes
		// a text summary.
		for (Entry entry : entries) {
			 Log.d(XmlParsingActivity.class.getSimpleName(), "entry : " + entry.title);
		}

	}
}
