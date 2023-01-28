package com.mert.housetypesapp.model;

public class House extends Building {

	public House(long price, int roomsCount, int salonsCount, double squareMeter) {
		super(price, roomsCount, salonsCount, squareMeter);
	}

	@Override
	public String toString() {
		return "House [getPrice()=" + getPrice() + ", getRoomsCount()=" + getRoomsCount() + ", getSalonsCount()="
				+ getSalonsCount() + ", getSquareMeter()=" + getSquareMeter() + "]";
	}
	
}
