package com.example.androidapp;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class PhotoResponse {

	@SerializedName("feature")
	public String feature;
	@SerializedName("filters")
	public Filters filters;
	@SerializedName("current_page")
	public int current_page;
	@SerializedName("total_pages")
	public int total_pages;
	@SerializedName("total_items")
	public int total_items;
	@SerializedName("photos")
	public List<Photo> photos;
	
}
