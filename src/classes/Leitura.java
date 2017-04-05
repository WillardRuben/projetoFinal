package classes;

import colecoes.*;
import javafx.util.converter.LocalDateStringConverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import classes.*;

public class Leitura {

	
	public static String LeNome(){
		Scanner in = new Scanner(System.in);
		String nome = in.nextLine();
		return nome;
	}
	
	public static int leInteiroPositivo(){
		Scanner in = new Scanner(System.in);
		System.out.print("Digite um inteiro positivo: ");
		int r=0;
		do{
			while(!in.hasNextInt()){
				in.nextLine();
				System.out.print("Tipo de dado inválido. Digite um inteiro: ");
			}
			r = in.nextInt();
			in.nextLine();
			if(r<=0){
				System.out.println("Digite um inteiro maior que 0: ");
			}
		}while(r<=0);
		
		return r;
	}
	
	public static Double LeDouble(){
		Scanner in = new Scanner(System.in);
		while(!in.hasNextDouble()){
			in.nextLine();
			System.out.print("Tipo de dado invalido. Digite um double: ");
		}
		double r = in.nextDouble();
		in.nextLine();
		return r;
	}
	
	public static LocalDate LeData(){
		LocalDate dateRetorna = null;
		Scanner teclado = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

		System.out.println("Data(dia/mes/ano): ");
		String data = teclado.nextLine();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		try{
			LocalDate date = LocalDate.parse(data, formatter);
			dateRetorna = date;
		}catch (Exception e) {
			System.out.println();
		}
		return dateRetorna;
			
	}
	
	public static Endereco criaEndereco(){
		Scanner teclado = new Scanner(System.in);
		System.out.println("Nome da rua: ");
		String nomerua = LeNome();
		System.out.println("Numero da casa: ");
		int num = leInteiroPositivo();
		System.out.println("Complemento: ");
		String complemento = LeNome();
		System.out.println("Cep: ");
		String cep = teclado.nextLine();
		Endereco end = new Endereco(nomerua, num, complemento, cep); 
		
		return end;
	}
	public static void menu(){
		System.out.println("--------------------");
		System.out.println("--------Banco-------");
		System.out.println("--------------------");
		System.out.println("--------------------");
		System.out.println("-------Clientes-----");
		System.out.println("1- Adicionar Cliente");
		System.out.println("2- Pesquisar cliente por CPF");
		System.out.println("3- Listar todos os clientes salvos");
		System.out.println("4- Lista de Clientes cadastrados nessa sessão");
		System.out.println("5- Alterar dados de um cliente");
		System.out.println("6- Excluir Cliente");
		System.out.println("7- Acessar Conta");
		System.out.println("---------------------");
		System.out.println("-----Funcionarios----");
		System.out.println("8- Cadastrar Funcionário");
		System.out.println("9- Pesquisar funcionario pela matricula");
		System.out.println("10- Alterar dados de Funcionário");
		System.out.println("11- Listar todos os funcionarios");		
	}
	public static void menuCliente(Cliente c,ColecaoClientes clientes){
		System.out.println("-----Operações-----");
		System.out.println("1- Consultar Saldo ");
		System.out.println("2- Saque");
		System.out.println("3- Transferência");
		System.out.println("4- Depósito");
		
		int parada = 1 ;
		Scanner teclado = new Scanner(System.in);
		do{
			menu();
			System.out.println("Digite uma opção: ");
			int opcao = teclado.nextInt();
			switch(opcao){
				case 1:
					System.out.println("O saldo da conta é "+c.getConta().getSaldo());
					break;
				case 2:
					System.out.println("Valor: ");
					Double valorSaque = LeDouble();
					try{
						c.getConta().getMovimentacoes().saque(c, valorSaque);
					}catch (Exception erroSaque) {
						System.out.println("Erro ao tentar fazer o saque");
					}
					break;
				case 3:
					System.out.println("Digite o numero da conta do destinatário: ");
					Integer numero = leInteiroPositivo();
					Cliente clienteDestino = clientes.pesquisaPelaConta(numero);
					if(!(clienteDestino.equals(null))){
						System.out.println("Valor a ser transferido: ");
						Double valorTransferencia = LeDouble();
						try{
							c.getConta().getMovimentacoes().transferencia(c, clienteDestino,valorTransferencia);
						}catch (Exception erroTranferencia) {
							System.out.println("Erro ao tentar fazer transferencia");
						}
					}
					break;
				case 4:
					System.out.println("Valor a ser depositado: ");
					Double valorDeposito = LeDouble();
					try{
						c.getConta().getMovimentacoes().deposito(c, valorDeposito);
					}catch (Exception erroDeposito) {
						System.out.println("Erro ao tentar fazer depósito");
					}
					break;
				default:
					System.out.println("Digite uma opção válida");
			}
			System.out.println("1 para continuar e 0 para sair: ");
			parada = teclado.nextInt();
			teclado.nextLine();
			
			while(parada!=1&&parada!=0){
				System.out.println("opção inválida digite novamente: ");
				parada = teclado.nextInt();
			}
			if(parada==0&&parada!=1){
				break;
			}
			
		}while(parada==1);
		
		teclado.close();
	}
	public static void escolha(){
		int parada = 1 ;
		Scanner teclado = new Scanner(System.in);
		ColecaoClientes clientes = new ColecaoClientes();
		ColecaoFuncionarios funcionarios = new ColecaoFuncionarios();
		do{
			menu();
			System.out.println("Digite uma opção: ");
			int opcao = teclado.nextInt();
			switch(opcao){
				case 1:	 
					try{
						clientes.AdicionaCliente();
					}catch (Exception erro_ao_adicionar_cliente) {
						System.out.println("Erro ao adicionar cliente");
					}
					break;
				case 2:
					clientes.PesquisaClientePeloCPF();
					break;
				case 3:
					clientes.ListarClientes();
					break;
				case 4:
					clientes.ListarClientes();
					break;
				case 5:
					clientes.AlteraDadosCliente();
					break;
				case 6:
					clientes.RemovePeloCPF();
					break;
				case 7: 
					System.out.println("Digite o número da conta: ");
					Integer numero = leInteiroPositivo();
					Cliente c;
					c = clientes.confirmaConta(numero);
					if(!(c.equals(null))){
						menuCliente(c,clientes);
					}else{
						System.out.println("Cliente não encontrado");
					}
					break;
				case 8:
					funcionarios.AdicionaFuncionario();
					break;
				case 9:
					funcionarios.PesquisaPelaMatricula();
					break;
				case 10:
					funcionarios.AlteraDadosPelaMatricula();
					break;
				case 11:
					funcionarios.ListarFuncionarios();
					break;
				default:
					System.out.println("Digite uma opção válida");
			}
			
			System.out.println("1 para continuar e 0 para sair: ");
			parada = teclado.nextInt();
			teclado.nextLine();
			
			while(parada!=1&&parada!=0){
				System.out.println("opção inválida digite novamente: ");
				parada = teclado.nextInt();
			}
			if(parada==0&&parada!=1){
				break;
			}
			
		}while(parada==1);
		
		teclado.close();
	}

}

