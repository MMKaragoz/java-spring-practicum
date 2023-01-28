package com.mert.housetypesapp;

import com.mert.housetypesapp.model.Building;
import com.mert.housetypesapp.model.House;

public class HousetypesappApplication {

	public static void main(String[] args) {
		Building house = new House(1, 1, 1, 1);
		System.out.println(house);
	}

}
