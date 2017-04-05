package classes;

@SuppressWarnings("serial")
public class FuncionarioTerceirizado extends Funcionario {
	
	public FuncionarioTerceirizado(String funcao,String matricula,Double salario){
		this.funcao = funcao;
		this.matricula = matricula;
		this.salario = salario;
		this.permanencia = "Não";
	}
	
	public double CalculaSalario(){
		return 0;
	}
}
