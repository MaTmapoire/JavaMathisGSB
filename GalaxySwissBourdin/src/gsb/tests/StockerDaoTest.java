package gsb.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.dao.StockerDao;

public class StockerDaoTest {

	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	public final static void testRechercherReussi() {
		assertNotNull(StockerDao.rechercher("1"));
	}
	
	@Test
	public final static void testRechercherEchoue() {
		assertNull(StockerDao.rechercher("0000"));
	}

}
