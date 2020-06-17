package br.com.diego;

import java.util.ArrayList;

import br.com.diego.common.TxtParser;

public class FolhaPagamento {
	
	// passo 1
	protected ArrayList<Funcionario> funcionarios;
	
	FolhaPagamento(ArrayList<Funcionario> funcionarios){
		this.funcionarios = funcionarios;
	}
	
	protected Double calculaTotal() {
//		Double total = 0.0;
//		for(Funcionario f: this.funcionarios) {
//			total += f.calculaValorMensal();
//		}
//		return total;
		
		return funcionarios.stream().map((f) -> f.calculaValorMensal()).reduce(Double::sum).orElse(0.0).doubleValue();
	}
	
	protected void imprimeFuncionarios() {
		funcionarios.forEach((funcionario)->{ funcionario.imprime();});
	}
	
	public static void main(String[] args) {
		ArrayList<Funcionario> funcionarios = TxtParser.dependentes(
				"src/br/com/diego/common/funcionarios.txt", 
				"src/br/com/diego/common/dependentes.txt"
		);
		FolhaPagamento folha = new FolhaPagamento(funcionarios);
		
		// passo 2
		Double salarioTotal = folha.calculaTotal();
		System.out.println(String.format("Total folha de pagamento: %.2f", salarioTotal));
		
		// passo 3
		folha.imprimeFuncionarios();
	}

}
