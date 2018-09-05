package controller;

import java.util.concurrent.Semaphore;

public class Banco {
	public static Conta contas[];
	
	public Semaphore semaforoSaque = new Semaphore(1);
	public Semaphore semaforoDeposito = new Semaphore(1);
}
