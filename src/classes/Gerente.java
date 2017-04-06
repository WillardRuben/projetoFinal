package classes;

import java.time.LocalDate;

@SuppressWarnings("serial")
public class Gerente extends FuncionarioFixo {

	/*Construtor**/
	public Gerente(String nome, String cpf, Endereco endereco, LocalDate nascimento, String telefone, double salario,
			String funcao, String matricula, String permanencia) {
		super(nome, cpf, endereco, nascimento, telefone, salario, funcao, matricula, permanencia);
	}
	/*Metodo que calcula o salario do gerente**/
	public double calculaSalario(){
		return 10*salario;
	}

}
