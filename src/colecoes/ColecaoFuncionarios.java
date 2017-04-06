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

/*Nesta classe � adicionado o funcionario a colec�o, � necess�rio escolher entre 2 tipos de funcion�rios(fixo ou terceirizado) na hora de
 *adicionar a cole��o.**/
@SuppressWarnings({ "unused", "serial" })
public class ColecaoFuncionarios implements Serializable {
	ArrayList<Funcionario> Funcionarios = new ArrayList<Funcionario>();
	Scanner teclado = new Scanner(System.in);
	/**M�todo que � utilizado para adicionar um funcionario a lista*/
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
			System.out.println("Fun�ao: ");
			String funcao = Leitura.LeNome();
			System.out.println("Matr�cula: ");
			String matricula = Leitura.LeNome();
			System.out.println("Sal�rio: ");
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
			System.out.println("Fun�ao: ");
			String funcao = Leitura.LeNome();
			System.out.println("Matr�cula: ");
			String matricula = Leitura.LeNome();
			System.out.println("Sal�rio: ");
			Double salario = Leitura.LeDouble();
			FuncionarioTerceirizado ft = new FuncionarioTerceirizado(nome, cpf, endereco, nascimento, telefone, salario, funcao, matricula, "n�o");
			Funcionarios.add(ft);
		}
	}
	
	/**M�todo utilizado para pesquisar um funcionario na lista */
	public void PesquisaPelaMatricula(){
		System.out.println("Matricula: ");
		String matricula = Leitura.LeNome();		
		for(Funcionario f: Funcionarios){
			if(f.getMatricula().equals(matricula)){
				System.out.println(f);
			}
		}
	}
	/**M�todo utilizado para remover um funcionario pela matricula*/
	public void RemovePelaMatricula(){
		System.out.println("Matricula: ");
		String matricula=Leitura.LeNome();
		for(Funcionario f: Funcionarios){
			if(f.getMatricula().equals(matricula)){
				Funcionarios.remove(f);
				System.out.println("Usu�rio removido");
			}
		}
	}
	/**M�todo utilizado para salvar a lista de funcion�rios num arquivo*/
	public void SalvarColecaoFuncionarios(){
		try {
			FileOutputStream arq = new FileOutputStream("funcionarios.dat");
			ObjectOutputStream out = new ObjectOutputStream(arq);
			out.writeObject(Funcionarios);
			System.out.println("Lista de funcion�rios Salva");
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**M�todo utilizado para listar os funcion�rios salvos no arquivo*/
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
