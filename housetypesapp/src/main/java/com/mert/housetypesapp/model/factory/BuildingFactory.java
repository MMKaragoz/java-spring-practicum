package com.mert.housetypesapp.model.factory;

import com.mert.housetypesapp.model.Building;
import com.mert.housetypesapp.model.House;
import com.mert.housetypesapp.model.Resort;
import com.mert.housetypesapp.model.Villa;
import com.mert.housetypesapp.service.BuildingTypes;

public class BuildingFactory {

	/**
	 * creates building according to building type.
	 * The factory method design pattern is applied.
	 * 
	 * @param buildingType
	 * @param price
	 * @param roomsCount
	 * @param salonsCount
	 * @param squareMeter
	 * @return
	 */
	public Building createBuildingType(BuildingTypes buildingType, long price, int roomsCount, int salonsCount, double squareMeter) {
		return switch (buildingType) {
		case House -> new House(price, roomsCount, salonsCount, squareMeter);
		case Resort -> new Resort(price, roomsCount, salonsCount, squareMeter);
		case Villa -> new Villa(price, roomsCount, salonsCount, squareMeter);
		default -> throw new IllegalArgumentException("Wrong Building Type");
		};
	}
}
