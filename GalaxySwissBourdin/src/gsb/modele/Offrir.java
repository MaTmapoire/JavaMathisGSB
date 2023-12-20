package gsb.modele;

public class Offrir {

	protected Medicament unMedicament;
	protected Visite uneVisite;
	protected int qteOfferte;
	protected String codeOffrir;
	/**
	 * @param unMedicament
	 * @param uneVisite
	 * @param qteOfferte
	 */
	public Offrir(Medicament unMedicament, Visite uneVisite, int qteOfferte, String codeOffrir) {
		this.unMedicament = unMedicament;
		this.uneVisite = uneVisite;
		this.qteOfferte = qteOfferte;
		this.codeOffrir = codeOffrir;
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
	/**
	 * @return the uneVisite
	 */
	public Visite getUneVisite() {
		return uneVisite;
	}
	/**
	 * @param uneVisite the uneVisite to set
	 */
	public void setUneVisite(Visite uneVisite) {
		this.uneVisite = uneVisite;
	}
	/**
	 * @return the qteOfferte
	 */
	public int getQteOfferte() {
		return qteOfferte;
	}
	/**
	 * @param qteOfferte the qteOfferte to set
	 */
	public void setQteOfferte(int qteOfferte) {
		this.qteOfferte = qteOfferte;
	}
	public String getCodeOffrir() {
		return codeOffrir;
	}
	public void setCodeOffrir(String codeOffrir) {
		this.codeOffrir = codeOffrir;
	}
	
	
}
