package lab4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representação de um Controle de alunos, responsável por controlar e gerenciar alunos, 
 * grupos de estudos e alunos que resolveram questões no quadro. Manter o registro dos mesmos,
 * cadastra novos, exibe e listar os alunos pela matricula, listar os alunos por grupo e listar 
 * os alunos que resolveram as questões no quadro. 
 * 
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 *
 */
public class ControleAlunos {
	
	/**
	* Mapa de alunos.
	*/
	private HashMap<String, Aluno> mapAlunos;
	/**
	* Mapa de Grups de Estudos.
	*/
	private HashMap<String, GrupoEstudos> mapGrupoEstudos;
	/**
	* Lista de Alunos que resolveram exercicios.
	*/
	private ArrayList<Aluno> registroQuestoes;

	/**
	* Constrói um mapa de alunos, um mapa de grupos de estudos e um objeto Exercicios.
	*/
	public ControleAlunos() {
		this.mapAlunos = new HashMap<>();
		this.mapGrupoEstudos = new HashMap<>();
		this.registroQuestoes = new ArrayList<>();
	}
	
	/**
	* Retorna um Aluno que representa um aluno no mapa de alunos.
	* 
	* @return a mapAlunos que representa um aluno.
	* */
	public HashMap<String, Aluno> getMapAlunos() {
		return this.mapAlunos;
	}

	/**
	* Seta um Aluno que representa um aluno no mapa de alunos.
	* 
	* @param mapAlunos, um aluno do mapa de alunos.
	* */
	public void setMapAlunos(HashMap<String, Aluno> mapAlunos) {
		this.mapAlunos = mapAlunos;
	}

	/**
	* Retorna um GrupoEstudos que representa um grupo de estudos no mapa de grupos de estudos.
	* 
	* @return a mapGrupoEstudos que representa um grupo de estudos.
	* */
	public HashMap<String, GrupoEstudos> getMapGrupoEstudos() {
		return this.mapGrupoEstudos;
	}

	/**
	* Seta um GrupoEstudos que representa um Grupo de estudos no mapa de grupos.
	* 
	* @param mapGrupoEstudos, um grupo de estudos do mapa de grupos.
	* */
	public void setMapGrupoEstudos(HashMap<String, GrupoEstudos> mapGrupoEstudos) {
		this.mapGrupoEstudos = mapGrupoEstudos;
	}
	
	
	/**
	* Retorna a uma lista de alunos que resolveram exercicios.
	* 
	* @return a uma lista de Aluno.
	* */
	public ArrayList<Aluno> getRegistroQuestoes() {
		return registroQuestoes;
	}
	
	/**
	* Seta uma lista de Aluno que representa os alunos que resolveram exercicios.
	* 
	* @param registroQuestoes, um Aluno da lista de exercicios.
	* */
	public void setRegistroQuestoes(ArrayList<Aluno> registroQuestoes) {
		this.registroQuestoes = registroQuestoes;
	}
	
	/**
	* Consulta se um aluno já está contido no mapa de alunos.
	* 
	* @param matricula, a matricula do aluno chave no mapa de alunos
	*/
	public boolean consultarAluno(String matricula) {
		return this.mapAlunos.containsKey(matricula);
	}

	/**
	* Cadastra um novo aluno no mapa de alunos. A partir da matricula, nome e curso 
	* se esses campos estiverem preenchidos e não nulos. Usa a matricula como chave para o mapa.
	* 
	* @param matricula, a matricula do aluno
	* @param nome, o nome do aluno
	* @param curso, o curso do aluno
	* @throws campo matricula nulo, lança a exceção NullPointerException
	* @throws campo matricula vazio, lança a exceção IllegalArgumentException
	* @throws campo nome nulo, lança a exceção NullPointerException
	* @throws campo nome vazio, lança a exceção IllegalArgumentException
	* @throws campo curso nulo, lança a exceção NullPointerException
	* @throws campo curso vazio, lança a exceção IllegalArgumentException
	*/
	public boolean cadastrarAluno(String matricula, String nome, String curso) {
		if (matricula == null) {
			throw new NullPointerException("CAMPO MATRÍCULA NULO.");
		}else if ("".equals(matricula.trim())) {
			throw new IllegalArgumentException("CAMPO MATRÍCULA VAZIO");
		}else if (nome == null) {
			throw new NullPointerException("CAMPO NOME NULO.");
		}else if ("".equals(nome.trim())) {
			throw new IllegalArgumentException("CAMPO NOME VAZIO");
		}else if (curso == null) {
			throw new NullPointerException("CAMPO CURSO NULO.");
		}else if ("".equals(curso.trim())) {
		    throw new IllegalArgumentException("CAMPO CURSO VAZIO");
		}else {
			if (consultarAluno(matricula)) {
				return false;
			}else {
				Aluno novoAluno = new Aluno(matricula, nome, curso);
				this.mapAlunos.put(matricula, novoAluno);
				return true;
			}
		}
	}
	
	/**
	* Retorna a uma String que representa um aluno registrado com a matricula passada como
	* parâmetro no mapa de alunos. 
	* A representação segue o formato “Aluno: matricula - nome - curso”.
	* 
	* @param matricula, a matricula do aluno
	* @return a representação em String do aluno com a matricula passada no parâmetro.
	*/
	public String exibirAluno(String matricula) {
		return "\nAluno: " + this.mapAlunos.get(matricula).toString() + "\n";
	}
	
	/**
	* Consulta se um grupo já está contido no mapa de grupos.
	* 
	* @param nomeGrupo, o nome do grupo, chave no mapa de grupos
	*/
	public boolean consultarGrupo(String nomeGrupo) {
		return this.mapGrupoEstudos.containsKey(nomeGrupo.toLowerCase()); 
	}
	
	/**
	* Cadastra um novo grupo de estudos no mapa de grupos de estudos. 
	* A partir do nome do grupo, se esse campo estiver preenchido e não nulos. 
	* Usa a nome do grupo como chave para o mapa.
	* 
	* @param nomeGrupo, o nome do grupo de estudos
	* @throws campo nomeGrupo nulo, lança a exceção NullPointerException
	* @throws campo nomeGrupo vazio, lança a exceção IllegalArgumentException
	*/
	public boolean cadastrarGrupo(String nomeGrupo) {
		if (nomeGrupo == null) {
			throw new NullPointerException("CAMPO NOME DO GRUPO NULO.");
		}else if ("".equals(nomeGrupo.trim())) {
			throw new IllegalArgumentException("CAMPO NOME DO GRUPO VAZIO");
		}else {
			if (consultarGrupo(nomeGrupo)) {
				return false;
			}else {
				GrupoEstudos novoGrupo = new GrupoEstudos(nomeGrupo);
				this.mapGrupoEstudos.put(nomeGrupo.toLowerCase(), novoGrupo);
				return true;
			}
		}
	}

	/**
	* Aloca um aluno no grupo de estudos no mapa de grupos de estudos. 
	* A partir da matricula do aluno e do nome do grupo.
	* 
	* @param matricula, a matricula do aluno
	* @param nomeGrupo, o nome do grupo de estudos
	* @return retorna a um boolean
	*/
	public boolean alocarAlunosGrupos(String matricula, String nomeGrupo) {
		Aluno a = this.mapAlunos.get(matricula);
		this.mapGrupoEstudos.get(nomeGrupo.toLowerCase()).getAlunos().add(a);
		return true;
	}
	
	/**
	* Retorna a uma String que representa os alunos registrados em um determinado 
	* grupo de estudos, com o nome do grupo passado como parâmetro.
	* A representação segue o formato:
	* “Aluno do grupo nomeGrupo:
	* * matricula - nome - curso
	* ...
	* * matricula - nome - curso"
	* 
	* @param nomeGrupo, o nome do grupo
	* @return a representação em String dos aluno alocados no grupo.
	*/
	public String imprimirAlunosGrupo(String nomeGrupo) {
		GrupoEstudos g = this.mapGrupoEstudos.get(nomeGrupo.toLowerCase());
		String alunos = "\nAlunos do grupo " + g.getNomeGrupo() + ":\n";
		for (Aluno a : g.getAlunos()) {
			alunos += "* " + a.toString() + "\n";
		}
		return alunos;
	}
	
	/**
	* Cadastra um aluno que respondeu uma questão no quadro, na lista de registro de questoes,
	* a partir da matricula do aluno. Retorna a true se o aluno foi registrado e a false se o
	* aluno não foi registrado.
	* 
	* @param matricula, a matricula do aluno
	* @return retorna a um boolean
	*/
	public boolean cadastrarAlunosQueResponderamQuestoes(String matricula) {
		if (consultarAluno(matricula)) {
			Aluno a = this.mapAlunos.get(matricula);
			this.registroQuestoes.add(a);
			return true;
		}
		return false;
	}
	
	/**
	* Retorna a uma String que representa os alunos registrados na lista de alunos que 
	* resolveram questões no quadro. A representação segue o formato:
	* “Aluno:
	* 1. matricula - nome - curso
	* ...
	* i. matricula - nome - curso"
	* 
	* @return a representação em String dos aluno alocados no registro de questoes.
	*/
	public String imprimirAlunosQueResponderam() {
		String alunos = "\nAlunos:\n";
		for (int i = 0; i < this.registroQuestoes.size(); i++) {
			Aluno a = this.registroQuestoes.get(i);
			alunos += (i + 1) + ". " + a.toString() + "\n";
		}
		return alunos;
	}
}