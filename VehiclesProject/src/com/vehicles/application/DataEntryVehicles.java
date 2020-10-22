package com.vehicles.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vehicle.persistence.VehiclesRepository;
import com.vehicles.project.Car;
import com.vehicles.project.Vehicle;
import com.vehicles.project.Wheel;

public class DataEntryVehicles {
	static Scanner registro = new Scanner(System.in);
	
	private static DataEntryWheels controllerwheels=new DataEntryWheels();
	private static List<Wheel> wheels= new ArrayList<>();
	
	private VehiclesRepository repository = new VehiclesRepository();
		
	//Metodo para controlar la entrada de vehiculos
	public boolean dataEntryVehicles() throws Exception {
		String brand="";
		String color="";
		String plate="";
		boolean controlintroducciondatos=false;
		do{ //Bucle para realizar entradas de datos mientras no se produzca una entrada vacia.
			brand=color=plate="";//Ponemos a 0 las variables cada vez que entramos en el bucle
			brand=dataentrybrand();
			if (brand.isEmpty()) break;//En el caso
			controlintroducciondatos=true;
			color=dataEntryColor();
			plate=dataEntryPlate();
			
			createCar(brand, color, plate);//LLamar al método para almacenar la info
		}while (!brand.isEmpty());
		//brand.
		return controlintroducciondatos;
	}

	//Método para la entrada de la marca
	public String dataentrybrand() {
		String brandin="";
		System.out.println("Introduce la Marca del vehiculo: ");
		brandin= registro.nextLine();
		brandin = brandin.trim();//Eliminación de espacios vacios al princpio y al final
		return brandin;
	}
	
	//Metodo para la entrada del color
	public String dataEntryColor() {
		String colorin="";
		do {//Bucle para impedir entradas vacias
			System.out.println("Introduce el color del vehiculo: ");
			colorin= registro.nextLine();
			colorin = colorin.trim();
		}while(colorin.equals(""));
		return colorin;
	}
	
	//Método para la entrada de la matricula
	public String dataEntryPlate() {
		String platein="";
		do {//Bucle para impedir entradas vacias     
			System.out.println("Introduce la matricula del vehiculo: ");
			platein= registro.nextLine();
			platein = platein.trim();
		}while(platein.equals(""));
		return platein;
	}

	
	
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
		
	}

	public void dataOutVehicles() {
		List<Vehicle> vehicles = repository.getAllVehicle();
		
		for (Vehicle vehicleiterator : vehicles) {
			System.out.println("\n"+ vehicleiterator.getVehicle());
			
			
		}
	
		//Pdte implementar más opciones de salida de datos
	}
	
	
	
}
