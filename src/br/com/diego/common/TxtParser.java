package br.com.diego.common;

import java.util.ArrayList;

import br.com.diego.Dependente;
import br.com.diego.Funcionario;
import br.com.diego.FuncionarioConcursado;
import br.com.diego.FuncionarioTemporario;

public class TxtParser {
	
	public static ArrayList<Funcionario> parserFuncionarios(String filePath) {
		ArrayList<String> content = TxtReader.readFile(filePath);
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		for(String line : content) {
			String[] parts = line.split(";");
			String tipo = parts[0];
			Integer codigo = Integer.valueOf(parts[1]);
			Integer tempo = Integer.valueOf(parts[2]);
			Double  salario = Double.valueOf(parts[3]);
			
			if(tipo.trim().equals("concursado")) {
				FuncionarioConcursado fc = new FuncionarioConcursado(codigo, salario, tempo);
				funcionarios.add(fc);
			}
			else if (tipo.trim().equals("temporario")) {
				FuncionarioTemporario ft = new FuncionarioTemporario(codigo, salario, tempo);
				funcionarios.add(ft);
			}
		}
		return funcionarios;
	}
	
	public static ArrayList<Funcionario> dependentes(String funcionariosPath, String dependentesPath){
		ArrayList<String> dependentesString = TxtReader.readFile(dependentesPath);
		ArrayList<Funcionario> funcionarios = TxtParser.parserFuncionarios(funcionariosPath);
		
		if(dependentesString.isEmpty()) {
			return funcionarios;
		}
		
		for(String line : dependentesString) {
			String[] parts = line.split(";");
			Integer codigoFuncionario = Integer.valueOf(parts[0]);
			
			Integer idade = Integer.valueOf(parts[1]);	
			Dependente dependente = new Dependente(idade);
			for(Funcionario fun : funcionarios) {
				if(fun.getCodigo().equals(codigoFuncionario)) {
					fun.AddDependente(dependente);
				}
			}
		}
		
		return funcionarios;
	}
}
