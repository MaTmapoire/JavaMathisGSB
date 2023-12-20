package gsb.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.*;
import gsb.modele.dao.*;

class MedecinDaoTest {

	Medecin unMedTest;
	@BeforeEach
	void setUp() throws Exception {
		 
		}

	@AfterEach
	void tearDown() throws Exception {
		if (MedecinDao.rechercher("test") == unMedTest) {
            MedecinDao.supprimer("test");
		}
	}

	@Test
	public final static void testRechercherReussi() {
		assertNotNull(MedecinDao.rechercher("m001"));
	}
	
	@Test
	public final static void testRechercherEchoue() {
		assertNull(MedecinDao.rechercher("m000"));
	}

	@Test
	public final static void testCreeReussi(){
		Localite uneLocTest = new Localite("cp", "ville");
		Medecin unMedTest = new Medecin("test","nom","prenom","adresse",uneLocTest,"telephone","potentiel","specialite");
	
		assertEquals(1,MedecinDao.creer(unMedTest));
	}
	
	public final static void testCreeEchoue() {
		assertEquals(0,MedecinDao.creer(MedecinDao.rechercher("m001")));
	}

}
