package controller;

import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;

public class Transacoes extends Thread{
	private int codTransacao;
	private double valor;
	private int idConta;
	
	public Semaphore semaforoSaque;
	public Semaphore semaforoDeposito;
	
	public Transacoes(int codTransacao, double valor, int idConta,Semaphore semaforoSaque, Semaphore semaforoDeposito) {
		this.codTransacao = codTransacao;
		this.valor = valor;
		this.idConta = idConta;
		this.semaforoSaque = semaforoSaque;
		this.semaforoDeposito = semaforoDeposito;
	}
	
	public void run() {
		if(codTransacao == 1) {
			try {
				semaforoSaque.acquire();
				sacar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforoSaque.release();
			}
		} else
		if(codTransacao == 2) {
			try {
				semaforoDeposito.acquire();
				depositar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforoDeposito.release();
			}
		}
	}
	
	public void sacar() {
		Conta conta = identificarConta();
		
		if(conta.getSaldo() < valor) {
			System.out.println("Saldo insuficiente para o saque de R$" + valor + " (Conta #" + idConta + ")\n");
		}else {
			conta.alteraSaldo(-valor);
			System.out.println("R$" + valor + " sacados com sucesso da Conta #" + idConta + "\nValor atual: R$" + conta.getSaldo()+"\n");
		}
	}
	
	public void depositar() {
		Conta conta = identificarConta();
		conta.alteraSaldo(valor);
		System.out.println("R$" + valor + " depositados com sucesso na Conta #" + idConta + "\nValor atual: R$" + conta.getSaldo()+"\n");
	}
	
	public Conta identificarConta() {
		Conta conta = new Conta();
		boolean achou = false;
		
		for(int i = 0; i < Banco.contas.length; i++) {
			if(Banco.contas[i].getId() == idConta) {
				conta = Banco.contas[i];
				achou = true;
				break;
			}
		}
		
		if(achou) {
			return conta;
		} else {
			JOptionPane.showMessageDialog(null, "ID de conta não encontrado", "ERRO", JOptionPane.ERROR_MESSAGE);
			System.out.println("ID de conta não encontrado");
			return null;
		}
	}
}
