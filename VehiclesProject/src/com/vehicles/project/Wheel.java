package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel () { 
	}
	public Wheel(String brand, double diameter) throws Exception {
		this.brand = brand;
		
		if ((diameter <= 0.4)||(diameter >= 4)) {
			System.out.println("\nERROR: El diámetro de la rueda debe ser MAYOR que 0.4 y MENOR que 4 se.");
			throw new Exception();
		}
		this.diameter = diameter;
		
	}
	
	public boolean equals(Wheel rightWheel, Wheel leftWheel) {
		
		if ((rightWheel.brand.equalsIgnoreCase(leftWheel.brand))
			&& (rightWheel.diameter == leftWheel.diameter)) return true;
		
		else return false;
	}
	
	//Metodo para retornar los valores de una rueda
	public String getwheel() {
		return ("Marca: "+ brand + " Medida: " + diameter) ;
	}
}
