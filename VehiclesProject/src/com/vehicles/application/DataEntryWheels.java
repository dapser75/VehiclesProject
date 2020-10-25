package com.vehicles.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.vehicles.project.*;
import java.io.IOException; 


public class DataEntryWheels {
	
	//private static Wheel wheel = new Wheel();
	private static List<Wheel> wheels= new ArrayList<>();
	
	static Scanner registro = new Scanner(System.in);
	
	public  List<Wheel> dataEntryWheelsCar() throws Exception {
		wheels.add(0, dataEntryWheels(" delantera derecha: "));
		wheels.add(1,dataEntryWheels(" delantera izquierda: "));
		wheels.add(2,dataEntryWheels(" trasera derecha: "));
		wheels.add(3,dataEntryWheels(" trasera izquierda: "));
		return wheels; 
	}

	
	//Metodo para la introducción de las ruedas
	public Wheel dataEntryWheels(String wheeltype) throws Exception{
		boolean controlexceptionwheel=false;
		Wheel wheelunitary;
		do {
			try	{
				wheelunitary=new Wheel(dataEntryWheelBrand(wheeltype),dataEntryWheelDiameter(wheeltype));
				controlexceptionwheel=true;
			}catch (Exception e) {
				controlexceptionwheel=false;
				wheelunitary=null;//Lo ponemos a 0 para el recolector de basura
			}
		}while(!controlexceptionwheel);
		return wheelunitary;
	}
	
	//Metodo para la entrada de la marca del neumático
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
		boolean controldatotipodouble;
		do {
			controldatotipodouble=false;
			try {
				System.out.println("Introduce la medida de la rueda" + wheeltype);
				diameterwheel = registro.nextDouble();
				registro.nextLine();
				controldatotipodouble=true;
			}catch (Exception e) {
				System.out.println("\nLos datos introducidos para la medida del neumatico no son correctos El diametro debe ser MAYOR que 0.4 y MENOR que 4.");
				registro.nextLine();
				controldatotipodouble=false;
			}
		}while (!controldatotipodouble);
		//}while(!controldatotipofloat || diameterwheel<0.4 || diameterwheel>4);//repetimos bucle hasta que el dato introducido no sea correcto
		return diameterwheel;
	}//fin metodo entrada diametro
			
}
