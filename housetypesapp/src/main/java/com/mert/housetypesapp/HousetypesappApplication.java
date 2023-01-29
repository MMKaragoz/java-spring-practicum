package com.mert.housetypesapp;

import com.mert.housetypesapp.repository.HouseTypesRepository;
import com.mert.housetypesapp.service.HouseTypesExecutor;
import com.mert.housetypesapp.service.HouseTypesService;

public class HousetypesappApplication {

	public static void main(String[] args) {
		HouseTypesRepository repository = new HouseTypesRepository();
		HouseTypesService service = new HouseTypesService(repository);
		HouseTypesExecutor executor = new HouseTypesExecutor(service);
		executor.manageTheScenario();
	}

}
