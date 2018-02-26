package com.bjjimage.model;

public enum ImageType {
	
	PNG("png"),
	JPG("jpg");
	
	private String value;

	private ImageType(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}

	public String getValue() {
		return this.value;
	}
	
}
