package controller;

import java.util.concurrent.Semaphore;

public class Banco {
	public static Conta contas[] = new Conta[5];
	
	public Semaphore semaforoSaque = new Semaphore(1);
	public Semaphore semaforoDeposito = new Semaphore(1);
	
	public void geraContas() {
		for(int i = 0; i < 5; i++) {
			int valorInicial = 500 /*+ (50 * i)*/;
			Conta conta = new Conta(i, valorInicial);
			contas[i] = conta;
		}
	}
	
	public void geraTransacoes() {
		for(int i = 0; i < 20; i++) {
			int conta = (int) (Math.random() * 5);
			int valor = (int) ((Math.random() * 301) + 100);
			int codTransacao = (int) ((Math.random() * 2) + 1);
			
			Transacoes transacao = new Transacoes(codTransacao, valor, conta, semaforoSaque, semaforoDeposito);
			transacao.start();
		}
	}
}
