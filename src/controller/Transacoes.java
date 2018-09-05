package controller;

import javax.swing.JOptionPane;

public class Transacoes extends Thread{
	private static boolean sacando = false;
	private static boolean depositando = false;
	private int codTransacao;
	private double valor;
	private int idConta;	
	
	public Transacoes(int codTransacao, double valor, int idConta) {
		this.codTransacao = codTransacao;
		this.valor = valor;
		this.idConta = idConta;
	}
	
	public void run() {
		
	}
	
	public void sacar() {
		Conta conta = identificarConta();
		
		if(conta.getSaldo() < valor) {
			System.out.println("Saldo insuficiente para o saque de R$" + valor + " (Conta " + idConta + ")");
		}else {
			conta.alteraSaldo(-valor);
		}
	}
	
	public void depositar() {
		Conta conta = identificarConta();
		conta.alteraSaldo(valor);
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
