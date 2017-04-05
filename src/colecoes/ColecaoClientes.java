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
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import classes.*;

@SuppressWarnings({ "serial", "unused" })
public class ColecaoClientes implements Serializable {
	
	ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
	
	Set<Conta> tabeladeContas = new HashSet<Conta>();
	
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
	public void RemovePeloCPF(){
		System.out.println("Cpf: ");
		String cpf = Leitura.LeNome();
		if(Clientes.isEmpty()){
			System.out.println("A lista de cliente está vazia");
		}
		for(Cliente c: Clientes){
			if(c.getCpf().equals(cpf)){
				Clientes.remove(c);
			}
		}
	}
	
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
	
	public int geraNumeroConta(){
		Random rand = new Random();
		Integer num = rand.nextInt(tabeladeContas.size());
		if(tabeladeContas.contains(num)){
			geraNumeroConta();
		}
		return num;
	}
	
	public void AlteraDadosCliente(){
		
	}
	public void Salvar(){
		try {
			FileOutputStream arq = new FileOutputStream("clientes.dat");
			ObjectOutputStream inClientes = new ObjectOutputStream(arq);
			
			inClientes.writeObject(Clientes);
			
			System.out.println("Lista de cliente salva!");
			inClientes.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao tentar criar arquivo");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("resource")
	public void ListarClientesSalvos(){
		
		try {
			FileInputStream in = new FileInputStream("clientes");
			ObjectInputStream objIn = new ObjectInputStream(in);
			
			ColecaoClientes clientes = (ColecaoClientes)objIn.readObject();
			
			System.out.println(clientes);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

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
	public Cliente confirmaConta(Integer numero){
		Cliente cliente = null;
		for(Cliente c: Clientes){
			Integer num = c.getConta().getNumero();
			if((num.equals(numero))){
				System.out.println("Digite a senha da conta: ");
				String senha = Leitura.LeNome();
				if(c.getConta().getSenha().equals(senha)){
					cliente = c;
				}else{
					System.out.println("Senha incorreta");
					cliente = null;
				}
			}			
		}
		return cliente;
	}
}
