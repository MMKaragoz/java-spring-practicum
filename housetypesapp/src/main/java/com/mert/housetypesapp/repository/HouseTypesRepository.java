package com.mert.housetypesapp.repository;

import java.util.ArrayList;
import java.util.List;

import com.mert.housetypesapp.model.Building;
import com.mert.housetypesapp.model.factory.BuildingFactory;
import com.mert.housetypesapp.service.BuildingTypes;
/**
 * 
 * house types repository
 *
 */
public class HouseTypesRepository {
	
	private List<Building> houses = new ArrayList<>();
	private List<Building> villas = new ArrayList<>();
	private List<Building> resorts = new ArrayList<>();	
	
	/**
	 * creates buildings
	 */
	
	public void createBuildings() {
		BuildingFactory buildingFactory = new BuildingFactory();
		
		try {
			for (int i = 1; i <= 3; i++) {
				houses.add(buildingFactory.createBuildingType(BuildingTypes.House,1000000 * i, i + 1, 1, 44.5 * i + 30));
				villas.add(buildingFactory.createBuildingType(BuildingTypes.Villa, 2000000 * i, 2*i + 1, 2, 50 * (i + 3)));
				resorts.add(buildingFactory.createBuildingType(BuildingTypes.Resort, 1500000, i + 1, 1, 37.5 * i + 20));
			}
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
		System.out.println(houses);
		System.out.println(villas);
		System.out.println(resorts);
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
	
	/**
	 * gets houses
	 * 
	 * @return
	 */

	public List<Building> getHouses() {
		return houses;
	}
	
	/**
	 * gets villas
	 * 
	 * @return
	 */
	
	public List<Building> getVillas() {
		return villas;
	}
	
	/**
	 * gets resorts
	 * 
	 * @return
	 */
	
	public List<Building> getResorts() {
		return resorts;
	}
}
