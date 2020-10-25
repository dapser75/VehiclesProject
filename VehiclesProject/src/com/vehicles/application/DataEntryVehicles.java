package com.vehicles.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vehicles.persistence.VehiclesRepository;
import com.vehicles.project.Bike;
import com.vehicles.project.Car;
import com.vehicles.project.Vehicle;
import com.vehicles.project.Wheel;

public class DataEntryVehicles {
	static Scanner registro = new Scanner(System.in);
	
	private static DataEntryWheels controllerwheels=new DataEntryWheels();
	private static List<Wheel> wheels= new ArrayList<>();
	
	private VehiclesRepository repository = new VehiclesRepository();
		
	//Metodo para controlar la entrada de vehiculos
	public void dataEntryVehiclestypecar() throws Exception {
		String brand="";
		String color="";
		String plate="";
		

		brand=color=plate="";//Ponemos a 0 las variables cada vez que entramos en el bucle
		brand=dataentrybrand();
	
		color=dataEntryColor();
		plate=dataEntryPlate();
		
		createCar(brand, color, plate);//LLamar al m�todo para almacenar la info
	}
	
	public void dataEntryVehiclestypebike() throws Exception {
		String brand="";
		String color="";
		String plate="";
		
		brand=color=plate="";//Ponemos a 0 las variables cada vez que entramos en el bucle
		brand=dataentrybrand();
	
		color=dataEntryColor();
		plate=dataEntryPlate();
		
		createBike(brand, color, plate);//LLamar al m�todo para almacenar la info
}
	
	
	//M�todo para la entrada de la marca
	public String dataentrybrand() {
		String brandin="";
		do {
			System.out.println("Introduce la Marca del vehiculo: ");
			brandin= registro.nextLine();
			brandin = brandin.trim();//Eliminaci�n de espacios vacios al princpio y al final
			brandin = brandin.toUpperCase();
		}while(brandin.isEmpty());
		return brandin;
	}
	
	//Metodo para la entrada del color
	public String dataEntryColor() {
		String colorin="";
		do {//Bucle para impedir entradas vacias
			System.out.println("Introduce el color del vehiculo: ");
			colorin= registro.nextLine();
			colorin = colorin.trim();
			colorin = colorin.toUpperCase();
		}while(colorin.equals(""));
		return colorin;
	}
	
	//M�todo para la entrada de la matricula
	public String dataEntryPlate() {
		String platein="";
		boolean controlplateisok = false;
		do {//Bucle para impedir entradas vacias     
			System.out.println("Introduce la matricula del vehiculo: ");
			platein= registro.nextLine();
			platein = platein.trim();
			platein = platein.replace(" ", ""); //eliminamos posibles espacios intermedios
			platein = platein.toUpperCase();
			controlplateisok=controlPlateIsOK(platein);
			if (repository.contains(platein)) controlplateisok = false;//Verificamos que la matricula no est� introducida.
		}while((platein.equals("") || !controlplateisok));
		return platein;
	}

	//Metodo para verificar la matricula es correcta
	public boolean controlPlateIsOK (String plate) {
		String platenumbers="";
		String plateletters="";
		boolean controlplateisok=true;
		
		if (plate.length()<6 || plate.length()>7) { //Verificamos que la longitud de la matricula sea correcta.
			System.out.println("\nLa matricula introducida no es correcta, tiene que tener el siguiente formato: 1234 AAA � 1234 AA");
			controlplateisok=false;
		}
	
		else {
			platenumbers=plate.substring(0,3);//Separamos las letras de los numeros
			plateletters=plate.substring(4,6);
			
			if ((!controlPlateNumbers(platenumbers)) || (!controlPlateLetters(plateletters)))controlplateisok=false;
			else controlplateisok=true;
		}
		return controlplateisok;
	}//fin metodo
	
	//Metodo para controlar si la parte de la matricula est� compuesta por letras
	public boolean controlPlateLetters(String plateletters) {
		boolean controlplatenumberisok=true;
		for (int i=0; i < plateletters.length(); i++ ) {
			if (!Character.isAlphabetic(plateletters.charAt(i))) {
				controlplatenumberisok=false;
				System.out.println("\n La matricula introducida no es correcta, tiene que tener el siguiente formato: 1234 AAA � 1234 AA");
				break;
			}
		}
		return controlplatenumberisok;
	}
	
	
	//Metodo para controlar si la parte de la matricula es numerica
	public boolean controlPlateNumbers(String platenumbers) {
		boolean controlplatenumberisok=true;
		for (int i=0; i < platenumbers.length(); i++ ) {
			if (!Character.isDigit(platenumbers.charAt(i))) {
				controlplatenumberisok=false; 
				System.out.println("\n La matricula introducida no es correcta, tiene que tener el siguiente formato: 1234 AAA � 1234 AA");
				break;
			}
		}
		return controlplatenumberisok;
	}
	
	//Metodo para a�adir  CAR
	public void createCar(String brand, String color, String plate) throws Exception{
		List<Wheel> frontWheels = new ArrayList<>();
		List<Wheel> rearWheels = new ArrayList<>();
		Car car = new Car(brand, color, plate );
		boolean controlexception=false;
		do {
			try {//control de excepciones de las ruedas
				frontWheels.clear();//Ponemos a 0 el array.
				rearWheels.clear();
				wheels = controllerwheels.dataEntryWheelsCar();
				frontWheels.add(wheels.get(0));
				frontWheels.add(wheels.get(1));
				rearWheels.add(wheels.get(2));
				rearWheels.add(wheels.get(3));
				car.addWheels(frontWheels, rearWheels); ///control de excepci�n
				repository.addVehicle(car);
				controlexception=true;
			}catch (Exception e) {
				controlexception=false;
			}
		}while (!controlexception); //Repetimos entrada mientras haya excepciones
	}
	
	//Metodo para a�adir  CAR
	public void createBike(String brand, String color, String plate) throws Exception{
		List<Wheel> bikeWheels = new ArrayList<>();
		
		Bike bike = new Bike(brand, color, plate );
		boolean controlexception=false;
		do {
			try {//control de excepciones de las ruedas
				bikeWheels.clear();//Ponemos a 0 el array.
				
				wheels = controllerwheels.dataEntryWheelsBike(); //pdte
				bikeWheels.add(wheels.get(0));
				bikeWheels.add(wheels.get(1));
				bike.addWheels(bikeWheels);
				repository.addVehicle(bike);
				controlexception=true;
			}catch (Exception e) {
				controlexception=false;
			}
		}while (!controlexception); //Repetimos entrada mientras haya excepciones
	}
	
	
	//Mostrar todos los vehiculos
	public void dataOutVehicles() {
		List<Vehicle> vehicles = repository.getAllVehicle();
		if (vehicles.isEmpty()){
			System.out.println("NO SE HAN DETECTADO DATOS DE VEHICULOS.");
		}
		else {
			
			for (Vehicle vehicleiterator : vehicles) {
				System.out.println("\n" + vehicleiterator.getVehicle());
			}
		
		}
	
	}
	//Mostrar todos los vehiculos tipo CAR
	public void dataOutVehiclesCar() {
		List<Vehicle> vehicles = repository.getAllVehicle();
		if (vehicles.isEmpty()){
			System.out.println("NO SE HAN DETECTADO DATOS DE VEHICULOS.");
		}
		else {
			System.out.println("ESTOS SON LOS VEHICULOS TIPO CAR:");
			for (Vehicle vehicleiterator : vehicles) {
				if(vehicleiterator.getClass() == Car.class) {//comparar clases
					System.out.println("\n"+ vehicleiterator.getVehicle());
				}
			}
				
		}
		
		
	}
	//Mostrar todos los vehiculos tipo BIKE
	public void dataOutVehiclesBike() {
		List<Vehicle> vehicles = repository.getAllVehicle();
		
		if (vehicles.isEmpty()){
			System.out.println("NO SE HAN DETECTADO DATOS DE VEHICULOS.");
		}
		else {
			System.out.println("ESTOS SON LOS VEHICULOS TIPO BIKE:");
			for (Vehicle vehicleiterator : vehicles) {
				if(vehicleiterator.getClass() == Bike.class) {//comparar clasesc
					System.out.println("\n"+ vehicleiterator.getVehicle());
				}
			}
				
		}
		
	}
	
	
	
}
