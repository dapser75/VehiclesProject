package com.vehicles.persistence;

import java.util.ArrayList;
import java.util.List;
import com.vehicles.project.Vehicle;

public class VehiclesRepository {
	
	private static List<Vehicle> vehicles= new ArrayList<>();

	public VehiclesRepository() {
		
	}
	
	public List<Vehicle> getAllVehicle(){
			return new ArrayList<>(vehicles);
	}
	
	public void addVehicle(Vehicle vehicle) throws Exception{
		if(vehicle==null) throw new Exception();
		vehicles.add(vehicle);
	}
	
	public boolean contains(String plate){
		boolean plateisrepeat=false;
		for (int i=0; i<vehicles.size(); i++) {
			if (vehicles.get(i).getPlate().equalsIgnoreCase(plate)) {
				System.out.println("Matricula duplicada.");
				plateisrepeat=true;
			}
		}
		
		return plateisrepeat;
	}
}
