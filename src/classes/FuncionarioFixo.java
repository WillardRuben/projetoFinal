package classes;

import java.time.LocalDate;

@SuppressWarnings("serial")

public class FuncionarioFixo extends Funcionario {


	public FuncionarioFixo(String nome, String cpf, Endereco endereco, LocalDate nascimento, String telefone,
			double salario, String funcao, String matricula, String permanencia) {
		super(nome, cpf, endereco, nascimento, telefone, salario, funcao, matricula, permanencia);
	}

	public double CalculaSalario() {
		return 4*salario;
	}

}
