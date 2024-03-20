package com.course.me.enums;

public enum Priority {

	VERY_LOW(1), LOW(2), MEDIUM(3), HIGH(4), VERY_HIGH(5);
	
	private int value;

	private Priority(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	

}
