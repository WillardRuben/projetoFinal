package classes;

import colecoes.*;

public class Conta {
	
	private Integer numero;
	private String senha;
	private Double saldo;
	private ColecaoMovimentacoes movimentacoes;
	
	public Conta(int numero,String senha){
		this.numero = numero;
		this.senha = senha;
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
