package gsb.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Localite;
import gsb.modele.dao.LocaliteDao;

public class LocaliteDaoTest {

Localite uneLocalite;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	public final static void testRechercherReussi() {
		assertNotNull(LocaliteDao.rechercher("13012"));
	}
	
	@Test
	public final static void testRechercherEchoue() {
		assertNull(LocaliteDao.rechercher("0000"));
	}
}
