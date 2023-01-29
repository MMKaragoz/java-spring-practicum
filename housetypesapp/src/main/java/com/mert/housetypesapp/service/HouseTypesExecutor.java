package com.mert.housetypesapp.service;

import java.util.List;

import com.mert.housetypesapp.model.Building;

public class HouseTypesExecutor {
	
	private final HouseTypesService service;
	
	public HouseTypesExecutor(HouseTypesService service) {
		this.service = service;
	}
	
	public void manageTheScenario() {
		service.createBuildings();
		
		long priceOfAllHouses = service.calculateTotalPriceByType(BuildingTypes.House);
		System.out.println("The price of all houses: " + priceOfAllHouses + " dollars.");
		
		long priceOfAllVillas = service.calculateTotalPriceByType(BuildingTypes.Villa);
		System.out.println("The price of all villas: " + priceOfAllVillas + " dollars.");
		
		long priceOfAllResorts = service.calculateTotalPriceByType(BuildingTypes.Resort);
		System.out.println("The price of all resorts: " + priceOfAllResorts + " dollars.");
		
		long priceOfAllBuildings = service.calculateTotalPrice();
		System.out.println("The price of all buildings: " + priceOfAllBuildings + " dollars.");
		
		double averageSquareMeterOfAllHouses = service.calculateAverageSquareMeterByType(BuildingTypes.House);
		System.out.println("The average square meter of all houses: " + String.format("%.2f", averageSquareMeterOfAllHouses) +  " m².");
		
		double averageSquareMeterOfAllVillas = service.calculateAverageSquareMeterByType(BuildingTypes.Villa);
		System.out.println("The average square meter of all villas: " + String.format("%.2f", averageSquareMeterOfAllVillas) + " m².");
		
		double averageSquareMeterOfAllResorts = service.calculateAverageSquareMeterByType(BuildingTypes.Resort);
		System.out.println("The average square meter of all resorts: " + String.format("%.2f", averageSquareMeterOfAllResorts) + " m².");
		
		double averageSquareMeterOfAllBuildings = service.calculateAverageSquareMeter();
		System.out.println("The average square meter of all resorts: " + String.format("%.2f", averageSquareMeterOfAllBuildings) + " m².");
		
		List<Building> filteredBuilding = service.filterBuildingsBasedOnRoomAndSalon(2, 1);
		
	}
}
