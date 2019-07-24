package lab4;

import java.util.HashSet;

/**
 * Representação de um Grupo de Estudos. Um Grupo de Estudos é representado por um nome
 * e possui um conjunto de alunos.
 * 
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 *
 */
public class GrupoEstudos {
	
	/**
	* Nome do Grupo de Estudos.
	*/
	private String nomeGrupo;
	/**
	* Conjunto de alunos do Grupo de Estudos.
	*/
	private HashSet<Aluno> alunos;
	
	/**
	* Constrói um Grupo de Estudos, a partir do seu nome.
	* 
	* @param nomeGrupo, o nome do Grupo de Estudos
	*/
	public GrupoEstudos(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
		this.alunos = new HashSet<>();
	}

	/**
	* Retorna uma String que representa o nome Grupo de Estudos.
	* 
	* @return a uma String que representa o nome.
	* */
	public String getNomeGrupo() {
		return nomeGrupo;
	}

	/**
	* Seta uma String que representa o nome do Grupo de Estudos.
	* 
	* @param nomeGrupo, o nome Grupo de Estudos.
	* */
	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}
	
	/**
	* Retorna um Aluno que representa um aluno do Grupo de Estudos.
	* 
	* @return a uma Aluno que representa um aluno.
	* */
	public HashSet<Aluno> getAlunos() {
		return alunos;
	}

	/**
	* Seta um Aluno que representa um aluno do Grupo de Estudos.
	* 
	* @param aluno, um aluno do Grupo de Estudos.
	* */
	public void setAlunos(HashSet<Aluno> aluno) {
		this.alunos = aluno;
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
		result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
		return result;
	}

	/**
	* Retorna a um boolean referente a comparação de um novo objeto GrupoEstudos a ser 
	* criado com os outros GrupoEstudos já existentes, um GrupoEstudos é igual ao outro se os 
	* seus nomes são iguais.
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
		GrupoEstudos other = (GrupoEstudos) obj;
		if (nomeGrupo == null) {
			if (other.nomeGrupo != null)
				return false;
		} else if (!nomeGrupo.equals(other.nomeGrupo))
			return false;
		return true;
	}
}
