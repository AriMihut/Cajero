package cajero.prueba;

public class CuentaNormal extends CuentaBancaria{
	
	private double saldo;
	
	public CuentaNormal(double saldoInicial) {
		super();
		System.err.println("Saldo inicial: " + saldoInicial);
		this.saldo = saldoInicial;
	}

	@Override
	public String toString() {
		return "CuentaNormal [saldo=" + this.saldo + "]";
	}

	@Override
	public void ingresarDinero(double cantidad) {
		if(cantidad < 0) {
			System.out.println("La cantidad debe ser positiva.");
		}else {
		saldo = saldo + cantidad;//saldo aquí es el saldoInicial + cantidad
		System.out.println(saldo);
		}
	}

	@Override
	public void retirarDinero(double cantidad) {
		if(cantidad < 0) {
			System.out.println("La cantidad debe ser positiva.");
		}else {
			saldo = saldo - cantidad;//saldo aquí es el saldoInicial + cantidad
			System.out.println(saldo);
		}
	}

	@Override
	public double consultarSaldo() {
		return saldo;
	}

}
