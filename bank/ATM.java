package com.quantum.bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class ATM {

	// Atributos de Clase
	private BigDecimal balance = new BigDecimal(10000.00);
	private final String USER_NAME = "Rogelio";
	private final short NIP = 1234;
	
	private ArrayList<String[]> historial = new ArrayList<String[]>();
	private String action,description;
	
	// Constructor
	protected ATM(){}
	
	// Metodo Scanner
	Scanner sc = new Scanner( System.in );
	
	// Metodos Get
	public BigDecimal getBalance() {
		return balance;
	}
	
	public String getUSER_NAME() {
		return USER_NAME;
	}
	
	public short getNIP() {
		return NIP;
	}
	
	// ************************** Metodos del Cajero **************************
	// Retirar Dinero
	protected void consultBalance() {
		
		System.out.println("\n************ Consultar Saldo ************");
		System.out.println("Saldo Disponible: " + getBalance());
		
		action = "Consulta de Saldo";
		description = "No Aplica";
		registro(action,description);
		
	}
	
	// Quejas
	protected void complaints() {
		
		System.out.println("\n************ Buzon de Quejas ************");
		System.out.println("No Disponible Por El Momento");
		
		action = "Buzon de Quejas";
		description = "No aplica";
		registro(action,description);
		
	}
	
	// Salir del Cajero
	protected void outAtm() {
		System.out.println("\n************ Salir del Cajero ************");
		System.out.println("Gracias Por Usar Nuestro Servicio\nBuen Dia!\n");
	}
	
	// ************************ Retirar Dinero *******************************
	private boolean verifyConditionsWD(int quantity) {
		
		boolean response = false;
		int difference = getBalance().compareTo(new BigDecimal(quantity));
		
		if((quantity > 0) && (quantity%50 == 0) && (quantity <= 6000)) {
			if((difference == 1) || (difference == 0) ) {
				response = true;
			}
		}
		
		return response;
		
	}
	
	private void runWithDraw(int quantity) {
		
		balance = balance.subtract(new BigDecimal(quantity));
		System.out.println("***** Retiro Extoso *****");
		System.out.println("Saldo Disponible: " + getBalance());
		
		action = "Retiro de Dinero";
		description = "Monto de Retiro: " + quantity;
		registro(action,description);
		
		
	}
	
	protected void withdraw() {
		System.out.println("\n************ Retirar Dinero ************");
		System.out.println("Ingresa la Cantidad a Retirar: ");
		int quantity = sc.nextInt();
		
		if (verifyConditionsWD(quantity)) {
			runWithDraw(quantity);
		} else {
			System.out.println("Cantidad Incorrecta. Intenta de Nuevo");
			withdraw();
		}
		
	}
	
	// ************************ Depositar Dinero *******************************
	private boolean verifyConditionsDT(BigDecimal quantity) {
		boolean response;
		int positive = quantity.compareTo(new BigDecimal(0));
		int remainder = quantity.remainder(new BigDecimal(50)).compareTo(new BigDecimal(0));
		
		response = ((positive != -1) && (remainder == 0))? true: false;
		
		return response;
	}
	
	private void runDeposit(BigDecimal quantity) {
		balance = balance.add(quantity);
		System.out.println("***** Deposito Exitoso *****");
		System.out.println("Saldo Disponible: " + getBalance());
		
		action = "Deposito de Dinero";
		description = "Monto de Deposito: " + quantity;
		registro(action,description);
	}
	
	protected void deposit() {
		System.out.println("\n************ Depositar Dinero ************");
		System.out.println("Ingresa la Cantidad a Depositar: ");
		BigDecimal quantity = new BigDecimal( sc.nextDouble() );
		
		if(verifyConditionsDT(quantity)) {
			runDeposit(quantity);
		} else {
			System.out.println("La cantidad ingresada es incorrecta. Intenta de nuevo.");
			deposit();
		}
		
	}
	
	// ************************ Depositar Dinero A Tarjeta *******************************
	protected void depositCard() {
		System.out.println("\n************ Depositar Dinero A Tarjeta De Credito ************");
		System.out.println("Ingresa la Cantidad a Depositar: ");
		BigDecimal quantity = new BigDecimal( sc.nextDouble() );
		int positive = quantity.compareTo(new BigDecimal(0));
		
		if (positive != -1) {
			balance = balance.subtract(quantity);
			System.out.println("***** Deposito A Tarjeta Exitoso *****");
			System.out.println("Saldo Disponible: " + getBalance());
			action = "Deposito a Tarjeta de Credito";
			description = "Monto del Deposito: " + quantity;
			registro(action,description);
		} else {
			System.out.println("La cantidad ingresada es incorrecta. Intenta de nuevo.");
			depositCard();
		}
	}
	
	// ************************ Imprimir Historial *******************************************
	protected void printHistorial() {

		byte len = (byte)historial.size();
		String[] element = new String[3];
		System.out.println("Fecha \t | Accion \t | Descripcion");
		for (byte i=0; i<len; i++) {
			if(i == 5) {
				break;
			}
			element = historial.get(len-i-1);
			System.out.println(element[0] + " \t | " + element[1] + " \t | " + element[2]);
		}
		
	}
	
	// ************************ Donacion a la CH34 *******************************************
	protected void donation() {
		System.out.println("\n************ Donativo para la Graduacion de la CH34 ************");
		balance = balance.subtract(new BigDecimal(200));
		System.out.println("\n***** Donativo Exitoso. Muchas Gracias :) *****");
		
		action = "Donativo a la graduacion de la CH34";
		description = "Se dono la cantidad de 200MXN";
		registro(action,description);
	}
	
	// *********************** Registrar Accion **********************************
	private void registro(String action, String description) {
		LocalDateTime dateNow = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			
		String dateString = dateNow.format(formatter);
		String[] registroNow = {dateString, action, description};
			
		historial.add(registroNow);	
			
	}
	
}
