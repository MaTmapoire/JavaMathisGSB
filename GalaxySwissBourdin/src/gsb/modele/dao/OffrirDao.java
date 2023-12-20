package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Visite;

public class OffrirDao {
	
	/**
	 * Recherche une offre d'échantillon dans la base de données par son codeOffrir.
	 * 
	 * @param CodeOffrir Le code de l'offre d'échantillon à rechercher.
	 * @return Une instance de la classe Offrir correspondant à l'offre trouvée, ou null si non trouvée.
	 */
	
	public static Offrir rechercher(String CodeOffrir){
		Offrir uneOffre =null;
		Medicament unMedicament = null;
		Visite uneVisite = null;
		
		ResultSet req = ConnexionMySql.execReqSelection("select * from offrir where codeOffrir='"+CodeOffrir+"';");
		try {
			if (req.next()) {
				unMedicament = MedicamentDao.rechercher(req.getString(3));
				uneVisite = VisiteDao.rechercher(req.getString(2));
				uneOffre = new Offrir(unMedicament, uneVisite, req.getInt(4), req.getString(1));
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ�te - select * from offrir where codeOffrir='"+CodeOffrir+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return uneOffre;
	}
}
