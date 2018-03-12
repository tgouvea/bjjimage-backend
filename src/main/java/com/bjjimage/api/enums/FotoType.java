package com.bjjimage.api.enums;

public enum FotoType {

	PNG("png"),
	JPG("jpg");
	
	private String value;

	private FotoType(String value) {
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
