package gsb.service;

import gsb.modele.dao.VisiteurDao;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import gsb.modele.Visiteur;

public class VisiteurService {

	
	/**
	 * Recherche un visiteur dans la base de données par son matricule.
	 * 
	 * @param matricule Le matricule du visiteur à rechercher.
	 * @return Une instance de la classe Visiteur correspondant au visiteur trouvé.
	 * @throws IllegalArgumentException Si le matricule du visiteur est invalide.
	 */
	
	public static int supprimerVisiteur(String matricule) {
		return VisiteurDao.supprimer(matricule);
	}
	
	public static Visiteur rechercherVisiteur(String matricule) {
		Visiteur unVisiteur = VisiteurDao.rechercher(matricule);
		if (unVisiteur == null || !isValidMatricule(unVisiteur.getMatricule())) {
	        return null;
	    }
        return VisiteurDao.rechercher(matricule);
    }
	
	/**
	 * Crée un nouveau visiteur dans la base de données.
	 * 
	 * @param visiteur Un objet Visiteur contenant les informations du nouveau visiteur.
	 * @return Le nombre de lignes affectées dans la base de données.
	 */
	
	public static int creerVisiteur(Visiteur visiteur) {
		
		

		    // Effectuer les validations restantes
		if (!isValidMatricule(visiteur.getMatricule())) {
			JOptionPane.showMessageDialog(null, "Le Matricule du visiteur n'est pas valide. le Matricule doit être composé d'une lettre minuscule suivies de 2 à 3 chiffres.");
			return 0;
		}
		if (!isValidCp(visiteur.getUneLocalite().getCodePostal())) {
			JOptionPane.showMessageDialog(null, "Le code postal du visiteur n'est pas valide. le code postal doit être composé de 5 chiffres.");
			return 0;
		}
		if (!isValidCodeUnit(visiteur.getCodeUnite())){
			JOptionPane.showMessageDialog(null, "Le code unité du visiteur n'est pas valide. le code unité doit être composé de 2 lettres majuscules.");
			return 0;
		}
		if(!isValidDateFormat(visiteur.getDateEntree())){
			JOptionPane.showMessageDialog(null, "La date du visiteur n'est pas valide. la date doit être du format (yyyy-MM-dd).");
			return 0;
		}
		
		return VisiteurDao.creer(visiteur);
		

        
    }
	
	/**
	 * Modifie un visiteur dans la base de données.
	 * 
	 * @param matricule Le matricule du visiteur à modifier.
	 * @param visiteur Un objet Visiteur contenant les nouvelles informations du visiteur.
	 * @return Le nombre de lignes affectées dans la base de données.
	 */
	
	public static int modifierVisiteur(String matricule, Visiteur visiteur) {
		if (!isValidMatricule(visiteur.getMatricule())) {
			JOptionPane.showMessageDialog(null, "Le Matricule du visiteur n'est pas valide. le Matricule doit être composé d'une lettre minuscule suivies de 2 à 3 chiffres.");
			return 0;
		}
		if (!isValidCp(visiteur.getUneLocalite().getCodePostal())) {
			JOptionPane.showMessageDialog(null, "Le code postal du visiteur n'est pas valide. le code postal doit être composé de 5 chiffres.");
			return 0;
		}
		if (!isValidCodeUnit(visiteur.getCodeUnite())){
			JOptionPane.showMessageDialog(null, "Le code unité du visiteur n'est pas valide. le code unité doit être composé de 2 lettres majuscules.");
			return 0;
		}
		if(!isValidDateFormat(visiteur.getDateEntree())){
			JOptionPane.showMessageDialog(null, "La date du visiteur n'est pas valide. la date doit être du format (yyyy-MM-dd).");
			return 0;
		}
	    
	    return VisiteurDao.modifier(matricule, visiteur);
	}
	
	/**
	 * Vérifie la validité du matricule du visiteur en utilisant une expression régulière.
	 * 
	 * @param matricule Le matricule du visiteur à vérifier.
	 * @return true si le matricule du visiteur est valide, sinon false.
	 */
	
	private static boolean isValidMatricule(String matriule) {
		String matriculePattern = "[a-z]\\d{2,3}";
	    return matriule.matches(matriculePattern);
	}
	
	/**
	 * Vérifie la validité du code postal en utilisant une expression régulière.
	 * 
	 * @param cp Le code postal à vérifier.
	 * @return true si le code postal est valide, sinon false.
	 */
	
	private static boolean isValidCp(String cp) {
		String cpPattern = "\\d{5}";
	    return cp.matches(cpPattern);
	}
	
	/**
	 * Vérifie la validité du code unité en utilisant une expression régulière.
	 * 
	 * @param codeUnit Le code unité à vérifier.
	 * @return true si le code unité est valide, sinon false.
	 */
	
	private static boolean isValidCodeUnit(String codeUnit) {
		String codeUnitPattern = "[A-Z]{2,4}";
	    return codeUnit.matches(codeUnitPattern);
	}
	
	private static boolean isValidDateFormat(Date date) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false); // Désactive la tolérance pour les dates invalides

	    try {
	        // Formatte la date en une chaîne selon le format spécifié
	        String formattedDate = dateFormat.format(date);
	        
	        // Compare la chaîne formatée avec la date originale
	        return formattedDate.equals(dateFormat.format(date));
	    } catch (Exception e) {
	        return false; // Erreur lors du formatage, la date n'est pas dans le bon format
	    }
	}
	
	
}
