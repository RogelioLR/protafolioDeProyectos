package com.quantum.bank.test;

import java.util.Scanner;

public class QuantumBank {

	public static void main(String[] args) {

		Scanner sc = new Scanner( System.in );
		MenuATM user = new MenuATM();
		
		// Inicio de la Aplicacion
		short nip;
		String name;
		
		System.out.println("\n¡Bienvenido a QuantumBank!");
		System.out.println("Ingresa tu nombre de usuario: ");
		name = sc.nextLine();
		System.out.println("Ingresa tu NIP: ");
		nip = sc.nextShort();
		
		if ((name.equals(user.getUSER_NAME())) && (nip == user.getNIP())) {
			System.out.println("¡Hola " + name + " esperemos te encuentres excelente hoy!");
			user.menu();
		} else {
			System.out.println("!Los datos ingresados son erroneos!\nFin de la operacion.");
		}
		
		
		sc.close();

	}

}
