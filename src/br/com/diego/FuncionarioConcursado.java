package br.com.diego;

public class FuncionarioConcursado extends Funcionario {
	
	protected Double gratificacao = 200.0;
	protected Integer anosContratacao;
	
	public FuncionarioConcursado(Integer codigo, Double salarioBase, Integer anosContratacao) {
		super(codigo, salarioBase);
		this.anosContratacao = anosContratacao;
	}

	@Override
	public Double calculaValorMensal() {
		Double acrescimo = this.getNumeroDependentesValidos(21) * 100.0;
		return salarioBase + (gratificacao * anosContratacao) + acrescimo;
	}

	@Override
	public void imprime() {
		super.imprime();
		System.out.println(this.toString());
	}
	
	public Integer getAnosContratacao() {
		return anosContratacao;
	}
	
	@Override
	public String toString() {
		return String.format(" [Dependentes válidos: %d], [%d anos de contratação]", 
			this.getNumeroDependentesValidos(21),
			this.anosContratacao
		);
	}
}
