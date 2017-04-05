package classes;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Funcionario implements Serializable {
	
	/**Atributos de funcionário*/
	protected Double salario;
	protected String funcao;
	protected String matricula;
	protected String permanencia;
	
	public Double getSalario() {
		return salario;
	}
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public String getFuncao() {
		return funcao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public abstract double CalculaSalario();	

}
