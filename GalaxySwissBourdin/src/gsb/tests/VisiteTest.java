package gsb.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

class VisiteTest {

    static Visite uneVisiteTest;
    static Medecin unMedecinTest;
    static Visiteur unVisiteurTest;
    static Localite uneLocaliteTest;

    @BeforeEach
    void setUp() throws Exception {
        unMedecinTest = new Medecin("codeMed", "nom", "prenom", "adresse", null, "telephone", "potentiel", "specialite");
        uneLocaliteTest = new Localite("TEST","TEST");
        unVisiteurTest= new Visiteur("TEST","TEST","TEST","TEST","TEST","TEST",uneLocaliteTest,"TEST",null,10,"TEST","TEST");
        uneVisiteTest = new Visite("reference",null, "commentaire", unMedecinTest, unVisiteurTest);
        
        }

    @AfterEach
    void tearDown() throws Exception {

    }

    @Test
    public void getReferenceReussi() {
        assertEquals("reference", uneVisiteTest.getReference());
    }

    @Test
    public void getDateReussi() {
        assertEquals(new Date(), uneVisiteTest.getDate());
    }

    @Test
    public void getCommentaireReussi() {
        assertEquals("commentaire", uneVisiteTest.getCommentaire());
    }

    @Test
    public void getUnMedecinReussi() {
        assertEquals(unMedecinTest, uneVisiteTest.getUnMedecin());
    }

    @Test
    public void getUnVisiteurReussi() {
        assertEquals(unVisiteurTest, uneVisiteTest.getUnVisiteur());
    }

    @Test
    public void setReferenceReussi() {
        uneVisiteTest.setReference("newReference");
        assertEquals("newReference", uneVisiteTest.getReference());
    }

    @Test
    public void setDateReussi() {
        Date newDate = new Date();
        uneVisiteTest.setDate(newDate);
        assertEquals(newDate, uneVisiteTest.getDate());
    }

    @Test
    public void setCommentaireReussi() {
        uneVisiteTest.setCommentaire("newCommentaire");
        assertEquals("newCommentaire", uneVisiteTest.getCommentaire());
    }

    @Test
    public void setUnMedecinReussi() {
        Medecin newMedecin = new Medecin("newCodeMed", "newNom", "newPrenom", "newAdresse", null, "newTelephone", "newPotentiel", "newSpecialite");
        uneVisiteTest.setUnMedecin(newMedecin);
        assertEquals(newMedecin, uneVisiteTest.getUnMedecin());
    }

    @Test
    public void setUnVisiteurReussi() {
    	Localite newLocalite = new Localite("Test2","Test2");
        Visiteur newVisiteur = new Visiteur("newMatricule", "newNom", "newPrenom", "newLogin","newMdp","newAdresse", newLocalite, "newAdresse", null, 1, "newDateEmbauche", "newCodeSecteur");
        uneVisiteTest.setUnVisiteur(newVisiteur);
        assertEquals(newVisiteur, uneVisiteTest.getUnVisiteur());
    }
}
