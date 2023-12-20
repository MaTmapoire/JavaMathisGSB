package gsb.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Localite;
import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;

class StockerTest {

    static Stocker unStockerTest;
    static Medicament unMedicamentTest;
    static Visiteur unVisiteurTest;
    static Localite uneLocaliteTest;

    @BeforeEach
    void setUp() throws Exception {
        unMedicamentTest = new Medicament("depot", "nom", "composition", "effets", "contre", 10.5, "code", "libelle");
        unVisiteurTest= new Visiteur("TEST","TEST","TEST","TEST","TEST","TEST",uneLocaliteTest,"TEST",null,10,"TEST","TEST");
        uneLocaliteTest = new Localite("Test","Test");
        unStockerTest = new Stocker(10, unVisiteurTest, unMedicamentTest, "codeSto");
    }

    @AfterEach
    void tearDown() throws Exception {

    }

    @Test
    public void getQteStockReussi() {
        assertEquals(10, unStockerTest.getQteStock());
    }

    @Test
    public void getUnVisiteurReussi() {
        assertEquals(unVisiteurTest, unStockerTest.getUnVisiteur());
    }

    @Test
    public void getUnMedicamentReussi() {
        assertEquals(unMedicamentTest, unStockerTest.getUnMedicament());
    }

    @Test
    public void getCodeStoReussi() {
        assertEquals("codeSto", unStockerTest.getCodeSto());
    }

    @Test
    public void setQteStockReussi() {
    	unStockerTest.setQteStock(20);
        assertEquals(20, unStockerTest.getQteStock());
    }

    @Test
    public void setUnVisiteurReussi() {
    	Localite newLocalite = new Localite("newTest","newTest");
    	 Visiteur nouveauVisiteur = new Visiteur("newMatricule", "newNom", "newPrenom", "newLogin","newMdp","newAdresse", newLocalite, "newAdresse", null, 1, "newDateEmbauche", "newCodeSecteur");
         unStockerTest.setUnVisiteur(nouveauVisiteur);
        assertEquals(nouveauVisiteur, unStockerTest.getUnVisiteur());
    }

    @Test
    public void setUnMedicamentReussi() {
        Medicament nouveauMedicament = new Medicament("nouveauDepot", "nouveauNom", "nouvelleComposition", "nouveauxEffets", "nouveauContre", 15.0, "nouveauCode", "nouveauLibelle");
        unStockerTest.setUnMedicament(nouveauMedicament);
        assertEquals(nouveauMedicament, unStockerTest.getUnMedicament());
    }

    @Test
    public void setCodeStoReussi() {
    	unStockerTest.setCodeSto("nouveauCodeSto");
        assertEquals("nouveauCodeSto", unStockerTest.getCodeSto());
    }
}
