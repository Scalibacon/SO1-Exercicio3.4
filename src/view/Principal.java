package view;

import controller.Banco;

public class Principal {

	public static void main(String[] args) {
		Banco banco = new Banco();
		banco.geraContas();
		banco.geraTransacoes();
	}

}
