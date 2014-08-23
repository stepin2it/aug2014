package com.stepin2it.stepin2it.androidlibrary;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Photo
{
	@SerializedName("id")
	private int id;
	@SerializedName("user_id")
	private int user_id;
	@SerializedName("name")
	private String name;
	@SerializedName("description")
	private String description;
	@SerializedName("times_viewed")
	private int times_viewed;
	@SerializedName("rating")
	private double rating;
	@SerializedName("created_at")
	private String created_at;
	@SerializedName("category")
	private int category;
	@SerializedName("privacy")
	private boolean privacy;
	@SerializedName("width")
	private int width;
	@SerializedName("height")
	private int height;
	@SerializedName("votes_count")
	private int votes_count;
	@SerializedName("favorites_count")
	private int favorites_count;
	@SerializedName("comments_count")
	private int comments_count;
	@SerializedName("nsfw")
	private boolean nsfw;
	@SerializedName("license_type")
	private int license_type;
	@SerializedName("image_url")
	private String image_url;
	@SerializedName("images")
	private List<Image> images;
	@SerializedName("user")
	private User user;
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
	public int getTimes_viewed() {
		return times_viewed;
	}
	public void setTimes_viewed(int times_viewed) {
		this.times_viewed = times_viewed;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
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
	public boolean isPrivacy() {
		return privacy;
	}
	public void setPrivacy(boolean privacy) {
		this.privacy = privacy;
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
	public int getLicense_type() {
		return license_type;
	}
	public void setLicense_type(int license_type) {
		this.license_type = license_type;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
