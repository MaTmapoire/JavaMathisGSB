package gsb.modele;

public class Stocker {
	
	protected int qteStock;
	public Visiteur unVisiteur;
	public Medicament unMedicament;
	protected String codeSto;
	/**
	 * @param qteStock
	 * @param unVisiteur
	 * @param unMedicament
	 */
	public Stocker(int qteStock, Visiteur unVisiteur, Medicament unMedicament, String codeSto) {
		this.qteStock = qteStock;
		this.unVisiteur = unVisiteur;
		this.unMedicament = unMedicament;
		this.codeSto = codeSto;
	}
	/**
	 * @return the qteStock
	 */
	public int getQteStock() {
		return qteStock;
	}
	/**
	 * @param qteStock the qteStock to set
	 */
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	/**
	 * @return the unVisiteur
	 */
	public Visiteur getUnVisiteur() {
		return unVisiteur;
	}
	/**
	 * @param unVisiteur the unVisiteur to set
	 */
	public void setUnVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}
	/**
	 * @return the unMedicament
	 */
	public Medicament getUnMedicament() {
		return unMedicament;
	}
	/**
	 * @param unMedicament the unMedicament to set
	 */
	public void setUnMedicament(Medicament unMedicament) {
		this.unMedicament = unMedicament;
	}
	public String getCodeSto() {
		return codeSto;
	}
	public void setCodeSto(String codeSto) {
		this.codeSto = codeSto;
	}
	
	
}
