package br.com.diego;

public class FuncionarioTemporario extends Funcionario {
	protected Double gratificacao  = 15.0;
	protected Integer mesesContratacao;
	
	public FuncionarioTemporario(Integer codigo, Double salarioBase, Integer mesesContratacao) {
		super(codigo, salarioBase);
		this.mesesContratacao = mesesContratacao;
	}

	@Override
	public Double calculaValorMensal() {
		Double acrescimo = getNumeroDependentesValidos(18) * 50.0;
		return salarioBase + (gratificacao * mesesContratacao) + acrescimo;
	}
	
	@Override
	public void imprime() {
		super.imprime();
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		return String.format(" [Dependentes v�lidos: %d], [%d meses de contrata��o]", 
			this.getNumeroDependentesValidos(18),
			this.mesesContratacao
		);
	}
}
