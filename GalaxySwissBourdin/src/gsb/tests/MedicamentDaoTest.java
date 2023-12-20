package gsb.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteurDao;

class MedicamentDaoTest {
	
	Medicament unMedTest;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		if (MedicamentDao.rechercher("test") == unMedTest) {
            MedicamentDao.supprimer("test");
		}
		
	}

	@Test
	public final static void testRechercherReussi() {
		assertNotNull(MedicamentDao.rechercher("TXISOL22"));
	}
	
	@Test
	public final static void testRechercherEchoue() {
		assertNull(VisiteurDao.rechercher("test2"));
	}
	
	@Test
	public final static void testCreerReussi() {
		Medicament unMedTest = new Medicament("test", "nomComercial", "composition", "effets", "contreIndication", 0, "codeFamille", "libelleFamille");
		assertEquals(1, MedicamentDao.creer(unMedTest));
	}
	
	@Test
	public final static void testCreerEchoue() {
		assertEquals(0, VisiteurDao.creer(VisiteurDao.rechercher("vent001")));
	}

}
