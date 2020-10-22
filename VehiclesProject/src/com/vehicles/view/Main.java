package com.vehicles.view;

import com.vehicles.application.DataEntryVehicles;

public class Main {
	
	private static DataEntryVehicles controller=new DataEntryVehicles();
	
	public static void main(String[] args) throws Exception {
			
		//Llamada al metodo de entrada de datos
		if (controller.dataEntryVehicles()) {
			controller.dataOutVehicles();
			
			System.out.println("\nFIN DE LA EJECUCIÓN.");
		}
		else System.out.println("\nNO HAS INTRODUCIDO DATOS. FIN DE LA EJECUCIÓN.");
	}
}
