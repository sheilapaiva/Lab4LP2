package lab4;

/**
 * Representação de um Aluno. Um Aluno é representado por uma matrícula, nome e curso.
 * 
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 *
 */
public class Aluno {
	
	/**
	* Matrícula do aluno.
	*/
	private String matricula;
	/**
	* Nome do aluno.
	*/
	private String nome;
	/**
	* Curso do aluno.
	*/
	private String curso;
	
	/**
	* Constrói um aluno, a partir da sua matrícula, nome e curso.
	* 
	* @param matricula, a matricula do aluno
	* @param nome, o nome do aluno
	* @param curso, o curso do aluno
	*/
	public Aluno(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	/**
	* Retorna uma String que representa a matricula do aluno.
	* 
	* @return a uma String que representa a matricula.
	* */
	public String getMatricula() {
		return matricula;
	}

	/**
	* Seta uma String que representa a matricula do aluno.
	* 
	* @param matricula, a matricula do aluno.
	* */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	* Retorna uma String que representa o nome do aluno.
	* 
	* @return a uma String que representa o nome.
	* */
	public String getNome() {
		return nome;
	}

	/**
	* Seta uma String que representa o nome do aluno.
	* 
	* @param nome, o nome do aluno.
	* */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	* Retorna uma String que representa o curso do aluno.
	* 
	* @return a uma String que representa o curso.
	* */
	public String getCurso() {
		return curso;
	}

	/**
	* Seta uma String que representa o curso do aluno.
	* 
	* @param curso, o curso do aluno.
	* */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	* Retorna a um inteiro referente uma representação númerica do objeto.
	* 
	* @return a um valor inteiro que representa o objeto.
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	* Retorna a um boolean referente a comparação de um novo objeto Aluno a ser 
	* criado com os outros Alunos já existentes, um aluno é igual ao outro se as 
	* suas matriculas são iguais.
	* 
	* @return a um boolean.
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/**
	* Retorna a String que representa a matricula, nome e curso do aluno. 
	* A representação segue o formato “matricula - nome - curso”.
	* 
	* @return a representação em String da matricula, nome e curso do aluno.
	*/
	@Override
	public String toString() {
		return this.matricula + " - " + this.nome  + " - " + this.curso;
	}
}
