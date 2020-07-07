package br.com.diego.common;

public class FuncionarioReaderFactory {
	
	
	public static FuncionarioReaderInterface createKeyboardReader(Integer numeroMaximoDependentes, Integer numeroMaximoFuncionarios) {
		return new KeyboardReader(numeroMaximoDependentes, numeroMaximoFuncionarios);
	}
	
	public static FuncionarioReaderInterface createTextFileReader(Integer numeroMaximoDependentes) {
		return () -> {
			return TxtParser.parse(
					"src/br/com/diego/common/funcionarios.txt", 
					"src/br/com/diego/common/dependentes.txt",
					numeroMaximoDependentes
			);
		};
	}

}
