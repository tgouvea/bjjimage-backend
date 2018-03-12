package com.bjjimage.api.enums;

public enum TamanhoType {

	PEQUENO("10 x 15cm 1800x1200"),
	MEDIA("13 x 18 cm 2100 x 1500"),
	MEDIAALTA("15 x 21 cm 2500 x 1800"),
	ALTA("20 x 30 cm 3600 x 2400");
	
	private String value;

	private TamanhoType(String value) {
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
