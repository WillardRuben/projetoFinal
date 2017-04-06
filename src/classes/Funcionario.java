package classes;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public abstract class Funcionario extends Pessoa implements Serializable{
	
	/**Atributos de funcionário*/
	protected double salario;
	protected String funcao;
	protected String matricula;
	protected String permanencia;
	
	/**Construtor*/
	public Funcionario(String nome, String cpf, Endereco endereco, LocalDate nascimento, String telefone, double salario, String funcao, String matricula, String permanencia) {
		super(nome, cpf, endereco, nascimento, telefone);
		this.salario = salario;
		this.funcao = funcao;
		this.matricula = matricula;
		this.permanencia = permanencia;
	}

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

	@Override
	public String toString() {
		return "-----Funcionario----- "+
				"\nSalario: " + salario + 
				"\nFuncao: " + funcao + 
				"\nMatricula: " + matricula + 
				"\nPermanencia: "+ permanencia + 
				"\nNome: " + getNome() + 
				"\nCpf: " + getCpf() + 
				"\nEndereço: "+ getEndereco() + 
				"\nData de nascimento: " + getNascimento() + ", getTelefone()=" + getTelefone();
	}
	
	

}
