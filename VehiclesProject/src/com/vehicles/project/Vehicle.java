package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	protected int id;
	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();
	
	private static int COUNTERVEHICLES = 1;

	public Vehicle(String brand, String color, String plate)  {
		
		this.brand = brand;
		this.color = color;
		this.plate = plate;
		id = COUNTERVEHICLES;
		COUNTERVEHICLES++;
	}
	public abstract String getVehicle();
	
	public abstract String getWheels();
	
	

}
