package com.example.androidapp;

import com.example.androidapp.utils.ImageCacheLoader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class PhotoViewActivity extends Activity{

	private ImageView mImageView;
	private TextView mTitle;
	private TextView mUserName;
	private TextView mCountry;
	private Photos mPhotos;
	private ImageCacheLoader mImageCacheLoader;
	private static final String TAG = "PhotoViewActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo);
		mImageCacheLoader = new ImageCacheLoader(this);
		
		mImageView = (ImageView) findViewById(R.id.imageView1);
		mTitle = (TextView) findViewById(R.id.title);
		mUserName = (TextView) findViewById(R.id.username);
		mCountry = (TextView) findViewById(R.id.country);
		
		Intent intent = getIntent();
		mPhotos = (Photos) intent.getExtras().getSerializable("PHOTOS");
		int position = intent.getIntExtra("POSITION", 0);
		mTitle.setText("Title : " + mPhotos.getPhotos().get(position).getName());
		mUserName.setText("User : " + mPhotos.getPhotos().get(position).getUser().getUsername());
		mCountry.setText("Country : " + mPhotos.getPhotos().get(position).getUser().getCountry());
		mImageCacheLoader.DisplayImage(mPhotos.getPhotos().get(position).getImage_url(), mImageView);
	}
}
