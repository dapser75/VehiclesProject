package com.vehicles.project;

import java.util.List;

public class Car extends Vehicle {

	public Car(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}

	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2) {
			System.out.println("\nERROR: Un coche debe tener 2 ruedas por eje.");
			throw new Exception();
		}

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(rightWheel, leftWheel)) {
			System.out.println("\nERROR: Las ruedas del mismo eje son diferentes. Tienen que ser de la misma marca y mismo diametro.");
			throw new Exception();
		}

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}

	//Método para devolver los datos pertenecientes a la clase "Car".
	@Override
	public String getVehicle() {
		String vehicle="";
		vehicle = "\n.- Tipo de Vehículo: Coche. Marca: " + brand + ". Color: " + color +
					". Matricula: " + plate + ". \n\tRuedas: " + getWheels();
	
		return vehicle;
	}
	
	@Override
	public String getWheels() {
		String allwheelsvehicle="";
		allwheelsvehicle="\n \t\t Neumatico Delantero Derecho: " + wheels.get(0).getwheel() +
							"\n \t\t Neumatico Delantero Izquierdo:" + wheels.get(1).getwheel() +
							"\n \t\t Neumatico Trasero Derecho:" + wheels.get(2).getwheel() +
							"\n \t\t Neumatico Trasero Izquierdo:" + wheels.get(3).getwheel();
		return allwheelsvehicle;
	}

	
	
}
