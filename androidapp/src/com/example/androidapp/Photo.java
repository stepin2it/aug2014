package com.example.androidapp;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Photo
{
	@SerializedName("id")
	public int id;
	@SerializedName("user_id")
	public int user_id;
	@SerializedName("name")
	public String name;
	@SerializedName("description")
	public String description;
	@SerializedName("camera")
	public String camera;
	@SerializedName("lens")
	public String lens;
	@SerializedName("focal_length")
	public String focal_length;
	@SerializedName("iso")
	public String iso;
	@SerializedName("shutter_speed")
	public String shutter_speed;
	@SerializedName("aperture")
	public String aperture;
	@SerializedName("times_viewed")
	public String times_viewed;

	@SerializedName("rating")
	public double rating;

	@SerializedName("status")
	public double status;

	@SerializedName("created_at")
	public String created_at;

	@SerializedName("category")
	public int category;

	@SerializedName("location")
	public int location;

	@SerializedName("privacy")
	public boolean privacy;

	@SerializedName("latitude")
	public double latitude;

	@SerializedName("longitude")
	public double longitude;

	@SerializedName("taken_at")
	public String taken_at;

	@SerializedName("hi_res_uploaded")
	public int hi_res_uploaded;

	@SerializedName("for_sale")
	public boolean for_sale;

	@SerializedName("width")
	public int width;

	@SerializedName("height")
	public int height;

	@SerializedName("votes_count")
	public int votes_count;

	@SerializedName("favorites_count")
	public int favorites_count;

	@SerializedName("comments_count")
	public int comments_count;

	@SerializedName("nsfw")
	public boolean nsfw;

	@SerializedName("sales_count")
	public int sales_count;

	@SerializedName("for_sale_date")
	public String for_sale_date;

	@SerializedName("highest_rating")
	public double highest_rating;

	@SerializedName("highest_rating_date")
	public String highest_rating_date;

	@SerializedName("license_type")
	public int license_type;
	
	@SerializedName("converted")
	public int converted;

	@SerializedName("image_url")
	public String image_url;

	@SerializedName("images")
	public List<Image> images;

	@SerializedName("store_download")
	public boolean store_download;

	@SerializedName("store_print")
	public boolean store_print;
	
	@SerializedName("editors_choice")
	public boolean editors_choice;
	
	@SerializedName("feature")
	public String feature;
	
	@SerializedName("favorited")
	public boolean favorited;

	@SerializedName("purchased")
	public boolean purchased;

	@SerializedName("user")
	public User user;

}