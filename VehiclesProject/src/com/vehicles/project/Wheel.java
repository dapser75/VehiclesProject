package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel () { 
	}
	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}
	
	public boolean equals(Wheel rightWheel, Wheel leftWheel) {
		
		if ((rightWheel.brand.equalsIgnoreCase(leftWheel.brand))
			&& (rightWheel.diameter == leftWheel.diameter)) return true;
		
		else return false;
	}
	
	//Meodo para retornar
	public String getwheel() {
		return ("Marca: "+ brand + " Medida: " + diameter) ;
	}
}
