package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab4.GrupoEstudos;

class TesteGrupoEstudos {
	
	GrupoEstudos grupo1;
	GrupoEstudos grupo2;
	GrupoEstudos grupo3;

	@BeforeEach
	void setUP() {
		grupo1 = new GrupoEstudos("Calculo");
		grupo2 = new GrupoEstudos("Listas");
		grupo3 = new GrupoEstudos("Calculo");
	}
	
	@Test
	void testGrupoEstudos() {
		assertEquals("Calculo", grupo1.getNomeGrupo());
	}

	@Test
	void testEquals1Object() {
		assertEquals(grupo1, grupo3);
	}
	
	@Test
	void testEquals2Object() {
		assertNotEquals(grupo1, grupo2);
	}

}
