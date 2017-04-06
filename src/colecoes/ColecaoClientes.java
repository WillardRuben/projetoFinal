package colecoes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import classes.*;

@SuppressWarnings({ "serial", "unused" })
public class ColecaoClientes implements Serializable {
	
	ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
	
	/*Método usado para adicionar cliente**/
	public void AdicionaCliente(){
		System.out.println("Nome do cliente: ");
		String nome = Leitura.LeNome();
		System.out.println("Cpf: ");
		String cpf = Leitura.LeNome();
		System.out.println("Data de nascimento: ");
		LocalDate nascimento = Leitura.LeData();
		System.out.println("Telefone: ");
		String telefone = Leitura.LeNome();
		System.out.println("Digite uma senha: ");
		String senha = Leitura.LeNome();
		Conta conta = new Conta(geraNumeroConta(), senha);
		Endereco endereco = Leitura.criaEndereco();
		Cliente c = new Cliente(nome, cpf, endereco, nascimento, telefone, conta);
		Clientes.add(c);
	}
	/**Utilizado para remover cliente pelo CPF*/
	public void RemovePeloCPF(){
		System.out.println("Cpf: ");
		String cpf = Leitura.LeNome();
		if(Clientes.isEmpty()){
			System.out.println("A lista de cliente está vazia");
		}
		for(Cliente c: Clientes){
			if(c.getCpf().equals(cpf)){
				try {
					Clientes.remove(c);
				} catch (ConcurrentModificationException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**Método utilizado para pesquisar cliente pelo CPF*/
	public Cliente PesquisaClientePeloCPF(){
		Cliente cretorno=null;
		System.out.println("Cpf: ");
		String cpf = Leitura.LeNome();
		if(Clientes.isEmpty()){
			System.out.println("A lista de clientes está vazia");
		}
		for(Cliente c: Clientes){
			if(c.getCpf().equals(cpf)){
				cretorno = c;
			}
		}
		return cretorno;
	}
	/**Método utilizado para gera número da conta do cliente*/
	public int geraNumeroConta(){
		Random numero = new Random();
        int conta = 1 + numero.nextInt(9999);
        return conta;
	}
	/**Método utilizado para salvar a lista de clientes*/
	
	public void Salvar(){
		try {
		
			FileOutputStream arq = new FileOutputStream("clientes.dat");
			ObjectOutputStream inClientes = new ObjectOutputStream(arq);
			
			inClientes.writeObject(this.Clientes);
			
			System.out.println("Lista de cliente salva!");
			inClientes.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao tentar criar arquivo");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**Metodo utilizado para listar os clientes salvos no arquivo*/
	@SuppressWarnings("resource")
	public void ListarClientesSalvos(){
		
		try {
			FileInputStream in = new FileInputStream("clientes.dat");
			ObjectInputStream objIn = new ObjectInputStream(in);
			
			Object clientes = objIn.readObject();
			
			System.out.println(clientes);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ClassCastException e){
			e.printStackTrace();
		}
		
		
	}

	/**Pesquisa o cliente pelo cpf*/
	public Cliente pesquisaPelaConta(int numeroConta) {
		Cliente cliente = null;
		
		for(Cliente c: Clientes){
			int num = c.getConta().getNumero();
			if(num == numeroConta){
				cliente = c;
			}else{
				System.out.println("Cliente não encontrado");
				return null;
			}
		}
		return cliente;
	}
	/**Associa a conta digitada a um dos cliente que está na lista*/
	public Cliente confirmaConta(int numero){
		Cliente cliente = null;
		for(Cliente c: Clientes){
			int num = c.getConta().getNumero();
			if((num==numero)){
				System.out.println("Digite a senha da conta: ");
				String senha = Leitura.LeNome();
				if(c.getConta().getSenha().equals(senha)){
					cliente = c;
				}else{
					System.out.println("Cliente não encontrado");
				}
			}			
		}
		return cliente;
	}
}
