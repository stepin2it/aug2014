package com.stepin2it.stepin2it.androidlibrary;
import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Filters implements Serializable{
	@SerializedName("category")
	private boolean category;
	@SerializedName("exclude")
	private boolean exclude;
	public boolean isCategory() {
		return category;
	}
	public void setCategory(boolean category) {
		this.category = category;
	}
	public boolean getExclude() {
		return exclude;
	}
	public void setExclude(boolean exclude) {
		this.exclude = exclude;
	}

}
