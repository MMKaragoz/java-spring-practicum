package com.mert.housetypesapp.model;

public abstract class Building {

	private long price;
	private int roomsCount;
	private int salonsCount;
	private double squareMeter;
	
	public Building(long price, int roomsCount, int salonsCount, double squareMeter) {
		this.price = price;
		this.roomsCount = roomsCount;
		this.salonsCount = salonsCount;
		this.squareMeter = squareMeter;
	}

	public long getPrice() {
		return price;
	}

	public int getRoomsCount() {
		return roomsCount;
	}

	public int getSalonsCount() {
		return salonsCount;
	}

	public double getSquareMeter() {
		return squareMeter;
	}

	@Override
	public String toString() {
		return "Building [price=" + price + ", roomsCount=" + roomsCount + ", salonsCount=" + salonsCount
				+ ", squareMeter=" + squareMeter + "]";
	}
	
}
