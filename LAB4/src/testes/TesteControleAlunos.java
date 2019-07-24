package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab4.ControleAlunos;

class TesteControleAlunos {
	
	ControleAlunos ca;
	
	@BeforeEach
	void setUP() {
		ca = new ControleAlunos();
		ca.cadastrarAluno("100", "Jose", "Computação");
		ca.cadastrarGrupo("Colecoes");
	}
	
	@Test
	void testConsultarAluno1() {
		assertEquals(ca.consultarAluno("100"), true);
	}
	
	@Test
	void testConsultarAluno2() {
		assertEquals(ca.consultarAluno("109"), false);
	}
	
	@Test
	void testarCadastrarAlunoMatriculaNula() {
		try {
			ca.cadastrarAluno(null, "Bruno", "Computação");
		}catch(NullPointerException mn) {
			assertEquals(mn.getMessage(), "CAMPO MATRÍCULA NULO.");
		}
	}
	
	@Test
	void testarCadastrarAlunoMatriculaVazia() {
		try {
			ca.cadastrarAluno(" ", "Bruno", "Computação");
		}catch(IllegalArgumentException mv) {
			assertEquals(mv.getMessage(), "CAMPO MATRÍCULA VAZIO");
		}
	}
	
	@Test
	void testarCadastrarAlunoNomeNulo() {
		try {
			ca.cadastrarAluno("112", null, "Computação");
		}catch(NullPointerException nn) {
			assertEquals(nn.getMessage(), "CAMPO NOME NULO.");
		}
	}
	
	@Test
	void testarCadastrarAlunoNomeVazio() {
		try {
			ca.cadastrarAluno("112", "", "Computação");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "CAMPO NOME VAZIO");
		}
	}
	
	@Test
	void testarCadastrarAlunoCursoNulo() {
		try {
			ca.cadastrarAluno("112", "Bruno", null);
		}catch(NullPointerException cn) {
			assertEquals(cn.getMessage(), "CAMPO CURSO NULO.");	
		}
	}
	
	@Test
	void testarCadastrarAlunoCursoVazio() {
		try {
			ca.cadastrarAluno("112", "Bruno", "    ");
		}catch(IllegalArgumentException cv) {
			assertEquals(cv.getMessage(), "CAMPO CURSO VAZIO");
		}
	}
	
	@Test
	void testCadastrarAlunoValido() {
		assertEquals(ca.cadastrarAluno("111", "João", "E. Elétrica"), true);
	}
	
	@Test
	void testCadastrarAlunoInvalido() {
		assertEquals(ca.cadastrarAluno("100", "Jose", "Computação"), false);
	}
	
	void testExibirAluno() {
		assertEquals(ca.exibirAluno("100"), "100 - Jose - Computação");
	}
	
	@Test
	void testConsultarGrupo1() {
		assertEquals(ca.consultarGrupo("Colecoes"), true);
	}
	
	@Test
	void testConsultarGrupo2() {
		assertEquals(ca.consultarGrupo("Calculo"), false);
	}
	
	@Test
	void testarCadastrarGrupoNomeNulo() {
		try {
			ca.cadastrarGrupo(null);
		}catch(NullPointerException nn) {
			assertEquals(nn.getMessage(), "CAMPO NOME DO GRUPO NULO.");
		}
	}
	
	@Test
	void testarCadastrarGrupoNomeVazio() {
		try {
			ca.cadastrarGrupo(" ");
		}catch(IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "CAMPO NOME DO GRUPO VAZIO");
		}
	}
	
	@Test
	void testCadastrarGrupoValido() {
		assertEquals(ca.cadastrarGrupo("Calculo"), true);
	}
	
	@Test
	void testCadastrarGrupoInvalido() {
		assertEquals(ca.cadastrarGrupo("Colecoes"), false);
	}
	
	void testAlocarAlunosGrupos1() {
		assertEquals(ca.alocarAlunosGrupos("100", "Colecoes"), true);
	}
	
	void testAlocarAlunosGrupos2() {
		assertEquals(ca.alocarAlunosGrupos("111", "Colecoes"), true);
	}
	
	void testImprimirAlunosGrupo() {
		assertEquals(ca.imprimirAlunosGrupo("Colecoes"), "\nAlunos do grupo Colecoes:\n* 100 - Jose - Computação\n* 111 - João - E. Elétrica");
	}
	
	void testCadastrarAlunosQueResponderamQuestoesValido1() {
		assertEquals(ca.cadastrarAlunosQueResponderamQuestoes("100"), true);
	}
	
	void testCadastrarAlunosQueResponderamQuestoesValido2() {
		assertEquals(ca.cadastrarAlunosQueResponderamQuestoes("111"), true);
	}
	
	void testCadastrarAlunosQueResponderamQuestoesInvalido() {
		assertEquals(ca.cadastrarAlunosQueResponderamQuestoes("109"), false);
	}
	
	void testImprimirAlunosQueResponderam() {
		assertEquals(ca.imprimirAlunosQueResponderam(), "\nAlunos:\n1. 100 - Jose - Computação\n2. 111 - João - E. Elétrica");
	}
}
