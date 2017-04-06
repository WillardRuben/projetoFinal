package colecoes;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import classes.Endereco;
import classes.Funcionario;
import classes.FuncionarioFixo;
import classes.FuncionarioTerceirizado;
import classes.Leitura;
import jdk.nashorn.internal.ir.LexicalContextNode;

/*Nesta classe é adicionado o funcionario a colecão, é necessário escolher entre 2 tipos de funcionários(fixo ou terceirizado) na hora de
 *adicionar a coleção.**/
@SuppressWarnings({ "unused", "serial" })
public class ColecaoFuncionarios implements Serializable {
	ArrayList<Funcionario> Funcionarios = new ArrayList<Funcionario>();
	Scanner teclado = new Scanner(System.in);
	/**Método que é utilizado para adicionar um funcionario a lista*/
	public void AdicionaFuncionario(){
		System.out.println("Para adicionar um funcionario fixo digite  1");
		System.out.println("Para adicionar um funcionario terceirizado 2");
		System.out.print("op: ");
		int escolha = Leitura.leInteiroPositivo();
		
		while((escolha != 1)&&(escolha != 2)){
			System.out.println("Digite 1 ou 2!!!");
			escolha = Leitura.leInteiroPositivo();
		}
		if(escolha == 1){
			System.out.println("Nome: ");
			String nome = Leitura.LeNome();
			System.out.println("Cpf: ");
			String cpf = Leitura.LeNome();
			System.out.println("Data de Nascimento: ");
			LocalDate nascimento = Leitura.LeData();
			System.out.println("Telefone: ");
			String telefone = Leitura.LeNome();
			Endereco endereco = Leitura.criaEndereco();
			System.out.println("Funçao: ");
			String funcao = Leitura.LeNome();
			System.out.println("Matrícula: ");
			String matricula = Leitura.LeNome();
			System.out.println("Salário: ");
			Double salario = Leitura.LeDouble();
			FuncionarioFixo fx = new FuncionarioFixo(nome,cpf,endereco,nascimento,telefone,salario, funcao,matricula,"sim");
			Funcionarios.add(fx);
			System.out.println("Adicionado Funcionario Fixo!!!");
		}
		if(escolha == 2){
			
			System.out.println("Nome: ");
			String nome = Leitura.LeNome();
			System.out.println("Cpf: ");
			String cpf = Leitura.LeNome();
			System.out.println("Data de Nascimento: ");
			LocalDate nascimento = Leitura.LeData();
			System.out.println("Telefone: ");
			String telefone = Leitura.LeNome();
			Endereco endereco = Leitura.criaEndereco();
			System.out.println("Funçao: ");
			String funcao = Leitura.LeNome();
			System.out.println("Matrícula: ");
			String matricula = Leitura.LeNome();
			System.out.println("Salário: ");
			Double salario = Leitura.LeDouble();
			FuncionarioTerceirizado ft = new FuncionarioTerceirizado(nome, cpf, endereco, nascimento, telefone, salario, funcao, matricula, "não");
			Funcionarios.add(ft);
		}
	}
	
	/**Método utilizado para pesquisar um funcionario na lista */
	public void PesquisaPelaMatricula(){
		System.out.println("Matricula: ");
		String matricula = Leitura.LeNome();		
		for(Funcionario f: Funcionarios){
			if(f.getMatricula().equals(matricula)){
				System.out.println(f);
			}
		}
	}
	/**Método utilizado para remover um funcionario pela matricula*/
	public void RemovePelaMatricula(){
		System.out.println("Matricula: ");
		String matricula=Leitura.LeNome();
		for(Funcionario f: Funcionarios){
			if(f.getMatricula().equals(matricula)){
				Funcionarios.remove(f);
				System.out.println("Usuário removido");
			}
		}
	}
	/**Método utilizado para salvar a lista de funcionários num arquivo*/
	public void SalvarColecaoFuncionarios(){
		try {
			FileOutputStream arq = new FileOutputStream("funcionarios.dat");
			ObjectOutputStream out = new ObjectOutputStream(arq);
			out.writeObject(Funcionarios);
			System.out.println("Lista de funcionários Salva");
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**Método utilizado para listar os funcionários salvos no arquivo*/
	public void ListarFuncionarios(){
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("funcionarios.dat"));
			Object f = in.readObject();
			System.out.println(f);
			in.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
