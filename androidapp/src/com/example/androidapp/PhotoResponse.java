package com.example.androidapp;

import com.google.gson.annotations.SerializedName;

public class PhotoResponse {

	@SerializedName("current_page")
	private int currentPage;
	private int total_pages;
	private int total_items;
	private Photos photos;
	private Filters filters;
	private String feature;
	
	
	
}
