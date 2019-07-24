package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab4.Aluno;

class TesteAluno {
	
	Aluno aluno1;
	Aluno aluno2;
	Aluno aluno3;

	@BeforeEach
	void setUP() {
		aluno1 = new Aluno("100", "Jose", "Computação");
		aluno2 = new Aluno("111", "João", "E. Elétrica");
		aluno3 = new Aluno("100", "Jose", "Computação");
	}
	
	@Test
	void testAluno() {
		assertEquals("100", aluno1.getMatricula());
		assertEquals("Jose", aluno1.getNome());
		assertEquals("Computação", aluno1.getCurso());
	}

	@Test
	void testEquals1Object() {
		assertEquals(aluno1, aluno3);
	}
	
	@Test
	void testEquals2Object() {
		assertNotEquals(aluno1, aluno2);
	}
	
	@Test
	void testToString() {
		assertEquals(aluno1.toString(), "100 - Jose - Computação");
	}

}
