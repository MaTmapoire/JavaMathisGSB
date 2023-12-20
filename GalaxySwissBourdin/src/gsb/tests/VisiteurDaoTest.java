package gsb.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Localite;
import gsb.modele.Visiteur;
import gsb.modele.dao.LocaliteDao;
import gsb.modele.dao.VisiteurDao;

class VisiteurDaoTest {
	Visiteur unVisiteurTest;
	Localite uneLocTest;
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		if (VisiteurDao.rechercher("test") == unVisiteurTest) {
			VisiteurDao.supprimer("test");
		}
		if (LocaliteDao.rechercher("cp") == uneLocTest) {
			LocaliteDao.supprimer("cp");
		}
	}
	
	@Test
	public final static void testRechercherReussi() {
		assertNotNull(VisiteurDao.rechercher("a17"));
	}
	
	@Test
	public final static void testRechercherEchoue() {
		assertNull(VisiteurDao.rechercher("test"));
	}
	
	@Test
	public final static void testCreerReussi() {
		Localite uneLocTest = new Localite("cp", "ville");
		Visiteur unVisiteurTest = new Visiteur("test", "nom", "prenom", "login", "mdp", "adresse", uneLocTest, "telephone", null, 0, "codeUnite", "nomUnite");
		assertEquals(1, VisiteurDao.creer(unVisiteurTest));
	}
	
	@Test
	public final static void testCreerEchoue() {
		assertEquals(0, VisiteurDao.creer(VisiteurDao.rechercher("a17")));
	}


}
