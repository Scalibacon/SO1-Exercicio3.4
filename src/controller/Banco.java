package controller;

import java.util.concurrent.Semaphore;

public class Banco {
	public static Conta contas[];
	
	public Semaphore semaforoSaque = new Semaphore(1);
	public Semaphore semaforoDeposito = new Semaphore(1);
	
	public void geraContas() {
		for(int i = 1; i <= 5; i++) {
			int valorInicial = 500 + (50 * i);
			Conta conta = new Conta(i, valorInicial);
			contas[i] = conta;
		}
	}
	
	public void geraTransacoes() {
		
	}
}
