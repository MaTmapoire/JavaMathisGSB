/*
 * Crée le 21 Decembre. 2023
 */
package gsb.modele.dao;

import gsb.modele.Localite;
import gsb.modele.Medecin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;



/**
 * @author Théo Di Pauli
 * 21 Decembre. 2023
 */
public class MedecinDao {
	
	/**
	 * Crée un nouveau médecin dans la base de données.
	 * 
	 * @param unMedecin L'objet Medecin à ajouter dans la base de données.
	 * @return Le nombre de lignes affectées par la requête d'insertion.
	 */
	
	
	public static int creer(Medecin unMedecin) {
		int result = 0;
		String requeteInsertion;
		String code = unMedecin.getCodeMed();
		String nom = unMedecin.getNom();
		String prenom = unMedecin.getPrenom();
		String adresse = unMedecin.getAdresse();
		String cp = unMedecin.getLaLocalite().getCodePostal();
		String telephone =unMedecin.getTelephone();
		String potentiel = unMedecin.getPotentiel();
		String specialite = unMedecin.getSpecialite();
		
		requeteInsertion = "insert into MEDECIN values("+code+","+nom+","+prenom+","+adresse+","+cp+","+telephone+","+potentiel+","+specialite+")";
		try {
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch (Exception e) {
			System.out.println("echec insertion MEDECIN");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	
	/**
	 * Recherche un médecin dans la base de données par son code.
	 * 
	 * @param codeMedecin Le code du médecin à rechercher.
	 * @return Une instance de la classe Medecin correspondant au médecin trouvé, ou null si non trouvé.
	 */
	
	public static Medecin rechercher(String codeMedecin){
		Medecin unMedecin=null;
		Localite uneLocalite= null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from medecin where CODEMED ='"+codeMedecin+"'");
		try {
			if (reqSelection.next()) {
				uneLocalite = LocaliteDao.rechercher(reqSelection.getString(5));
				unMedecin = new Medecin(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), uneLocalite, reqSelection.getString(6), reqSelection.getString(7), reqSelection.getString(8) );	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ�te - select * from medecin where CODEMED ='"+codeMedecin+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unMedecin;
	}
	
	/**
	 * Retourne une collection d'instances de la classe Medecin contenant tous les médecins de la base de données.
	 * 
	 * @return Une ArrayList d'objets Medecin représentant tous les médecins de la base de données.
	 */
	
	public static ArrayList<Medecin> retournerCollectionDesMedecins(){
		ArrayList<Medecin> collectionDesMedecins = new ArrayList<Medecin>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select medecin from MEDECIN");
		try{
		while (reqSelection.next()) {
			String codeMedecin = reqSelection.getString(1);
		    collectionDesMedecins.add(MedecinDao.rechercher(codeMedecin));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedecins()");
		}
		return collectionDesMedecins;
	}
	
	/**
	 * Retourne un dictionnaire des médecins présents dans la base de données, avec leur code comme clé.
	 * 
	 * @return Un HashMap contenant les médecins de la base de données, avec le code du médecin comme clé.
	 */
	
	public static HashMap<String,Medecin> retournerDictionnaireDesMedecins(){
		HashMap<String, Medecin> diccoDesMedecins = new HashMap<String, Medecin>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select medecin from MEDECIN");
		try{
		while (reqSelection.next()) {
			String codeMedecin = reqSelection.getString(1);
		    diccoDesMedecins.put(codeMedecin, MedecinDao.rechercher(codeMedecin));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedecins()");
		}
		return diccoDesMedecins;
	}
	
	/**
	 * Supprime un médecin de la base de données par son code.
	 * 
	 * @param codeMed Le code du médecin à supprimer.
	 * @return Le nombre de lignes affectées par la requête de suppression.
	 */
	public static int supprimer(String codeMed){
		String requeteSuppression = "delete from medecin where CODEMED='"+codeMed+"'";
		int result = ConnexionMySql.execReqMaj(requeteSuppression);
		ConnexionMySql.fermerConnexionBd();
		return result;
		}
}
