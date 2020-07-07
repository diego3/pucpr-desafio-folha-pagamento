package br.com.diego;

import java.util.ArrayList;
import br.com.diego.common.FuncionarioReaderFactory;
import br.com.diego.common.FuncionarioReaderInterface;

public class FolhaPagamento {
	
	protected ArrayList<Funcionario> funcionarios;
	protected static int NUMERO_MAXIMO_DEPENDENTES = 5;
	protected static int NUMERO_MAXIMO_FUNCIONARIOS = 100;
	
	FolhaPagamento(ArrayList<Funcionario> funcionarios){
		this.funcionarios = funcionarios;
	}
	
	protected Double calculaTotal() {
		Double total = 0.0;
		for(Funcionario funcionario: funcionarios) {
			total += funcionario.calculaValorMensal();
		}
		return total;
	}
	
	protected void imprimeFuncionarios() {
		funcionarios.forEach((funcionario)->{ funcionario.imprime();});
	}
	
	public static void main(String[] args) {
		FuncionarioReaderInterface reader = FuncionarioReaderFactory.createKeyboardReader(NUMERO_MAXIMO_DEPENDENTES, NUMERO_MAXIMO_FUNCIONARIOS);
		//FuncionarioReaderInterface reader = FuncionarioReaderFactory.createTextFileReader(NUMERO_MAXIMO_DEPENDENTES);
		
		ArrayList<Funcionario> funcionarios = reader.read();
		FolhaPagamento folha = new FolhaPagamento(funcionarios);
		
		Double total = folha.calculaTotal();
		System.out.println(String.format("Total folha de pagamento: %.2f", total));
		
		folha.imprimeFuncionarios();
	}

}
