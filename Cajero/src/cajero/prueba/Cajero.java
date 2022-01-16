package cajero.prueba;

import java.util.Scanner;

public class Cajero {
	
	private static Scanner scaner;
	private static CuentaBancaria cuenta;
	private static int opcion;
	private static int opcionSubmenu;
	private static double saldoInicial;
	private static double cantidad;

	public static void main(String[] args) {
		scaner = new Scanner(System.in);
		do {
			menuPrincipal();
			pedirOpcionUsuario();
			opcion = leerInt();
			switch(opcion) {
			case 1: //crear cuenta
					submenu();
					pedirOpcionSubmenu();
					opcionSubmenu = leerInt();
					if(opcionSubmenu == 1 || opcionSubmenu == 2) {
						pedirSaldoInicial();
						saldoInicial = leerDouble();
						crearCuenta();	
					}	
					break;
			case 2://ingresar dinero
				//comprobar si hay cuenta activa:
				if(cuenta != null) {
					indicarCantidad();
					cantidad = leerDouble();
					cuenta.ingresarDinero(cantidad);				
					cuenta.consultarSaldo();
				} else {
					System.out.println("No hay ninguna cuenta activa.");
				}
				break;
				
			case 3://retirar dinero
				if(cuenta == null) {
					System.out.println("No hay ninguna cuenta activa.");
				}else {
					indicarCantidad();
				cantidad = leerDouble();
				cuenta.retirarDinero(cantidad);
				cuenta.consultarSaldo();
				}
				break;
				
			case 4: //consultar saldo
				//comprobar si hay cuenta activa
				if(cuenta == null) {
					System.out.println("No hay ninguna cuenta activa.");
				}else {
					//mostrar nuevo saldo
					System.out.println("El saldo actual es: " + cuenta.consultarSaldo());
					break;
				}
						
				case 0:
					System.exit(0);
					break;
				default:
					System.out.println("Opción no válida.");
						}
				}while(opcion != 0);
		
			if(opcionSubmenu == 0) {
				menuPrincipal();
			}
	}

	private static void indicarCantidad() {
		System.out.println("Indique la cantidad: ");
		
	}
	
	private static void crearCuenta() {
		if(opcionSubmenu == 1) {
			cuenta = new CuentaNormal(saldoInicial);
		} else if(opcionSubmenu == 2) {
			cuenta = new CuentaPremium(saldoInicial);
		}
		
		System.err.println(cuenta);
		
	}

	private static double leerDouble() {
		return scaner.nextDouble();
	}

	private static void pedirSaldoInicial() {
		System.out.println("Indique el saldo inicial: ");
		
	}

	private static void pedirOpcionSubmenu() {
		System.out.println("Elija una opción: ");
		
	}

	private static void submenu() {
		System.out.println("Tipo de cuenta\r\n"
				+ "1. Cuenta normal\r\n"
				+ "2. Cuenta Premium\r\n"
				+ "0. Cancelar");
		
	}

	private static int leerInt() {
		return scaner.nextInt();
	}

	private static void pedirOpcionUsuario() {
		System.out.println("Elija una opción: ");
		
	}

	private static void menuPrincipal() {
		System.out.println("BANCO \r\n"
				+ "1. Crear cuenta \r\n"
				+ "2. Ingresar dinero \r\n"
				+ "3. Retirar dinero \r\n"
				+ "4. Consultar saldo \r\n"
				+ "0. Salir");
		
	}

}
