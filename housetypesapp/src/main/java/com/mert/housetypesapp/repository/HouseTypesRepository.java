package com.mert.housetypesapp.repository;

import java.util.ArrayList;
import java.util.List;

import com.mert.housetypesapp.model.Building;
import com.mert.housetypesapp.model.House;
import com.mert.housetypesapp.model.Resort;
import com.mert.housetypesapp.model.Villa;
import com.mert.housetypesapp.service.BuildingTypes;

public class HouseTypesRepository {
	
	private List<Building> houses = new ArrayList<>();
	private List<Building> villas = new ArrayList<>();
	private List<Building> resorts = new ArrayList<>();	
	
	public void createBuildings() {
		
		for (int i = 1; i <= 3; i++) {
			houses.add(createHouse(1000000 * i, i + 1, 1, 44.5 * i + 30));
			villas.add(createVilla(2000000 * i, 2*i + 1, 2, 50 * (i + 3)));
			resorts.add(createResort(1500000, i + 1, 1, 37.5 * i + 20));
		}
		System.out.println(houses);
		System.out.println(villas);
		System.out.println(resorts);
	}
	
	public Building createHouse(long price, int roomsCount, int salonsCount, double squareMeter) {
		return new House(price, roomsCount, salonsCount, squareMeter);
	}
	
	public Building createVilla(long price, int roomsCount, int salonsCount, double squareMeter) {
		return new Villa(price, roomsCount, salonsCount, squareMeter);
	}
	
	public Building createResort(long price, int roomsCount, int salonsCount, double squareMeter) {
		return new Resort(price, roomsCount, salonsCount, squareMeter);
	}
	
	public List<Building> getBuildingByType(BuildingTypes type) {
		if (type == BuildingTypes.House) {
			return getHouses();
		} else if (type == BuildingTypes.Villa) {
			return getVillas();
		} else if (type == BuildingTypes.Resort) {
			return getResorts();
		}
		return null;
	}

	public List<Building> getHouses() {
		return houses;
	}
	
	public List<Building> getVillas() {
		return villas;
	}
	
	public List<Building> getResorts() {
		return resorts;
	}
}
