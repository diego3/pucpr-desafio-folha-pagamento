package br.com.diego.common;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import br.com.diego.Funcionario;
import br.com.diego.FuncionarioConcursado;
import br.com.diego.FuncionarioTemporario;
import br.com.diego.Dependente;


public class KeyboardReader implements FuncionarioReaderInterface {
	private Scanner keyboard;
	private int maximoDependentes;
	private int maximoFuncionarios;
	
	private final int INTEGER = 1;
	private final int DOUBLE  = 2;
	private final int STRING  = 3;
	
	public KeyboardReader(int numeroMaximoDependentes, int numeroMaximoFuncionarios) {
		keyboard = new Scanner(System.in);
		this.maximoDependentes = numeroMaximoDependentes;
		this.maximoFuncionarios = numeroMaximoFuncionarios;
	}
	
	/**
	 * Cria uma lista de funcionários a partir do input stream do teclado
	 * 
	 * @return ArrayList<Funcionario>
	 */
	public ArrayList<Funcionario> read() {
		System.out.println("------ Cadastro de funcionários ------");
		
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		
		boolean cadastrando = true;
		while(cadastrando && funcionarios.size() <= maximoFuncionarios) {
			String tipoFuncionario = readTipoFuncionario("Qual o tipo do funcionário? (T/C)");
			Integer codigo = readInteger("Digite o código do funcionário:");
			Double salarioBase = readDouble("Digite o salário base do funcionário:");
			Integer tempoContratacao = readInteger(String.format("Digite a quantidade de %s de contratação deste funcionário:", tipoFuncionario.contentEquals("T") ? "meses" : "anos"));
			
			Funcionario funcionario = new FuncionarioTemporario(codigo, salarioBase, tempoContratacao);
			if(tipoFuncionario.equals("C")) {
				 funcionario = new FuncionarioConcursado(codigo, salarioBase, tempoContratacao);
			}
			
			readDependentes(funcionario);
			funcionarios.add(funcionario);
			System.out.println("Funcionário cadastrado com sucesso");
			if(readString("Cadastrar próximo funcionário? (S/N)").toUpperCase().equals("N")) {
				cadastrando = false;
			}
		}
		
		keyboard.close();
		return funcionarios;
	}
	
	private void readDependentes(Funcionario funcionario) {
		if(readString("Cadastrar dependentes?(S/N)").toUpperCase().equals("S")) {
			while(true) {
				if(funcionario.getDependentes().size() == maximoDependentes) {
					System.err.println(String.format("Permitido cadastrar somente %d dependentes por funcionário", maximoDependentes));
					break;
				}
				funcionario.AddDependente(new Dependente(readInteger("Digite a idade do dependente:")));
				
				System.out.println("Dependente cadastrado com sucesso");
				if(readString("Cadastrar próximo dependente?(S/N").toUpperCase().equals("N")) {
					break;
				}
			}
		}
	}
	
	private Object read(String message, int dataType) {
		while(true) {
			System.out.println(message);
			switch(dataType) {
				case INTEGER:
					Integer codigo = 0;
					try {
						codigo = keyboard.nextInt();
						keyboard.nextLine();
					} catch(InputMismatchException e) {
						System.err.println("Incorreto, deve ser um número inteiro.");
						keyboard.nextLine();
						continue;
					}
					
					if(codigo < 0) {
						System.err.println("valor inválido");
						continue;
					} else {
						return codigo;
					}
				case DOUBLE:
					Double valor = 0.0;
					try {
						valor = keyboard.nextDouble();
						keyboard.nextLine();
					} catch(InputMismatchException e) {
						System.err.println("Incorreto, deve ser um número real");
						keyboard.nextLine();
						continue;
					}
					
					if(valor < 0) {
						System.err.println("Valor inválido");
						continue;
					} else {
						return valor;
					}
				case STRING:
					String valors = keyboard.next();
					keyboard.nextLine();
					if(valors.isEmpty()) {
						System.err.println("Valor inválido");
						continue;
					} else {
						return valors;
					}
			}	
		}
	}
	
	private Integer readInteger(String message) {
		Integer valor = (Integer)this.read(message, INTEGER);
		return valor;
	}
	
	private Double readDouble(String message) {
		return (Double) this.read(message, DOUBLE);
	}
	
	private String readString(String message) {
		return (String)this.read(message, STRING);
	}
	
	private String readTipoFuncionario(String message) {
		while(true) {
			String tipo = readString(message);
			if(tipo.toUpperCase().equals("T") || tipo.toUpperCase().equals("C")) {
				return tipo;
			}
			else {
				System.err.println("Incorreto, digite T ou C");
				System.err.println("T = Temporário, C = Concursado");
				continue;
			}
		}
	}
}
