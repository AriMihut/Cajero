package cajero.prueba;

public class CuentaPremium extends CuentaBancaria{
	
	private double saldo;

	public CuentaPremium(double saldo) {
		super();
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "CuentaPremium [saldo=" + saldo + "]";
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public void ingresarDinero(double cantidad) {
		if(cantidad < 0) {
			System.out.println("La cantidad debe ser positiva.");
		}else {
			this.saldo = saldo + cantidad;
			System.out.println("El saldo de la cuenta premium es: " + saldo);
		}
	}

	@Override
	public void retirarDinero(double cantidad) {
		if(cantidad < 0) {
			System.out.println("La cantidad debe ser positiva.");
		}else {
			this.saldo = saldo - cantidad;
			System.out.println("El saldo actual de la cuenta premium es: " + saldo);
		}
	}

	@Override
	public double consultarSaldo() {
		return saldo;
	}

}
