package classes;

import java.io.Serializable;
import java.time.LocalDate;

public class Cliente extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Conta conta;
	
	public Cliente(String nome, String cpf, Endereco endereco, LocalDate nascimento, String telefone, Conta conta){
		super(nome, cpf, endereco, nascimento, telefone);
		this.conta = conta;
	}

	public Conta getConta() {
		return conta;
	}

}
