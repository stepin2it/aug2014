package com.stepin2it.stepin2it.androidlibrary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class Photos implements Serializable{
	private List<PhotoBak> mPhotos = new ArrayList<PhotoBak>();
	public Photos(List<PhotoBak> photos) {
		mPhotos = photos; 
	}
	public List<PhotoBak> getPhotos() {
		return mPhotos;
	}

	public void setPhotos(List<PhotoBak> photos) {
		this.mPhotos = photos;
	}
	

}
