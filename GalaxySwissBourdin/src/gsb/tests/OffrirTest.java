package gsb.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

class OffrirTest {

    static Offrir unOffrirTest;
    static Medicament unMedicamentTest;
    static Visite uneVisiteTest;
    static Medecin unMedecinTest;
    static Localite uneLocaliteTest;
    static Visiteur unVisiteurTest;
    @BeforeEach
    void setUp() throws Exception {
        unMedicamentTest = new Medicament("depot", "nom", "composition", "effets", "contre", 10.5, "code", "libelle");
        uneLocaliteTest = new Localite("Test","Test");
        unMedecinTest = new Medecin("m991","TEST","TEST","TEST",uneLocaliteTest, "TEST","TEST","TEST");
        unVisiteurTest= new Visiteur("TEST","TEST","TEST","TEST","TEST","TEST",uneLocaliteTest,"TEST",null,10,"TEST","TEST");
        uneVisiteTest = new Visite("reference",null, "commentaire", unMedecinTest, unVisiteurTest);
        unOffrirTest = new Offrir(unMedicamentTest, uneVisiteTest, 5, "codeOffrir");
    }

    @AfterEach
    void tearDown() throws Exception {

    }

    @Test
    public void getUnMedicamentReussi() {
        assertEquals(unMedicamentTest, unOffrirTest.getUnMedicament());
    }

    @Test
    public void getUneVisiteReussi() {
        assertEquals(uneVisiteTest, unOffrirTest.getUneVisite());
    }

    @Test
    public void getQteOfferteReussi() {
        assertEquals(5, unOffrirTest.getQteOfferte());
    }

    @Test
    public void getCodeOffrirReussi() {
        assertEquals("codeOffrir", unOffrirTest.getCodeOffrir());
    }

    @Test
    public void setUnMedicamentReussi() {
        Medicament nouveauMedicament = new Medicament("nouveauDepot", "nouveauNom", "nouvelleComposition", "nouveauxEffets", "nouveauContre", 15.0, "nouveauCode", "nouveauLibelle");
        unOffrirTest.setUnMedicament(nouveauMedicament);
        assertEquals(nouveauMedicament, unOffrirTest.getUnMedicament());
    }

    public void setUneVisiteReussi() {
    	Visite nouvelleVisite = new Visite("newReference",null, "newCommentaire", unMedecinTest, unVisiteurTest); 
    	unOffrirTest.setUneVisite(nouvelleVisite);
        assertEquals(nouvelleVisite, unOffrirTest.getUneVisite());
    }
    @Test
    public void setQteOfferteReussi() {
        unOffrirTest.setQteOfferte(10);
        assertEquals(10, unOffrirTest.getQteOfferte());
    }

    @Test
    public void setCodeOffrirReussi() {
        unOffrirTest.setCodeOffrir("nouveauCodeOffrir");
        assertEquals("nouveauCodeOffrir", unOffrirTest.getCodeOffrir());
    }
}
