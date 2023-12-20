package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;

public class StockerDao {
	
	/**
	 * Recherche un stock dans la base de données par son CodeSto.
	 * 
	 * @param CodeSto Le code du stock à rechercher.
	 * @return Une instance de la classe Stocker correspondant au stock trouvé, ou null si non trouvé.
	 */
	
	public static Stocker rechercher(String CodeSto){
		Stocker unStock =null;
		Medicament unMedicament = null;
		Visiteur unVisiteur = null;
		
		ResultSet req = ConnexionMySql.execReqSelection("select * from stocker where CODESTO='"+CodeSto+"';");
		try {
			if (req.next()) {
				unMedicament = MedicamentDao.rechercher(req.getString(3));
				unVisiteur = VisiteurDao.rechercher(req.getString(2));
				unStock = new Stocker (req.getInt(4), unVisiteur, unMedicament, req.getString(1));
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ�te - select * from stocker where CODESTO='"+CodeSto+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unStock;
	}

}
