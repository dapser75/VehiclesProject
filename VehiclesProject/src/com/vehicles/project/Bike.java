package com.vehicles.project;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	
	
	//Metodo no operativo en el modulo 1
	@Override
	public String getVehicle() {
		String vehicle="";
		vehicle = "\n.- Tipo de Vehículo: Moto. Marca: " + brand + ". Color: " + color +
					". Matricula: " + plate + ". Ruedas: ";
	
		return vehicle;
	}
	
}
