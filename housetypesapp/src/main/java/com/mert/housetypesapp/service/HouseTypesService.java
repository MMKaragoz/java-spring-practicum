package com.mert.housetypesapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mert.housetypesapp.model.Building;
import com.mert.housetypesapp.repository.HouseTypesRepository;

/** 
 * 
 * house types service
 */

public class HouseTypesService {
	
	private final HouseTypesRepository repository;
	
	public HouseTypesService(HouseTypesRepository repository) {
		this.repository = repository;
	}
	
	
	/**
	 * directs the repository to create buildings
	 * 
	 */
	
	public void createBuildings() {
		repository.createBuildings();
		System.out.println("Buildings are created.");
	}
	
	/**
	 * calculates total price according to type which could be House, Villa, and Resort
	 * 
	 * @param type
	 * @return
	 */
	
	public long calculateTotalPriceByType(BuildingTypes type) {
		long totalPrice = 0L;
		List<Building> buildings = repository.getBuildingByType(type);
		for (Building building: buildings) {
			totalPrice += building.getPrice();
		}
		
		return totalPrice;
	}
	
	/**
	 * calculates total price for all buildings
	 * 
	 * @return
	 */
	
	public long calculateTotalPrice() {
		long totalPrice = 0L;
		List<Building> allBuildings = mergeAllTypeBuildings();
		
		for(Building building: allBuildings) {
			totalPrice += building.getPrice();
		}
		
		return totalPrice;
	}
	
	/**
	 * calculates total square meter based on building type
	 * 
	 * @param type
	 * @return
	 */
	
	public double calculateTotalSquareMeterByType(BuildingTypes type) {
		double totalSquareMeter = 0L;
		List<Building> buildings = repository.getBuildingByType(type);
		for (Building building: buildings) {
			totalSquareMeter += building.getSquareMeter();
		}
		
		return totalSquareMeter;
	}
	
	/**
	 * calculates total square meter for all buildings
	 * 
	 * @return
	 */
	
	public double calculateTotalSquareMeter() {
		double totalSquareMeter = 0L;
		List<Building> allBuildings = mergeAllTypeBuildings();
		
		for(Building building: allBuildings) {
			totalSquareMeter += building.getSquareMeter();
		}
		
		return totalSquareMeter;
	}
	
	/**
	 * calculates average square meter based on building type
	 * 
	 * @param type
	 * @return
	 */
	
	public double calculateAverageSquareMeterByType(BuildingTypes type) {
		double totalSquareMeter = calculateTotalSquareMeterByType(type);
		int lengthOfBuildings = repository.getBuildingByType(type).size();
		
		double averageSquareMeter = totalSquareMeter / lengthOfBuildings;
		
		return averageSquareMeter;
	}
	
	/**
	 * calculates average square meter for all buildings
	 * 
	 * @return
	 */
	
	public double calculateAverageSquareMeter() {
		double totalSquareMeter = calculateTotalSquareMeter();
		int lengthOfBuildings = getLengthOfAllBuildings();
		
		double averageSquareMeter = totalSquareMeter / lengthOfBuildings;
		
		return averageSquareMeter;
	
	}
	
	/**
	 * filters all buildings by number of rooms and salons
	 * 
	 * @param roomCount
	 * @param saloncount
	 * @return
	 */
	
	public List<Building> filterBuildingsBasedOnRoomAndSalon(int roomCount, int saloncount) {
		System.out.println("A building with " + roomCount + " room(s) and " + saloncount + " salon(s) was requested to be filtered.");
		
		List<Building> allBuildings = mergeAllTypeBuildings();
		List<Building> filteredBuildings = allBuildings.stream().filter(
				b -> b.getRoomsCount() == roomCount && b.getSalonsCount() == saloncount)
				.collect(Collectors.toList());
		
		if (filteredBuildings.size() == 0) {
			System.out.println("There is no building like that."); 
		} else {
			if (filteredBuildings.size() == 1) {
				System.out.println("There is only one building.");
			} else {
				System.out.println("There are " + filteredBuildings.size() + " buildings as you filtered.");				
			}
			System.out.println(filteredBuildings);
		}
		
		return filteredBuildings;
	}
	
	/**
	 * merges all buildings
	 * 
	 * @return
	 */
	
	private List<Building> mergeAllTypeBuildings() {
		List<Building> allBuildings = new ArrayList<>();
		allBuildings = Stream.of(repository.getHouses(),
								repository.getVillas(),
								repository.getResorts())
						.flatMap(b -> b.stream())
						.collect(Collectors.toList());
		
		return allBuildings;
	}
	
	/**
	 * gets length of all buildings
	 * @return
	 */
	
	private int getLengthOfAllBuildings() {
		int lengthOfHouses = repository.getHouses().size();
		int lengthOfVillas = repository.getVillas().size();
		int lengthOfResorts = repository.getResorts().size();
		
		int lengthOfAllBuildings = lengthOfHouses + lengthOfVillas + lengthOfResorts;
		
		return lengthOfAllBuildings;
	}
	
}
