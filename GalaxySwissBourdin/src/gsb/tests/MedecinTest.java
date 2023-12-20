package gsb.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Localite;
import gsb.modele.Medecin;

	class MedecinTest {
		
		static Medecin unMedecin;
		static Localite uneLocalite;
		static Localite uneAutreLocalite;
		
		@BeforeEach
		void setUp() throws Exception {
			uneLocalite = new Localite("codePostal", "ville");
			unMedecin = new Medecin("codeMed", "nom", "prenom", "adresse",uneLocalite ,"telephone", "potentiel", "specialite");
		}

		@AfterEach
		void tearDown() throws Exception {
			
		}

		@Test
		public final static void getCodeMedReussi() {
			assertEquals("codeMed", unMedecin.getCodeMed());
		}
		public final static void getCodeMedEchoue() {
			assertEquals("", unMedecin.getCodeMed());
		}
		
		public final static void getNomReussi() {
			assertEquals("nom", unMedecin.getNom());
		}
		public final static void getNomEchoue() {
			assertEquals("", unMedecin.getNom());
		}
		
		public final static void getPrenomReussi() {
			assertEquals("prenom", unMedecin.getPrenom());
		}
		public final static void getPrenomEchoue() {
			assertEquals("", unMedecin.getNom());
		}
		
		public final static void getAdresseReussi() {
			assertEquals("adresse", unMedecin.getAdresse());
		}
		public final static void getAdresseEchoue() {
			assertEquals("", unMedecin.getAdresse());
		}
		
		public final static void getLocaliteReussi() {
			assertEquals(uneLocalite, unMedecin.getLaLocalite());
		}
		public final static void getLocaliteEchoue() {
			assertEquals(null, unMedecin.getLaLocalite());
		}
		
		public final static void getTelephoneReussi() {
			assertEquals("telephone", unMedecin.getTelephone());
		}
		public final static void getTelephoneEchoue() {
			assertEquals("", unMedecin.getTelephone());
		}
		
		public final static void getPotentielReussi() {
			assertEquals("potentiel", unMedecin.getPotentiel());
		}
		public final static void getPotentielEchoue() {
			assertEquals("", unMedecin.getPotentiel());
		}
		
		public final static void getSpecialiteReussi() {
			assertEquals("specialite", unMedecin.getSpecialite());
		}
		public final static void getSpecialiteEchoue() {
			assertEquals("", unMedecin.getSpecialite());
		}
		
		@Test
		public final static void setCodeMedReussi() {
			unMedecin.setCodeMed("newCodeMed");
			assertEquals("newCodeMed", unMedecin.getCodeMed());
		}
		public final static void setCodeMedEchoue() {
			unMedecin.setCodeMed("newCodeMed");
			assertEquals("codeMed", unMedecin.getCodeMed());
		}
		
		public final static void setNomReussi() {
			unMedecin.setNom("newNom");
			assertEquals("newNom", unMedecin.getNom());
		}
		public final static void setNomEchoue() {
			unMedecin.setNom("newNom");
			assertEquals("nom", unMedecin.getNom());
		}
		
		public final static void setPrenomReussi() {
			unMedecin.setPrenom("newPrenom");
			assertEquals("newPrenom", unMedecin.getPrenom());
		}
		public final static void setPrenomEchoue() {
			unMedecin.setPrenom("newPrenom");
			assertEquals("prenom", unMedecin.getNom());
		}
		
		public final static void setAdresseReussi() {
			unMedecin.setAdresse("newAdresse");
			assertEquals("newAdresse", unMedecin.getAdresse());
		}
		public final static void setAdresseEchoue() {
			unMedecin.setAdresse("newAdresse");
			assertEquals("adresse", unMedecin.getAdresse());
		}
		
		public final static void setLocaliteReussi() {
			uneAutreLocalite = new Localite("codePostal", "ville");
			unMedecin.setLaLocalite(uneAutreLocalite);
			assertEquals(uneAutreLocalite, unMedecin.getLaLocalite());
		}
		public final static void setLocaliteEchoue() {
			uneAutreLocalite = new Localite("codePostal", "ville");
			unMedecin.setLaLocalite(uneAutreLocalite);
			assertEquals(uneLocalite, unMedecin.getLaLocalite());
		}
		
		public final static void setTelephoneReussi() {
			unMedecin.setTelephone("newTelephone");
			assertEquals("newTelephone", unMedecin.getTelephone());
		}
		public final static void setTelephoneEchoue() {
			unMedecin.setTelephone("newTelephone");
			assertEquals("telephone", unMedecin.getTelephone());
		}
		
		public final static void setPotentielReussi() {
			unMedecin.setPotentiel("newPotentiel");
			assertEquals("newPotentiel", unMedecin.getPotentiel());
		}
		public final static void setPotentielEchoue() {
			unMedecin.setPotentiel("newPotentiel");
			assertEquals("potentiel", unMedecin.getPotentiel());
		}
		
		public final static void setSpecialiteReussi() {
			unMedecin.setSpecialite("newSpecialite");
			assertEquals("newSpecialite", unMedecin.getSpecialite());
		}
		public final static void setSpecialiteEchoue() {
			unMedecin.setSpecialite("newSpecialite");
			assertEquals("specialite", unMedecin.getSpecialite());
		}

}

