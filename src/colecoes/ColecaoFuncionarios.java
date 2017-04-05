package colecoes;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import classes.Funcionario;
import classes.FuncionarioFixo;
import classes.FuncionarioTerceirizado;
import classes.Leitura;
import jdk.nashorn.internal.ir.LexicalContextNode;

/*Neste m�todo � adicionado o funcionario a colec�o, � necess�rio escolher entre 2 tipos de funcion�rios(fixo ou terceirizado) na hora de
 *adicionar a cole��o.**/
@SuppressWarnings({ "unused", "serial" })
public class ColecaoFuncionarios implements Serializable {
	ArrayList<Funcionario> Funcionarios = new ArrayList<Funcionario>();
	Scanner teclado = new Scanner(System.in);
	
	public void AdicionaFuncionario(){
		System.out.println("Para adicionar um funcionario fixo digite  1");
		System.out.println("Para adicionar um funcionario terceirizado 2");
		System.out.print("op: ");
		int escolha = Leitura.leInteiroPositivo();
		
		while((!(escolha == 1))||(!(escolha == 2))){
			System.out.println("Digite 1 ou 2!!!");
		}
		if(escolha == 1){
			System.out.println("Fun�ao: ");
			String funcao = Leitura.LeNome();
			System.out.println("Matr�cula: ");
			String matricula = Leitura.LeNome();
			System.out.println("Sal�rio: ");
			Double salario = Leitura.LeDouble();
			FuncionarioFixo fx = new FuncionarioFixo(funcao, matricula, salario);
			Funcionarios.add(fx);
			System.out.println("Adicionado Funcionario Fixo!!!");
		}
		if(escolha == 2){
			System.out.println("Fun�ao: ");
			String funcao = Leitura.LeNome();
			System.out.println("Matricula: ");
			String matricula = Leitura.LeNome();
			System.out.println("Sal�rio: ");
			Double salario = Leitura.LeDouble();
			FuncionarioTerceirizado ft = new FuncionarioTerceirizado(funcao, matricula, salario);
			Funcionarios.add(ft);
		}
	}
	
	public Funcionario PesquisaPelaMatricula(){
		return null;
	}
	
	public void RemovePelaMatricula(){
		
	}
	
	public void AlteraDadosPelaMatricula(){
		
	}
	public double ConsultaSalario(){
		return 0.0;
	}	
	public void SalvarColecaoFuncionarios(){
		try {
			FileOutputStream arq = new FileOutputStream("funcionarios.dat");
			ObjectOutputStream out = new ObjectOutputStream(arq);
			out.writeObject(Funcionarios);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void ListarFuncionarios(){
		try {
			ColecaoFuncionarios f = new ColecaoFuncionarios();
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("funcionarios.dat"));
			f = (ColecaoFuncionarios) in.readObject();
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
