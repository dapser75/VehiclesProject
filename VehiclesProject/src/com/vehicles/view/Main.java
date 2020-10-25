/*EJERCICIO 6 FASE 2 DEL PROGRAMA BACKEND IT ACADEMY
 * 
 *EJERCICIO SOBRE HERENCIA:
 *En este ejercicio se trata de introduir veh�culos con una serie de par�metros.
 * 
 * Realizado por: Daniel Arizu
 * Fecha:23/10/2020
 * 
 */

package com.vehicles.view;

import com.vehicles.application.DataEntryVehicles;

public class Main {
	
	private static DataEntryVehicles controller=new DataEntryVehicles();
	
	public static void main(String[] args) throws Exception {
	 //Llamada al metodo de entrada de datos
		if (controller.dataEntryVehicles()) {
			controller.dataOutVehicles();
			
			System.out.println("\nFIN DE LA EJECUCI�N.");
		}
		else System.out.println("\nNO HAS INTRODUCIDO DATOS. FIN DE LA EJECUCI�N.");
	}
}
