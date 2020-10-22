package com.vehicles.application;

import com.vehicles.project.*;

import java.util.ArrayList;
import java.util.List;

import com.vehicle.persistence.*;

public class VehiclesController {
	
	private VehiclesRepository repository = new VehiclesRepository();
	private static DataEntryWheels controllerwheels=new DataEntryWheels();
	private static List<Wheel> wheels= new ArrayList<>();
	
	public void Vehiclescontroller() {
		
	}
	/*
	
	
	
	public void createCar(String brand, String color, String plate) throws Exception{
		List<Wheel> frontWheels = new ArrayList<>();
		List<Wheel> rearWheels = new ArrayList<>();
		wheels = controllerwheels.dataEntryWheelsCar();
		frontWheels.add(wheels.get(0));
		frontWheels.add(wheels.get(1));
		rearWheels.add(wheels.get(2));
		rearWheels.add(wheels.get(3));
				
		Car car = new Car(brand, color, plate );
		car.addWheels(frontWheels, rearWheels);
				
		repository.addVehicle(car);
		
	}*/
	

}
