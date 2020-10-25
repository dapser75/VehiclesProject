package com.vehicles.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vehicles.persistence.VehiclesRepository;
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
		boolean controlplateisok = false;
		do {//Bucle para impedir entradas vacias     
			System.out.println("Introduce la matricula del vehiculo: ");
			platein= registro.nextLine();
			platein = platein.trim();
			controlplateisok=controlPlateIsOK(platein);
		}while((platein.equals("") || !controlplateisok));
		return platein;
	}

	//Metodo para verificar la matricula es correcta
	public boolean controlPlateIsOK (String plate) {
		String platenumbers="";
		String plateletters="";
		plate = plate.replace(" ", ""); //eliminamos posibles espacios intermedios.
		boolean controlplateisok=true;
		
		if (plate.length()<6 || plate.length()>7) { //Verificamos que la longitud de la matricula sea correcta.
			System.out.println("\nLa matricula introducida no es correcta, tiene que tener el siguiente formato: 1234 AAA ó 1234 AA");
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
	
	//Metodo para controlar si la parte de la matricula está compuesta por letras
	public boolean controlPlateLetters(String plateletters) {
		boolean controlplatenumberisok=true;
		for (int i=0; i < plateletters.length(); i++ ) {
			if (!Character.isAlphabetic(plateletters.charAt(i))) {
				controlplatenumberisok=false;
				System.out.println("\n La matricula introducida no es correcta, tiene que tener el siguiente formato: 1234 AAA ó 1234 AA");
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
				System.out.println("\n La matricula introducida no es correcta, tiene que tener el siguiente formato: 1234 AAA ó 1234 AA");
				break;
			}
		}
		return controlplatenumberisok;
	}
	
	//Metodo para añadir
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
				car.addWheels(frontWheels, rearWheels); ///control de excepción
				repository.addVehicle(car);
				controlexception=true;
			}catch (Exception e) {
				controlexception=false;
			}
		}while (!controlexception); //Repetimos entrada mientras haya excepciones
		
	}
	
	
	public void dataOutVehicles() {
		List<Vehicle> vehicles = repository.getAllVehicle();
		
		for (Vehicle vehicleiterator : vehicles) {
			System.out.println("\n"+ vehicleiterator.getVehicle());
	
		}
	
		//Pdte implementar más opciones de salida de datos
	}
	
	
	
}
