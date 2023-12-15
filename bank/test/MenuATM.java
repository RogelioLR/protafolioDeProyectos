package com.quantum.bank.test;

import java.math.BigDecimal;
import java.util.Scanner;

import com.quantum.bank.ATM;

public class MenuATM extends ATM{
	
	private final String startMenu[] = {
			"Retirar Dinero ............... (1)",
			"Hacer Deposito ............... (2)",
			"Consultar Saldo .............. (3)",
			"Quejas ....................... (4)",
			"Historial de Movimientos ..... (5)",
			"Salir ........................ (9)"
	};
	
	private final String depositMenu[] = {
			"Deposito A Cuenta de Cheques ......... (1)",
			"Deposito A Tarjeta de Credito ........ (2)"
	};
	
	// Scanner
	Scanner sc = new Scanner( System.in );
	
	// Constructor
	public MenuATM() {
		super();
	}
	
	// Menu
	public void menu() {
		
		byte option, count;
		printMenu(startMenu);
		
		System.out.println("Operacion a Realizar: ");
		option = sc.nextByte();
		count = 0;
		
		do {
			
			switch(option) {
			case 1:
				count = 0;
				retirar();
				break;
			case 2:
				count = 0;
				depositar();
				break;
			case 3:
				count = 0;
				consultar();
				break;
			case 4:
				count = 0;
				quejas();
				break;
			case 5:
				count = 0;
				historial();
				break;
			case 9:
				super.outAtm();
				break;
			default:
				System.out.println("Opcion Incorrecta!\nIntenta Nuevamente");
				System.out.println("Operacion a Realizar: ");
				option = sc.nextByte();
				count += 1;
				break;
			}
			
			if (count == 2) {
				System.out.println("Has alcanzado el maximo numero de intentos\n"
						+ "La operacion ha sido terminada!");
			}
			
		} while(count < 2 && count != 0);
		
	}
	
	// Metodos de Menu
	private void retirar() {
		super.withdraw();
		
		System.out.println("¿Deseas donar 200MXN para la graduacion de la CH34? (y/n)");
		char option = sc.next().charAt(0);
		if(option == 'y') {
			if(super.getBalance().compareTo(new BigDecimal(200)) == 1) {
				super.donation();
			} else {
				System.out.println("No es posible la transaccion: Fondos Insuficientes");
			}
		}
		
		finalMenu();
	}
	
	private void consultar() {
		super.consultBalance();
		finalMenu();
	}
	
	private void quejas() {
		super.complaints();
		finalMenu();
	}
	
	private void depositar() {
		printMenu(depositMenu);
		byte option;
		byte count = 0;
		
		
		do {
			
			option = sc.nextByte();
			if(option == 1) {
				super.deposit();
				finalMenu();
			} else if (option == 2) {
				super.depositCard();
				finalMenu();
			} else {
				System.out.println("Opcion Incorrecta, Intenta de nuevo.");
				count += 1;
			}
			
		} while (count < 2 && count != 0);
		
		if (count == 2) {
			System.out.println("Has alcanzado el maximo numero de intentos\n"
					+ "La operacion ha sido terminada!");
		}
	}
	
	private void historial() {
		super.printHistorial();
		finalMenu();
	}
	
	// Imprime Menu
	private void printMenu(String[] menu) {
		for (byte i=0; i<menu.length; i++) {
			System.out.println(menu[i]);
		}
	}
	
	// Menu Final
	private void finalMenu() {
		System.out.println("¿Deseas realizar otra operacion? (y/n)");
		char option;
		byte count = 0;
			
		do {
				
			try {
				option = sc.next().charAt(0);
				if(option == 'y') {
					menu();
				} else {
					super.outAtm();
				}	
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error.\nIntenta de nuevo");
				count +=1;
			}
				
		} while(count < 2 && count != 0);
		
		if (count == 2) {
			System.out.println("Has alcanzado el maximo numero de intentos\n"
					+ "La operacion ha sido terminada!");
		}
	}

}
