package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

public class VisiteDao {
	
	/**
	 * Recherche une visite dans la base de données par sa référence.
	 * 
	 * @param Reference La référence de la visite à rechercher.
	 * @return Une instance de la classe Visite correspondant à la visite trouvée, ou null si non trouvée.
	 */
	
	public static Visite rechercher(String Reference){
		Visite uneVisite =null;
		Medecin unMedecin = null;
		Visiteur unVisiteur = null;
		
		ResultSet req = ConnexionMySql.execReqSelection("select * from visite where REFERENCE='"+Reference+"';");
		try {
			if (req.next()) {
				unMedecin = MedecinDao.rechercher(req.getString(4));
				unVisiteur = VisiteurDao.rechercher(req.getString(5));
				uneVisite = new Visite (req.getString(1),req.getDate(2),req.getString(3),unMedecin, unVisiteur);
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ�te - select * from visite where REFERENCE='"+Reference+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return uneVisite;
	}
}
