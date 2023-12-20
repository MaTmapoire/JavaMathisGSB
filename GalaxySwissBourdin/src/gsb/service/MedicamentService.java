package gsb.service;

import javax.swing.JOptionPane;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentService {

	/**
	 * Recherche un médicament dans la base de données par son dépôt légal.
	 * 
	 * @param depotLegal Le dépôt légal du médicament à rechercher.
	 * @return Une instance de la classe Medicament correspondant au médicament trouvé.
	 * @throws IllegalArgumentException Si le dépôt légal du médicament est invalide.
	 */
	
	public static Medicament rechercherMedicament(String depotLegal) {
		Medicament unMedicament = MedicamentDao.rechercher(depotLegal);
		if (unMedicament == null || !isValidDepotLegal(unMedicament.getDepotLegal())) {
	        return null;
	    }
        return MedicamentDao.rechercher(depotLegal);
    }
	
	/**
	 * Crée un nouveau médicament dans la base de données.
	 * 
	 * @param medicament Un objet Medicament contenant les informations du nouveau médicament.
	 * @return Le nombre de lignes affectées dans la base de données.
	 * @throws IllegalArgumentException Si le dépôt légal du médicament est invalide.
	 */
	
	public static int creerMedicament(Medicament medicament) {
        
		if (!isValidDepotLegal(medicament.getDepotLegal())) {
		    JOptionPane.showMessageDialog(null, "Le dépôt légal du médicament n'est pas valide. le dépôt légal doit être composé de cinq à sept lettres majuscules suivies de 0 à 3 chiffres.");
		    return 0;
		}
		if (!isValidCodeFam(medicament.getCodeFamille())) {
			JOptionPane.showMessageDialog(null, "Le code famille du médicament n'est pas valide. le dépôt légal doit être composé de trois lettres majuscules.");
		    return 0;
		}

	    
        return MedicamentDao.creer(medicament);
    }
	
	
	/**
	 * Vérifie la validité du dépôt légal du médicament en utilisant une expression régulière.
	 * 
	 * @param depotLegal Le dépôt légal du médicament à vérifier.
	 * @return true si le dépôt légal du médicament est valide, sinon false.
	 */
	
	private static boolean isValidDepotLegal(String depotLegal) {
	    String depotLegalPattern = "[A-Z]{5,7}\\d{0,3}";
	    return depotLegal.matches(depotLegalPattern);
	}
	
	private static boolean isValidCodeFam(String codeFam) {
		String codeFamPattern = "[A-Z]{3}";
		return codeFam.matches(codeFamPattern);
	}
}
