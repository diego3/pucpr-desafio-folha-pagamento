# pucpr-desafio-folha-pagamento

Reimplemente o programa feito na  e tapa 3 ,   tal que a classe  FolhaPagamento  passe a ter apenas um atributo para representar toda a coleção de funcionários. 
O tipo desse atributo deve ser alguma classe de biblioteca para a implementação de coleção de objetos, como  ArrayList , sendo o tipo de objeto da coleção  a superclasse  
Funcionario . Com isso, a coleção de objetos conterá tanto objetos da classe  FuncionarioConcursado   quanto  da classe  FuncionarioTemporario , todos juntos.    
Agora, no passo 2 do método  main , que calcula o valor mensal recebido por cada funcionário, deverá ser reimplementado como uma única iteração sobre a coleção de funcionários, 
chamando um método para o cálculo que esteja implementado na superclasse  Funcionario  como um m étodo que simplesmente retorne  o valor zero e esteja sobrescrito 
em cada uma das subclasses apropriadamente, conforme a regra d e  cálculo do valor mensal recebido para cada tipo de funcionário.    
Analogamente, no passo 3 do método  main ,   que imprime na saída padrão (tela) a relação de  n  funcionários com os correspondentes 
valores mensais recebidos, deverá haver apenas uma iteração sobre a coleção, chamando um método para impressão que esteja implementado na superclasse 
Funcionario  como um método que imprim a  todos os atributos genéricos do funcionário e esteja sobrescrito em cada uma das superclasses ,  
a fim de imprimir também os atributos específicos apropriadamente. Nes t e caso, a implementação do método de impressão da subclasse deve chamar a implementação da superclasse.    
Nes t a nova versão do programa, a saída impressa será diferente da saída obtida nas etapas anteriores ,  que divid i a a relação de funcionários em duas partes; 
os funcionários serão impressos de forma misturada.  
Você  construirá um programa orientado a objetos com  o  uso de herança entre classes e polimorfismo na implementação de coleções de objetos.   
Assim,  aprenderá a definir a versão genérica de um método e faze r sua sobrescrita em subclasses.  Observe  que, apesar de chamar o método  de  forma genérica , 
o ambiente de execução do programa encontra e executa  a versão específica  adequada.  

