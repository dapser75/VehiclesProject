/*EJERCICIO 6 FASE 2 DEL PROGRAMA BACKEND IT ACADEMY
 * 
 *EJERCICIO SOBRE HERENCIA:
 *En este ejercicio se trata de introduir vehículos con una serie de parámetros.
 * 
 * Realizado por: Daniel Arizu
 * Fecha:23/10/2020
 * 
 */

package com.vehicles.view;

import java.util.Scanner;

import com.vehicles.application.DataEntryVehicles;

public class Main {
	
	private static DataEntryVehicles controller=new DataEntryVehicles();
	
	static Scanner registro = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		char inputtypevehicle;
		do{
			System.out.println("\nIntroduce el tipo de vehiculo CAR (C) o BIKE (B) y EXIT (E) para salir.");
			inputtypevehicle = registro.next().charAt(0); //capturamos el primer carcater
	      
	        switch (inputtypevehicle) 
	        {
	            case 'B':  //Opcion de entrada de vehiculos tipo moto
	            case 'b':  
	            	System.out.println("\nHas elegido un vehiculo tipo MOTO.");
	            	controller.dataEntryVehiclestypebike();
	                break;
	                     
	            case 'C'://Opcion de entrada de vehiculos tipo coche
	            case 'c':
	            	System.out.println("\nHas elegido un vehiculo tipo COCHE.");
	            	controller.dataEntryVehiclestypecar();
	            	break;
	            case 'E'://Opción salir y dejar dejar de introducir datos
	            case 'e':     
	            	System.out.println("\nFin de entrada de datos.");
	            		break;
	            
	            default: System.out.println("\nERROR: OPCIÓN NO VALIDA.");
	                     break;
	        }//fin switch-case
		 }while (inputtypevehicle!='E' && inputtypevehicle!='e');
	
		controller.dataOutVehicles();
		controller.dataOutVehiclesCar();
		controller.dataOutVehiclesBike();
	}
		
}
