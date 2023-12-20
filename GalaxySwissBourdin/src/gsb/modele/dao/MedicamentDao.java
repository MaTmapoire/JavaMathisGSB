package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import gsb.modele.*;

public class MedicamentDao {

	/**
	 * Recherche un médicament dans la base de données par son depotLegal.
	 * 
	 * @param unDepotLegal Le depotLegal du médicament à rechercher.
	 * @return Une instance de la classe Medicament correspondant au médicament trouvé, ou null si non trouvé.
	 */
	
	public static Medicament rechercher(String unDepotLegal){
		Medicament unMedicament =null;
		ResultSet req = ConnexionMySql.execReqSelection("select * from medicament where MED_DEPOTLEGAL='"+unDepotLegal+"';");
		try {
			if (req.next()) {
				unMedicament = new Medicament(req.getString(1),req.getString(2),req.getString(3),req.getString(4),req.getString(5),req.getDouble(6),req.getString(7),req.getString(8));
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ�te - select * from Medicament where MED_DEPOTLEGAL='"+unDepotLegal+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unMedicament;
	}
	
	/**
	 * Crée un nouveau médicament dans la base de données.
	 * 
	 * @param unMedicament L'objet Medicament à ajouter dans la base de données.
	 * @return Le nombre de lignes affectées par la requête d'insertion.
	 */
	
	public static int creer(Medicament unMedicament){
	    int result = 0;
	    String requeteInsertion;
	    String depotLegal = unMedicament.getDepotLegal();
	    String nomCommercial = unMedicament.getNomCommercial();
	    String composition = unMedicament.getComposition();
	    String effets = unMedicament.getEffets();
	    String contreIndication = unMedicament.getContreIndication();
	    double prixEchantillon = unMedicament.getPrixEchantillon();
	    String codeFamille = unMedicament.getCodeFamille();
	    String libelleFamille = unMedicament.getLibellefamille();
	    
	    requeteInsertion = "insert into medicament values('"+depotLegal+"','"+nomCommercial+"','"+composition+"','"+effets+"','"+contreIndication+"','"+prixEchantillon+"','"+codeFamille+"','"+libelleFamille+"');";
	    try {
	        result = ConnexionMySql.execReqMaj(requeteInsertion);
	    } catch(Exception e) {
	        System.out.println("Échec d'insertion du médicament");
	    }
	    ConnexionMySql.fermerConnexionBd();
	    return result;
	}

	
	/**
	 * Retourne une collection d'instances de la classe Medicament contenant tous les médicaments de la base de données.
	 * 
	 * @return Une ArrayList d'objets Medicament représentant tous les médicaments de la base de données.
	 */
	
	public static ArrayList<Medicament> rechercherTout(){
		ArrayList<Medicament> collectionDesMedicament = new ArrayList<Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from medicament");
		
		try{
		while (reqSelection.next()) {
			String depotLegal = reqSelection.getString(1);
			
			collectionDesMedicament.add(MedicamentDao.rechercher(depotLegal));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur rechercherTout()");
		}
		return collectionDesMedicament;
	}
	
	/**
	 * Retourne une collection d'instances de la classe Medicament contenant tous les médicaments de la base de données
	 * appartenant à une famille spécifique.
	 * 
	 * @param unCodeFamille Le code de la famille des médicaments à rechercher.
	 * @return Une ArrayList d'objets Medicament représentant les médicaments de la famille spécifiée.
	 */	
	
	public static ArrayList<Medicament> rechercherCodeFamille(String unCodeFamille){
		ArrayList<Medicament> collectionDesMedicament = new ArrayList<Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from medicament WHERE FAM_CODE ='"+unCodeFamille+"'");
		
		try{
		while (reqSelection.next()) {
			String depotLegal = reqSelection.getString(1);
			
			collectionDesMedicament.add(MedicamentDao.rechercher(depotLegal));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur rechercherCodeFamille()");
		}
		return collectionDesMedicament;
	}
	
	/**
	 * Supprime un médicament de la base de données par son depotLegal.
	 * 
	 * @param unDepotLegal Le depotLegal du médicament à supprimer.
	 * @return Le nombre de lignes affectées par la requête de suppression.
	 */
	
	public static int supprimer(String unDepotLegal){
		String requeteSuppression = "delete from medicament where MED_DEPOTLEGAL='"+unDepotLegal+"'";
		int result = ConnexionMySql.execReqMaj(requeteSuppression);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	/**
	 * Modifie les informations d'un médicament dans la base de données par son depotLegal.
	 * 
	 * @param unDepotLegal Le depotLegal du médicament à modifier.
	 * @param unMedicament L'objet Medicament contenant les nouvelles informations.
	 * @return Le nombre de lignes affectées par la requête de modification.
	 */
	
	public static int modifier(String unDepotLegal, Medicament unMedicament) {

		String requeteSuppression = "UPDATE medicament SET MED_DEPOTLEGAL = '"
		+ unMedicament.getDepotLegal() +

		"', MED_NOMCOMMERCIAL = '" + unMedicament.getNomCommercial() +

		"', MED_COMPOSITION = '" + unMedicament.getComposition() +

		"', MED_EFFETS = '" + unMedicament.getEffets() +

		"', MED_CONTREINDIC = '" + unMedicament.getContreIndication() +

		"', MED_PRIXECHANTILLON = " + unMedicament.getPrixEchantillon() +

		", FAM_CODE = '" + unMedicament.getCodeFamille() +

		"', FAM_LIBELLE = '" + unMedicament.getLibellefamille() +

		"' WHERE MED_DEPOTLEGAL = '" + unDepotLegal + "'";
		 // Vérification si le dépôt légal existe déjà
	    String requeteVerification = "SELECT COUNT(*) FROM medicament WHERE MED_DEPOTLEGAL = '" + unDepotLegal + "';";
	    int count = 0;
	    int result = 0;
	    try {
	        count = ConnexionMySql.execReqMaj(requeteVerification);
	    } catch(Exception e) {
	        System.out.println("Erreur lors de la vérification du dépôt légal");
	    }
	    
	    if (count > 0) {
	        System.out.println("Le dépôt légal existe déjà. Impossible de renommer le dépôt légal du médicament.");
	        return result; // Retourner 0 ou une valeur indiquant l'échec de l'insertion
	    }

		int result1 = ConnexionMySql.execReqMaj(requeteSuppression);

		ConnexionMySql.fermerConnexionBd();

		return result1;
	}
	
	/**
	 * Retourne un dictionnaire des médicaments de la base de données.
	 * 
	 * @return Un HashMap associant le depotLegal des médicaments à leurs instances correspondantes.
	 */
	
	public static HashMap<String,Medicament> retournerDictionnaireDesMedicaments(){
		HashMap<String, Medicament> diccoDesMedicaments = new HashMap<String, Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from medicament");
		try{
		while (reqSelection.next()) {
			String codeMedicament = reqSelection.getString(1);
			diccoDesMedicaments.put(codeMedicament, MedicamentDao.rechercher(codeMedicament));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedicaments()");
		}
		return diccoDesMedicaments;
	}

}
