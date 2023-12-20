package gsb.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Localite;
import gsb.modele.Visiteur;

class VisiteurTest {

    static Visiteur unVisiteurTest;
    static Localite uneLocaliteTest;

    @BeforeEach
    void setUp() throws Exception {
        uneLocaliteTest = new Localite("Test", "Test");
        unVisiteurTest = new Visiteur("TEST", "TEST", "TEST", "TEST", "TEST", "TEST", uneLocaliteTest, "TEST",
                null, 1000, "TEST", "TEST");
    }

    @AfterEach
    void tearDown() throws Exception {

    }

    @Test
    public void getMatriculeReussi() {
        assertEquals("matricule", unVisiteurTest.getMatricule());
    }

    @Test
    public void getNomReussi() {
        assertEquals("nom", unVisiteurTest.getNom());
    }

    @Test
    public void getPrenomReussi() {
        assertEquals("prenom", unVisiteurTest.getPrenom());
    }

    @Test
    public void getLoginReussi() {
        assertEquals("login", unVisiteurTest.getLogin());
    }

    @Test
    public void getMdpReussi() {
        assertEquals("mdp", unVisiteurTest.getMdp());
    }

    @Test
    public void getAdresseReussi() {
        assertEquals("adresse", unVisiteurTest.getAdresse());
    }

    @Test
    public void getUneLocaliteReussi() {
        assertEquals(uneLocaliteTest, unVisiteurTest.getUneLocalite());
    }

    @Test
    public void getTelephoneReussi() {
        assertEquals("telephone", unVisiteurTest.getTelephone());
    }

    @Test
    public void getDateEntreeReussi() {
        assertEquals(new Date(), unVisiteurTest.getDateEntree());
    }

    @Test
    public void getPrimeReussi() {
        assertEquals(1000, unVisiteurTest.getPrime());
    }

    @Test
    public void getCodeUniteReussi() {
        assertEquals("codeUnite", unVisiteurTest.getCodeUnite());
    }

    @Test
    public void getNomUniteReussi() {
        assertEquals("nomUnite", unVisiteurTest.getNomUnite());
    }

    // Tests pour les setters
    @Test
    public void setMatriculeReussi() {
    	unVisiteurTest.setMatricule("newMatricule");
        assertEquals("newMatricule", unVisiteurTest.getMatricule());
    }

    @Test
    public void setNomReussi() {
    	unVisiteurTest.setNom("newNom");
        assertEquals("newNom", unVisiteurTest.getNom());
    }

    @Test
    public void setPrenomReussi() {
    	unVisiteurTest.setPrenom("newPrenom");
        assertEquals("newPrenom", unVisiteurTest.getPrenom());
    }

    @Test
    public void setLoginReussi() {
    	unVisiteurTest.setLogin("newLogin");
        assertEquals("newLogin", unVisiteurTest.getLogin());
    }

    @Test
    public void setMdpReussi() {
    	unVisiteurTest.setMdp("newMdp");
        assertEquals("newMdp", unVisiteurTest.getMdp());
    }

    @Test
    public void setAdresseReussi() {
    	unVisiteurTest.setAdresse("newAdresse");
        assertEquals("newAdresse", unVisiteurTest.getAdresse());
    }

    @Test
    public void setUneLocaliteReussi() {
        Localite nouvelleLocalite = new Localite("newCode", "newVille");
        unVisiteurTest.setUneLocalite(nouvelleLocalite);
        assertEquals(nouvelleLocalite, unVisiteurTest.getUneLocalite());
    }

    @Test
    public void setTelephoneReussi() {
    	unVisiteurTest.setTelephone("newTelephone");
        assertEquals("newTelephone", unVisiteurTest.getTelephone());
    }

    @Test
    public void setDateEntreeReussi() {
        Date nouvelleDate = new Date();
        unVisiteurTest.setDateEntree(nouvelleDate);
        assertEquals(nouvelleDate, unVisiteurTest.getDateEntree());
    }

    @Test
    public void setPrimeReussi() {
    	unVisiteurTest.setPrime(2000);
        assertEquals(2000, unVisiteurTest.getPrime());
    }

    @Test
    public void setCodeUniteReussi() {
    	unVisiteurTest.setCodeUnite("newCodeUnite");
        assertEquals("newCodeUnite", unVisiteurTest.getCodeUnite());
    }

    @Test
    public void setNomUniteReussi() {
    	unVisiteurTest.setNomUnite("newNomUnite");
        assertEquals("newNomUnite", unVisiteurTest.getNomUnite());
    }
}

