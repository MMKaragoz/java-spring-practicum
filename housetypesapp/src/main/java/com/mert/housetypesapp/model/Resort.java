package com.mert.housetypesapp.model;

public class Resort extends Building {

	public Resort(long price, int roomsCount, int salonsCount, double squareMeter) {
		super(price, roomsCount, salonsCount, squareMeter);
	}

	@Override
	public String toString() {
		return "Resort [getPrice()=" + getPrice() + ", getRoomsCount()=" + getRoomsCount() + ", getSalonsCount()="
				+ getSalonsCount() + ", getSquareMeter()=" + getSquareMeter() + "]";
	}
	
}
