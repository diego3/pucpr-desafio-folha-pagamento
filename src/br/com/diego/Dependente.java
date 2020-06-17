package br.com.diego;

public class Dependente {
	protected Integer idade;
	
	public Dependente(Integer idade) {
		this.idade = idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public Integer getIdade() {
		return this.idade;
	}
	
	public Boolean isValid(Integer val) {
		return this.idade <= val;
	}
}
