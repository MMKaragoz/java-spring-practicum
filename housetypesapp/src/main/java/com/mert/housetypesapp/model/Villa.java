package com.mert.housetypesapp.model;

public class Villa extends Building {

	public Villa(long price, int roomsCount, int salonsCount, double squareMeter) {
		super(price, roomsCount, salonsCount, squareMeter);
	}

	@Override
	public String toString() {
		return "Villa [getPrice()=" + getPrice() + ", getRoomsCount()=" + getRoomsCount() + ", getSalonsCount()="
				+ getSalonsCount() + ", getSquareMeter()=" + getSquareMeter() + "]";
	}
	
}
