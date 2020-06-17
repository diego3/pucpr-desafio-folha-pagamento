package br.com.diego;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Funcionario {
	
	protected Integer codigo;
	protected Double  salarioBase;
	
	protected ArrayList<Dependente> dependentes;
	
	Funcionario(Integer codigo, Double salarioBase){
		this.codigo = codigo;
		this.salarioBase = salarioBase;
		dependentes = new ArrayList<>();
	}
	
	public Double calculaValorMensal() {
		
		return 0.0;
	}
	
	public Integer getNumeroDependentesValidos(Integer idadeLimite) {
		Integer total = 0;
		for(Dependente dep : this.dependentes) {
			if(dep.isValid(idadeLimite)) {
				total++;
			}
		}
		return total;
	}
	
	public ArrayList<Dependente> getDependentes(){
		return this.dependentes;
	}
	
	public void AddDependente(Dependente dependente) {
		this.dependentes.add(dependente);
	}
	
	public void imprime() {
		String toString = String.format("[Codigo:%d] [Salário:%.2f] [Dependentes: %d] [valor mensal: %.2f]", 
				this.codigo, 
				this.salarioBase.floatValue(),
				this.dependentes.size(),
				this.calculaValorMensal().floatValue());
		System.out.println("********");
		System.out.print(toString);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}
	
//	@Override
//	public String toString() {
//		return String.format("Codigo:%d Salário:%.2f Dependentes: %d", 
//				this.codigo, 
//				this.salarioBase.floatValue(),
//				this.dependentes.size()
//		);
//	}
	
}
