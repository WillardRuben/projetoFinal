package colecoes;

import java.util.ArrayList;

import classes.*;

public class ColecaoMovimentacoes {
	ArrayList<Movimentacao> Movimentacoes = new ArrayList<Movimentacao>();
	
	
	/**Neste m�todo � depositado um valor � conta do cliente*/
	public void deposito(Cliente c, double valor){
		double saldoAnterior = c.getConta().getSaldo();
		double saldoPosterior = saldoAnterior + valor;
		c.getConta().setSaldo(saldoPosterior);
		System.out.println("Dep�sito feito com sucesso!");
		System.out.println("Novo Saldo: "+c.getConta().getSaldo());
	}
	/**Neste m�todo � subtra�do um determinado valor da conta do cliente*/	
	public void saque(Cliente c,double valor){
		
		double saldoAnterior = c.getConta().getSaldo();
		double saldoPosterior = saldoAnterior - valor;
		c.getConta().setSaldo(saldoPosterior);
	}
	/**Neste m�todo � usado para fazer a transferencia de valores entre contas*/
	public void transferencia(Cliente a,Cliente b,double valor){
		a.getConta().getMovimentacoes().saque(a, valor);
		b.getConta().getMovimentacoes().deposito(b, valor);	
	}
}
