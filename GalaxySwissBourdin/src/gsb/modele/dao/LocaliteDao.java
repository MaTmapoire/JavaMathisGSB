/*
 * Cr�� le 22 f�vr. 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.modele.dao;

import gsb.modele.Localite;

import java.sql.ResultSet;


/**
 * @author Isabelle
 * 22 f�vr. 2015
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
public class LocaliteDao {
	
	/**
	 * Recherche une localité dans la base de données par son code postal.
	 * 
	 * @param codeLocalite Le code postal de la localité à rechercher.
	 * @return Une instance de la classe Localite correspondant à la localité trouvée, ou null si non trouvée.
	 */

	
	public static Localite rechercher(String codeLocalite){
		Localite uneLocalite=null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT * FROM localite WHERE CODEPOSTAL='"+codeLocalite+"'");
		try {
			if (reqSelection.next()) {
				uneLocalite = new Localite(reqSelection.getString(1), reqSelection.getString(2));	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ�te - select * from localite where CODEPOSTAL='"+codeLocalite+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return uneLocalite;
		
	}
	
	
	public static int creer(Localite uneLocalite){
		int result = 0;
		String requeteInsertion;
		String codePostal = uneLocalite.getCodePostal();
		String ville = uneLocalite.getVille();
		requeteInsertion = "insert into localite values('"+codePostal+"','"+ville+"');";
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch(Exception e){
			System.out.println("echec insertion localite");
			result =0;
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	/**
	 * Supprime une localité de la base de données par son code postal.
	 * 
	 * @param unCodePostal Le code postal de la localité à supprimer.
	 * @return Le nombre de lignes affectées par la requête de suppression.
	 */
	
	public static int supprimer(String unCodePostal){
		String requeteSuppression = "delete from localite where CODEPOSTAL='"+unCodePostal+"'";
		int result = ConnexionMySql.execReqMaj(requeteSuppression);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

}
