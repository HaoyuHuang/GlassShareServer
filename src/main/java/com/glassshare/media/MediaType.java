package com.glassshare.media;

/**
 * @author Haoyu
 *
 */
public enum MediaType {

	NULL(0, "null"), PHOTO(1, "photo"), VIDEO(2, "video");

	int id;
	String description;

	MediaType(int id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public static MediaType fromString(String type) {
		if (PHOTO.toString().equals(type)) {
			return PHOTO;
		} else if (VIDEO.toString().equals(type)) {
			return VIDEO;
		}
		return NULL;
	}

}
