package cajero.prueba;

public abstract class CuentaBancaria {
	
	public abstract void ingresarDinero(double cantidad);
	public abstract void retirarDinero(double cantidad);
	public abstract double consultarSaldo();
}
