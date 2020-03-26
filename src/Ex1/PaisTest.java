package Ex1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;

import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

class PaisTest {
	Pais pais, copia;
	static int id = 1;

	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("\nSetup");
		pais = new Pais(id, "India", 128193591, 3287590.00);
		copia = new Pais(id, "India", 128193591, 3287590.00);
		System.out.println(pais);
		System.out.println(copia);
	}
	
	@Test
	public void test01Criar() {
		System.out.println("Criar");
		pais.criar();
		id = pais.getId();
		System.out.println(id);
		copia.setId(id);
		System.out.println("\n--------------------------");
		assertEquals("testa criacao", pais.toString(), copia.toString());
	}

	@Test
	public void test02Carregar() {
		System.out.println("Carregar");
		Pais fixture = new Pais(2,"Brasil",210147125,8515767.0);
		Pais novo = new Pais(2, null, 0, 0);
		novo.carregar();
		System.out.print(novo);
		System.out.print("\n" + fixture);
		System.out.println("\n--------------------------");
		assertEquals(fixture.toString(),novo.toString());
	}

	@Test
	public void test03Atualizar() {
		System.out.println("Atualizar");
		pais.setPopulacao(999999);
		copia.setPopulacao(999999);
		pais.atualizar();
		pais.carregar();
		System.out.print(pais);
		System.out.print("\n" + copia);
		System.out.println("\n--------------------------");
		assertEquals("testa atualizacao", pais.toString(), copia.toString());
	}

	@Test
	public void test04Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0);
		pais.excluir();
		pais.carregar();
		System.out.println(copia);
		System.out.println(pais);
		System.out.println("--------------------------");
		assertEquals("testa exclusao", pais.toString(), copia.toString());
	}	

	@Test
	void test05MaiorPopulacao() {
		pais.maiorpopulacao();
		System.out.println("Maior Populacao");
		System.out.print("China");
		System.out.print("\n" + pais.getMaiorPop());
		System.out.println("\n--------------------------");
		assertEquals("Testa Maior populacao","China", pais.getMaiorPop());

	}


	@Test
	void test06MenorArea() {
		pais.MenorArea();
		System.out.println("Menor Area");
		System.out.print("India");
		System.out.print("\n" + pais.getMenorArea());
		System.out.println("\n--------------------------");
		assertEquals("Testa menor Area: ","India", pais.getMenorArea());
	}

}
