package gsb.service;

import gsb.modele.Medecin;
import gsb.modele.dao.MedecinDao;

public class MedecinService {

	
	
	/**
	 * Recherche un médecin dans la base de données par son code.
	 * 
	 * @param codeMed Le code du médecin à rechercher.
	 * @return Une instance de la classe Medecin correspondant au médecin trouvé.
	 * @throws IllegalArgumentException Si le code médecin est invalide.
	 */
	
	public static Medecin rechercherMedecin(String codeMed) {
		Medecin unMedecin = MedecinDao.rechercher(codeMed);
		if (!isValidCodeMed(unMedecin.getCodeMed())) {
	        throw new IllegalArgumentException("Code Medecin invalide");
	    }
        return MedecinDao.rechercher(codeMed);
    }
	
	/**
	 * Crée un nouveau médecin dans la base de données.
	 * 
	 * @param medecin Un objet Medecin contenant les informations du nouveau médecin.
	 * @return Le nombre de lignes affectées dans la base de données.
	 * @throws IllegalArgumentException Si le numéro de téléphone, le code médecin ou le code postal est invalide.
	 */
	
	public static int creerMedecin(Medecin medecin) {
        
		if (!isValidTelephone(medecin.getTelephone())) {
	        throw new IllegalArgumentException("Numéro de téléphone invalide");
	    }
	    if (!isValidCodeMed(medecin.getCodeMed())) {
	        throw new IllegalArgumentException("Code Medecin invalide");
	    }
	    if (!isValidCp(medecin.getLaLocalite().getCodePostal())) {
	        throw new IllegalArgumentException("Code postal invalide");
	    }
	    
        return MedecinDao.creer(medecin);
    }
	
	/**
	 * Vérifie la validité du code médecin en utilisant une expression régulière.
	 * 
	 * @param codeMed Le code médecin à vérifier.
	 * @return true si le code médecin est valide, sinon false.
	 */
	
	private static boolean isValidCodeMed(String codeMed) {
		String codeMedPattern = "[a-z]\\d{3}";
	    return codeMed.matches(codeMedPattern);
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
	 * Vérifie la validité du numéro de téléphone en utilisant une expression régulière.
	 * 
	 * @param telephone Le numéro de téléphone à vérifier.
	 * @return true si le numéro de téléphone est valide, sinon false.
	 */
	
	private static boolean isValidTelephone(String telephone) {
	    String phoneNumberPattern = "\\d{2}-\\d{2}-\\d{2}-\\d{2}-\\d{2}";
	    return telephone.matches(phoneNumberPattern);
	}
	
}
