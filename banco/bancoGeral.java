package banco;

import javax.swing.JOptionPane;

public class bancoGeral{
	String agencia;
	String conta;
	String senha;
	double saldo = 1000.00;
	
	public static void main(String[] args) {
		
		bancoGeral inicio;
		inicio = new bancoGeral();
		inicio.painelInicial();
	}
	
	public void painelInicial() {
		String agencia = JOptionPane.showInputDialog("Digite sua agência");
		String conta = JOptionPane.showInputDialog("Digite sua conta");
		
		if(agencia.equals("001") && conta.equals("002")) {
			String senha = JOptionPane.showInputDialog("Digite sua senha");
			if(senha.equals("123")) {
				acessoConcedido();
			}else {
				JOptionPane.showMessageDialog(null, "Senha incorreta");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Agência e/ou Conta incorretos");
		}
	}
	
	public void acessoConcedido() {
		String depSac = JOptionPane.showInputDialog("Olá! Seja bem-vindo"
				+ "\nSeu saldo é de "+saldo+""
				+ "\n1 - DEPOSITAR"
				+ "\n2 - SACAR");
		if(depSac.equals("1")) {
			depositar();
		}else{
			sacar();
		}
	}
	
	public void depositar() {
		String depositoValor = JOptionPane.showInputDialog("Saldo atual: "+saldo+""
				+ "\nDigite o valor a ser depositado");
		double valorDepositado = Double.parseDouble(depositoValor);
		saldo += valorDepositado;
		JOptionPane.showMessageDialog(null, "Deposito de "+valorDepositado+" feito com sucesso!");
		acessoConcedido();
	}
	public void sacar() {
		String saqueValor = JOptionPane.showInputDialog("Saldo atual: "+saldo+""
				+ "\nDigite o valor a ser sacado");
		double valorSaque = Double.parseDouble(saqueValor);
		if(valorSaque > saldo) {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente");
			sacar();
		}else {
			saldo -= valorSaque;
			JOptionPane.showMessageDialog(null, "Saque no valor de "+valorSaque+" realizado com sucesso!");
			acessoConcedido();
		}
	}
}