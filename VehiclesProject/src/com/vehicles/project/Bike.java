package com.vehicles.project;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	
	//M�todo para retornar los datos de la moto
	@Override
	public String getVehicle() {
		String vehicle="";
		vehicle = "\n.- Tipo de Veh�culo: BIKE. Marca: " + brand + ". Color: " + color +
					". Matricula: " + plate + ". \n\tRuedas: " + getWheels();
	
		return vehicle;
	}
	
	public void addWheels (List<Wheel> wheels) throws Exception{
	Wheel frontwheel = wheels.get(0);
	Wheel rearwheel = wheels.get(1);
		if (wheels.size() != 2) {
			System.out.println("\nERROR: Una moto debe tener 2 ruedas.");
			throw new Exception();
		}
		this.wheels.add(frontwheel);
		this.wheels.add(rearwheel);
	}
	//M�todo para retornar las ruedas de la moto
	@Override
	public String getWheels(){
		String allwheelsvehicle="";
		allwheelsvehicle="\n \t\t Neumatico Delantero: " + wheels.get(0).getwheel() +
							"\n \t\t Neumatico Trasero:" + wheels.get(1).getwheel();
		return allwheelsvehicle;
		
	}//Fin metodo
	
}
