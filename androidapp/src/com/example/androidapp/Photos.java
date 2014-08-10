package com.example.androidapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class Photos implements Serializable{
	private List<Photo> mPhotos = new ArrayList<Photo>();
	public Photos(List<Photo> photos) {
		mPhotos = photos; 
	}
	public List<Photo> getPhotos() {
		return mPhotos;
	}

	public void setPhotos(List<Photo> photos) {
		this.mPhotos = photos;
	}
	

}
