package com.example.androidapp;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Photo implements Serializable
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getLens() {
		return lens;
	}

	public void setLens(String lens) {
		this.lens = lens;
	}

	public String getFocal_length() {
		return focal_length;
	}

	public void setFocal_length(String focal_length) {
		this.focal_length = focal_length;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getShutter_speed() {
		return shutter_speed;
	}

	public void setShutter_speed(String shutter_speed) {
		this.shutter_speed = shutter_speed;
	}

	public String getAperture() {
		return aperture;
	}

	public void setAperture(String aperture) {
		this.aperture = aperture;
	}

	public String getTimes_viewed() {
		return times_viewed;
	}

	public void setTimes_viewed(String times_viewed) {
		this.times_viewed = times_viewed;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getStatus() {
		return status;
	}

	public void setStatus(double status) {
		this.status = status;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public boolean isPrivacy() {
		return privacy;
	}

	public void setPrivacy(boolean privacy) {
		this.privacy = privacy;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getTaken_at() {
		return taken_at;
	}

	public void setTaken_at(String taken_at) {
		this.taken_at = taken_at;
	}

	public int getHi_res_uploaded() {
		return hi_res_uploaded;
	}

	public void setHi_res_uploaded(int hi_res_uploaded) {
		this.hi_res_uploaded = hi_res_uploaded;
	}

	public boolean isFor_sale() {
		return for_sale;
	}

	public void setFor_sale(boolean for_sale) {
		this.for_sale = for_sale;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getVotes_count() {
		return votes_count;
	}

	public void setVotes_count(int votes_count) {
		this.votes_count = votes_count;
	}

	public int getFavorites_count() {
		return favorites_count;
	}

	public void setFavorites_count(int favorites_count) {
		this.favorites_count = favorites_count;
	}

	public int getComments_count() {
		return comments_count;
	}

	public void setComments_count(int comments_count) {
		this.comments_count = comments_count;
	}

	public boolean isNsfw() {
		return nsfw;
	}

	public void setNsfw(boolean nsfw) {
		this.nsfw = nsfw;
	}

	public int getSales_count() {
		return sales_count;
	}

	public void setSales_count(int sales_count) {
		this.sales_count = sales_count;
	}

	public String getFor_sale_date() {
		return for_sale_date;
	}

	public void setFor_sale_date(String for_sale_date) {
		this.for_sale_date = for_sale_date;
	}

	public double getHighest_rating() {
		return highest_rating;
	}

	public void setHighest_rating(double highest_rating) {
		this.highest_rating = highest_rating;
	}

	public String getHighest_rating_date() {
		return highest_rating_date;
	}

	public void setHighest_rating_date(String highest_rating_date) {
		this.highest_rating_date = highest_rating_date;
	}

	public int getLicense_type() {
		return license_type;
	}

	public void setLicense_type(int license_type) {
		this.license_type = license_type;
	}

	public int getConverted() {
		return converted;
	}

	public void setConverted(int converted) {
		this.converted = converted;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public boolean isStore_download() {
		return store_download;
	}

	public void setStore_download(boolean store_download) {
		this.store_download = store_download;
	}

	public boolean isStore_print() {
		return store_print;
	}

	public void setStore_print(boolean store_print) {
		this.store_print = store_print;
	}

	public boolean isEditors_choice() {
		return editors_choice;
	}

	public void setEditors_choice(boolean editors_choice) {
		this.editors_choice = editors_choice;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public boolean isFavorited() {
		return favorited;
	}

	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}

	public boolean isPurchased() {
		return purchased;
	}

	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}