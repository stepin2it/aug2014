package com.stepin2it.stepin2it.androidlibrary;

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
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public Filters getFilters() {
		return filters;
	}
	public void setFilters(Filters filters) {
		this.filters = filters;
	}
	public int getCurrent_page() {
		return current_page;
	}
	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public int getTotal_items() {
		return total_items;
	}
	public void setTotal_items(int total_items) {
		this.total_items = total_items;
	}
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	
}
