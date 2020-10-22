package com.vehicles.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.vehicles.project.*;

public class DataEntryWheels {
	
	//private static Wheel wheel = new Wheel();
	private static List<Wheel> wheels= new ArrayList<>();
	
	static Scanner registro = new Scanner(System.in);
	
	public  List<Wheel> dataEntryWheelsCar() {//falta metodo de retorno
		wheels.add(0, dataEntryWheels(" delantera derecha: "));
		wheels.add(1,dataEntryWheels(" delantera izquierda: "));
		wheels.add(2,dataEntryWheels(" trasera derecha: "));
		wheels.add(3,dataEntryWheels(" trasera izquierda: "));
		return wheels; //pdte introducir el retorno
	}

	
	//Metodo para la introducción de las ruedas
	public Wheel dataEntryWheels(String wheeltype){
			
		Wheel wheelunitary=new Wheel(dataEntryWheelBrand(wheeltype),dataEntryWheelDiameter(wheeltype));
		return wheelunitary;
	}
	
	//Metodo para la entrada de la marc del neumático
	public String dataEntryWheelBrand(String wheeltype) {
		String brandwheel="";
			do {

				System.out.println("Introduce la marca de la rueda" + wheeltype);
				brandwheel = registro.nextLine();
				brandwheel = brandwheel.trim();			
			}while(brandwheel.equals(""));
			return brandwheel;
	}//fin metodo entrada neumatico
	
	//Metodo para la entrada de la marca del neumático
	public double dataEntryWheelDiameter(String wheeltype) {
		double diameterwheel=0.0;
		boolean controldatotipofloat;
		do {
			controldatotipofloat=false;
			try {
				System.out.println("Introduce la medida de la rueda" + wheeltype);
				diameterwheel = registro.nextDouble();
				registro.nextLine();
				controldatotipofloat=true;
			}catch (Exception e) {
				System.out.println("\nLos datos introducidos para la medida del neumatico no son correctos.");
				registro.nextLine();
				controldatotipofloat=false;
			}
			
		}while(!controldatotipofloat);//repetimos bucle hasta que el dato introducido no sea correcto
		return diameterwheel;
	}//fin metodo entrada diametro
			
}
