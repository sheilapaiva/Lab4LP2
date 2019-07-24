package lab4;

import java.util.Scanner;

public class Main {
	
	/**
	* Objeto Scanner.
	*/
	private static Scanner sc;
	/**
	* Objeto de controle de alunos.
	*/
	static ControleAlunos ca = new ControleAlunos();

	/**
	* Exibe o menu com as opções do sistema de controle de alunos.
	*/
	public static void menu() {
		System.out.println("CONTROLE DE ALUNOS");
		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistrar Aluno que Respondeu");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!");
		System.out.print("\nOpção> ");
	}
	
	/**
	* Retorna a um String que representa se o cadastro de um novo aluno foi realizado ou não. 
	* A representação tem o seguinte formato, se o aluno ainda não está cadastrado no sistema,
	* o cadastro é realizado e é retornado a mensagem "CADASTRO REALIZADO!". Mas se caso o aluno
	* já esteja cadastrado no sistema retorna a mensagem "MATRÍCULA JÁ CADASTRADA!".
	*/
	public static String cadastrarAluno() {		
		System.out.print("\nMatrícula: ");
		String matricula = sc.nextLine();
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Curso: ");
		String curso = sc.nextLine();
		
		if (ca.cadastrarAluno(matricula, nome, curso)) {
			return "CADASTRO REALIZADO!\n";
		}
		return "MATRÍCULA JÁ CADASTRADA!\n";		
	}
	
	/**
	* Retorna a um String que representa um aluno, caso a sua matricula esteja cadastrada no
	* sistema. Se o aluno estiver cadastrado é retornada a mensagem com os dados do aluno, 
	* “Aluno: matricula - nome - curso”. Caso o aluno não esteja cadastrado retorna a mensagem
	* "Aluno não cadastrado."
	*/
	public static String exibirAluno() {
		System.out.print("\nMatrícula: ");
		String matricula = sc.nextLine();
		
		if (ca.consultarAluno(matricula)) {
			return ca.exibirAluno(matricula);
		}
		return "Aluno não cadastrado.\n";
	}
	
	/**
	* Retorna a um String que representa se um novo grupo foi cadastrado no sistema ou não.
	* Se o novo grupo foi cadastrado é retornado a mensagem "CADASTRO REALIZADO!", mas caso
	* o cadastro não seja realizado pois o grupo já está cadastrado é retornado a mensagem
	* "GRUPO JÁ CADASTRADO!".
	*/
	public static String novoGrupo() {
		System.out.print("\nGrupo: ");
		String nomeGrupo = sc.nextLine();
		
		if (ca.cadastrarGrupo(nomeGrupo)) {
			return "CADASTRO REALIZADO!\n";
		}
		return "GRUPO JÁ CADASTRADO!\n";
	}
	
	/**
	* Retorna a um String que representa se um aluno foi alocado em um grupo. É verificado
	* se o aluno está cadastrado no sistema, caso não esteja é retornado a mensagem "Aluno não cadastrado.".
	* Se o grupo não está cadastrado é retornado a mensagem "Grupo não cadastrado.". Mas se
	* ambos estão cadastrados o aluno é alocado no grupo e é retornado a mensagem "ALUNO ALOCADO!".
	*/
	public static String alocarAlunoGrupo() {
		String mensagem = "";
		System.out.print("\nMatrícula: ");
		String matricula = sc.nextLine();
		System.out.print("Grupo: ");
		String nomeGrupo = sc.nextLine();
		
		if ((ca.consultarAluno(matricula)) && (ca.consultarGrupo(nomeGrupo))) {
			ca.alocarAlunosGrupos(matricula, nomeGrupo);
			mensagem = "ALUNO ALOCADO!\n";
		}
		if (!ca.consultarAluno(matricula)) {
			mensagem += "Aluno não cadastrado.\n";
		}
		if (!ca.consultarGrupo(nomeGrupo)) {
			mensagem += "Grupo não cadastrado.\n";
		}
		return mensagem;
	}
	
	/**
	* Retorna a um String que representa os alunos que estão alocados em um determinado grupo.
	* Se o grupo informado não estiver cadastrado no sistema é retornado a mensagem "Grupo não cadastrado.".
	* Se o grupo for cadastrado é retornado a mensagem que representa os alunos cadastrados no grupo
	* a mensagem tem o seguinte formato:
	* “Aluno do grupo nomeGrupo:
	* * matricula - nome - curso
	* ...
	* * matricula - nome - curso"
	*/
	public static String imprimirAlunosGrupo() {
		System.out.print("\nGrupo: ");
		String nomeGrupo = sc.nextLine();
		
		if (ca.consultarGrupo(nomeGrupo)) {
			return ca.imprimirAlunosGrupo(nomeGrupo);
		}
		return "Grupo não cadastrado.\n";
	}
	
	/**
	* Retorna a um String que representa o retorno da opção escolhida. Se a opção for "A", 
	* então retorna a mensagem de alocarAlunoGrupo(), se a opção for "I" retorna a mensagem 
	* de imprimirAlunosGrupo(), mas caso a opção seja diferentes dessas duas é retornado a 
	* mensagem "OPÇÃO INVÁLIDA!".
	*/
	public static String alocarImprimir() {
		String op = sc.nextLine();
		
		if (op.equals("A")) {
			return alocarAlunoGrupo();
		}else if (op.equals("I")) {
			return imprimirAlunosGrupo();
		}
		return "OPÇÃO INVÁLIDA!\n";
	}
	
	/**
	* Retorna a um String que representa se o aluno foi ou não cadastrado na lista dos alunos 
	* responderam as questões no quadro. Se o aluno que a matricula é passada estiver cadastrado
	* no sistema então a mensagem retornada é "ALUNO REGISTRADO!". Se o aluno não estiver 
	* cadastrado a mensagem de retorno é "Aluno não cadastrado."
	*/
	public static String cadastrarAlunosQueResponderam() {
		System.out.print("\nMatrícula: ");
		String matricula = sc.nextLine();
		
		if (ca.cadastrarAlunosQueResponderamQuestoes(matricula)) {
			return "ALUNO REGISTRADO!\n";
		}
		return "Aluno não cadastrado.\n";
	}
	
	/**
	* Retorna a um String que representa os alunos que estão registrados na lista de alunos
	* que resolveram os exercicios no quadro. a mensagem segue o seguinte formato:
	* “Aluno:
	* 1. matricula - nome - curso
	* ...
	* i. matricula - nome - curso"
	*/
	public static String imprimirAlunosQueResponderam() {
		return ca.imprimirAlunosQueResponderam();
	}
	
	/**
	* Retorna a um boolean que representa se o menu do Controle de Alunos continua sendo exibido
	* ou não. Se a opção for "O", é retornado a false e o menu não é mais exibido. Se as opções 
	* forem: "C", "E", "N", "A", "R", "I", é executado a opção desejada retorna a true e o menu 
	* volta a ser mostrado, caso a opção seja diferente disso, é exibida a mensagem 
	* "OPÇÃO INVÁLIDA!" retorna a true e o menu continua a ser mostrado.
	*/
	public static boolean opcao() {
		sc = new Scanner(System.in);
		menu();
		String opcao = sc.nextLine();
			
		if (opcao.equals("C")) {
			System.out.println(cadastrarAluno());
			return true;
		}else if(opcao.equals("E")) {
			System.out.println(exibirAluno());
			return true;
		}else if(opcao.equals("N")) {
			System.out.println(novoGrupo());
			sc.nextLine();
			return true;
		}else if(opcao.equals("A")) {
			System.out.println("(A)locar Aluno ou (I)mprimir Grupo? ");
			System.out.println(alocarImprimir());
			return true;
		}else if(opcao.equals("R")) {
			System.out.println(cadastrarAlunosQueResponderam());
			return true;
		}else if(opcao.equals("I")) {
			System.out.println(imprimirAlunosQueResponderam());
			return true;
		}else if(opcao.equals("O")) {
			return false;
		}else {
			System.out.println("OPÇÃO INVÁLIDA!\n");
			return true;
		}
	}

	public static void main(String[] args) {
		do {
			opcao();
		}while (opcao() == true);
		sc.close();
	}
}
