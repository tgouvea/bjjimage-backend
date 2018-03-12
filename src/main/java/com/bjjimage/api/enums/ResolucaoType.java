package com.bjjimage.api.enums;

public enum ResolucaoType {

	BAIXA("1800x1200"),
	MEDIA("2100 x 1500"),
	MEDIAALTA("2500 x 1800"),
	ALTA("3600 x 2400");
	
	private String value;

	private ResolucaoType(String value) {
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
