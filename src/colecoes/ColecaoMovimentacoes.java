package colecoes;

import java.util.ArrayList;

import classes.*;

public class ColecaoMovimentacoes {
	ArrayList<Movimentacao> Movimentacoes = new ArrayList<Movimentacao>();
	
	
	/*Neste método é depositado um valor à conta do cliente**/
	public void deposito(Cliente c, Double valor){
		Double saldoAnterior = c.getConta().getSaldo();
		Double saldoPosterior = saldoAnterior + valor;
		c.getConta().setSaldo(saldoPosterior);
		System.out.println("Depósito feito com sucesso!");
		System.out.println("Novo Saldo: "+c.getConta().getSaldo());
	}
/*Neste método é subtraído um determinado valor da conta do cliente**/	
	public void saque(Cliente c,Double valor){
		
		Double saldoAnterior = c.getConta().getSaldo();
		Double saldoPosterior = saldoAnterior - valor;
		c.getConta().setSaldo(saldoPosterior);
	}
	
	public void transferencia(Cliente a,Cliente b,Double valor){
		a.getConta().getMovimentacoes().saque(a, valor);
		b.getConta().getMovimentacoes().deposito(b, valor);	
	}
}
