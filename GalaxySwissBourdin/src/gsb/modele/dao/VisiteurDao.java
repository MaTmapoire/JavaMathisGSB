package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import gsb.modele.*;

public class VisiteurDao {
	
	/**
	 * Recherche un visiteur dans la base de données par son matricule.
	 * 
	 * @param unMatricule Le matricule du visiteur à rechercher.
	 * @return Une instance de la classe Visiteur correspondant au visiteur trouvé, ou null si non trouvé.
	 */

	public static Visiteur rechercher(String unMatricule){
		Visiteur unVisiteur =null;
		ResultSet req = ConnexionMySql.execReqSelection("SELECT * FROM visiteur WHERE MATRICULE='"+unMatricule+"';");
		try {
			if (req.next()) {
				Localite uneLocalite= LocaliteDao.rechercher(req.getString(7));
				unVisiteur = new Visiteur(req.getString(1),req.getString(2),req.getString(3),req.getString(4),req.getString(5),req.getString(6),uneLocalite,"",req.getDate(8),0,req.getString(9),req.getString(10));
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ�te - select * from visiteur where MATRICULE='"+unMatricule+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unVisiteur;
	}
	
	/**
	 * Modifie les informations d'un visiteur dans la base de données.
	 * 
	 * @param unMatricule Le matricule du visiteur à modifier.
	 * @param unVisiteur Un objet Visiteur contenant les nouvelles informations à mettre à jour.
	 * @return Le nombre de lignes affectées dans la base de données.
	 */
	
	public static int modifier(String unMatricule, Visiteur unVisiteur) {
		String requeteSuppression = "update visiteur set MATRICULE = '"+ unVisiteur.getMatricule()+"', NOM = '"+ unVisiteur.getNom()+"',PRENOM = '"+ unVisiteur.getPrenom()+"',LOGIN = '"+ unVisiteur.getLogin()+"',MDP = '"+ unVisiteur.getMdp()+"',ADRESSE = '"+ unVisiteur.getAdresse()+"',CODEPOSTAL = '"+ unVisiteur.getUneLocalite().getCodePostal()+"',DATEENTREE = '"+ unVisiteur.getDateEntree()+"',CODEUNIT = '"+ unVisiteur.getCodeUnite()+"',NOMUNIT = '"+ unVisiteur.getNomUnite()+"' where MATRICULE='"+unMatricule+"'";
		int result = ConnexionMySql.execReqMaj(requeteSuppression);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	/**
	 * Crée un nouveau visiteur dans la base de données.
	 * 
	 * @param unVisiteur Un objet Visiteur contenant les informations du nouveau visiteur.
	 * @return Le nombre de lignes affectées dans la base de données.
	 */
	
	public static int creer(Visiteur unVisiteur){
		int result = 0;
		String requeteInsertion;
		String matricule = unVisiteur.getMatricule();
		String nom = unVisiteur.getNom();
		String prenom = unVisiteur.getPrenom();
		String login = unVisiteur.getLogin();
		String mdp = unVisiteur.getMdp();
		
		String adresse = unVisiteur.getAdresse();
		String codePostale = unVisiteur.getUneLocalite().getCodePostal();
		Date date = unVisiteur.getDateEntree();
		String codeUnite = unVisiteur.getCodeUnite();
		String nomUnite = unVisiteur.getNomUnite();
		requeteInsertion = "insert into visiteur values('"+matricule+"','"+nom+"','"+prenom+"','"+login+"','"+mdp+"','"+adresse+"','"+codePostale+"','"+date+"','"+codeUnite+"','"+nomUnite+"');";
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch(Exception e){
			System.out.println("echec insertion Visiteur");
			result =0;
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	/**
	 * Supprime un visiteur de la base de données.
	 * 
	 * @param unMatricule Le matricule du visiteur à supprimer.
	 * @return Le nombre de lignes affectées dans la base de données.
	 */
	
	public static int supprimer(String unMatricule){
		String requeteSuppression = "delete from visiteur where MATRICULE='"+unMatricule+"'";
		int result = ConnexionMySql.execReqMaj(requeteSuppression);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	/**
	 * Récupère la liste complète des visiteurs dans la base de données.
	 * 
	 * @return Une ArrayList contenant tous les visiteurs de la base de données.
	 */
	
	public static ArrayList<Visiteur> rechercherTout(){
		ArrayList<Visiteur> collectionDesVisiteur = new ArrayList<Visiteur>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MATRICULE from visiteur");
		
		try{
		while (reqSelection.next()) {
			@SuppressWarnings("unused")
			String matricule = reqSelection.getString(1);
			
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur rechercherTout()");
		}
		return collectionDesVisiteur;
	}
	
	/**
	 * Récupère un dictionnaire des visiteurs avec leur matricule comme clé.
	 * 
	 * @return Un HashMap contenant les visiteurs de la base de données avec leur matricule comme clé.
	 */
	
	public static HashMap<String,Visiteur> retournerDictionnaireDesVisiteur(){
		HashMap<String, Visiteur> diccoDesVisiteurs = new HashMap<String, Visiteur>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT MATRICULE FROM visiteur ;");
		try{
		while (reqSelection.next()) {
			String matricule = reqSelection.getString(1);
			diccoDesVisiteurs.put(matricule, VisiteurDao.rechercher(matricule));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDictionnaireDesVisiteur()");
		}
		return diccoDesVisiteurs;
	}
}
