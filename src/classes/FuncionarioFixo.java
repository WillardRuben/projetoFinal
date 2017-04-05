package classes;

@SuppressWarnings("serial")

public class FuncionarioFixo extends Funcionario {

	public FuncionarioFixo(String funcao,String matricula,Double salario){
		this.funcao = funcao;
		this.matricula = matricula;
		this.salario = salario;
		this.permanencia = "Sim";
	}
	
	public double CalculaSalario(){
		return 0;
	}

}
