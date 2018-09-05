package controller;

public class Conta {
	private int id;
	private double saldo;
	
	public Conta(int id, int valor) {
		this.id = id;
		this.saldo = valor;
	}
	
	public Conta() {
		
	}
	
	public int getId() {
		return id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void alteraSaldo(double valor) {
		this.saldo += valor;
	}

	
	
	
	
	
}
