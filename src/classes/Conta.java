package classes;

import java.io.Serializable;

import colecoes.*;

@SuppressWarnings("serial")
public class Conta implements Serializable{
	
	private int numero;
	private String senha;
	private double saldo;
	private ColecaoMovimentacoes movimentacoes;
	
	public Conta(int numero,String senha){
		this.numero = numero;
		this.senha = senha;
	}
	

	@Override
	public String toString() {
		return "-----Conta----- "+ 
				"\nNumero=" + numero + 
				"\nSaldo=" + saldo + 
				"\nMovimentacoes=" + movimentacoes;
	}




	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public ColecaoMovimentacoes getMovimentacoes() {
		return movimentacoes;
	}
	public void setMovimentacoes(ColecaoMovimentacoes movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

}
