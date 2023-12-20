package gsb.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.dao.OffrirDao;

	class OffrirDaoTest {
		
		
		@BeforeEach
		void setUp() throws Exception {
			
		}

		@AfterEach
		void tearDown() throws Exception {
			
		}

		@Test
		public final static void testRechercherReussi() {
			assertNotNull(OffrirDao.rechercher("123"));
		}
		
		@Test
		public final static void testRechercherEchoue() {
			assertNull(OffrirDao.rechercher("0000"));
		}

}
