package gsb.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Localite;

	class LocaliteTest {
		
		static Localite uneLocalite;
		
		@BeforeEach
		void setUp() throws Exception {
			uneLocalite = new Localite("codePostal", "ville");
		}

		@AfterEach
		void tearDown() throws Exception {
			
		}

		@Test
		public final static void getCpReussi() {
			assertEquals("codePostal", uneLocalite.getCodePostal());
		}
		
		@Test
		public final static void getCpEchoue() {
			assertEquals("", uneLocalite.getCodePostal());
		}
		
		@Test
		public final static void getVilleReussi() {
			assertEquals("ville", uneLocalite.getVille());
		}
		
		@Test
		public final static void getVilleEchoue() {
			assertEquals("", uneLocalite.getVille());
		}
		
		public final static void setCpReussi() {
			uneLocalite.setCodePostal("newCp");
			assertEquals("newCp", uneLocalite.getCodePostal());
		}
		
		public final static void setCpEchoue() {
			uneLocalite.setCodePostal("newCp");
			assertEquals("", uneLocalite.getCodePostal());
		}
		
		@Test
		public final static void setVilleReussi() {
			uneLocalite.setVille("newVille");
			assertEquals("newVille", uneLocalite.getVille());
		}
		
		@Test
		public final static void setVilleEchoue() {
			uneLocalite.setVille("newVille");
			assertEquals("", uneLocalite.getVille());
		}

}

