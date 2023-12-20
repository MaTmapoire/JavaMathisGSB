package gsb.modele;

public class Medicament {

	protected String depotLegal;
	protected String nomCommercial;
	protected String composition;
	protected String effets;
	protected String contreIndication;
	protected double prixEchantillon;
	protected String codeFamille;
	protected String libellefamille;
	/**
	 * @param depotLegal
	 * @param nomCommercial
	 * @param composition
	 * @param effets
	 * @param contreIndication
	 * @param prixEchantillon
	 * @param codeFamille
	 * @param libellefamille
	 */
	public Medicament(String depotLegal, String nomCommercial, String composition, String effets,
			String contreIndication, double prixEchantillon, String codeFamille, String libellefamille) {
		this.depotLegal = depotLegal;
		this.nomCommercial = nomCommercial;
		this.composition = composition;
		this.effets = effets;
		this.contreIndication = contreIndication;
		this.prixEchantillon = prixEchantillon;
		this.codeFamille = codeFamille;
		this.libellefamille = libellefamille;
	}
	/**
	 * @return the depotLegal
	 */
	public String getDepotLegal() {
		return depotLegal;
	}
	/**
	 * @param depotLegal the depotLegal to set
	 */
	public void setDepotLegal(String depotLegal) {
		this.depotLegal = depotLegal;
	}
	/**
	 * @return the nomCommercial
	 */
	public String getNomCommercial() {
		return nomCommercial;
	}
	/**
	 * @param nomCommercial the nomCommercial to set
	 */
	public void setNomCommercial(String nomCommercial) {
		this.nomCommercial = nomCommercial;
	}
	/**
	 * @return the composition
	 */
	public String getComposition() {
		return composition;
	}
	/**
	 * @param composition the composition to set
	 */
	public void setComposition(String composition) {
		this.composition = composition;
	}
	/**
	 * @return the effets
	 */
	public String getEffets() {
		return effets;
	}
	/**
	 * @param effets the effets to set
	 */
	public void setEffets(String effets) {
		this.effets = effets;
	}
	/**
	 * @return the contreIndication
	 */
	public String getContreIndication() {
		return contreIndication;
	}
	/**
	 * @param contreIndication the contreIndication to set
	 */
	public void setContreIndication(String contreIndication) {
		this.contreIndication = contreIndication;
	}
	/**
	 * @return the prixEchantillon
	 */
	public double getPrixEchantillon() {
		return prixEchantillon;
	}
	/**
	 * @param prixEchantillon the prixEchantillon to set
	 */
	public void setPrixEchantillon(double prixEchantillon) {
		this.prixEchantillon = prixEchantillon;
	}
	/**
	 * @return the codeFamille
	 */
	public String getCodeFamille() {
		return codeFamille;
	}
	/**
	 * @param codeFamille the codeFamille to set
	 */
	public void setCodeFamille(String codeFamille) {
		this.codeFamille = codeFamille;
	}
	/**
	 * @return the libellefamille
	 */
	public String getLibellefamille() {
		return libellefamille;
	}
	/**
	 * @param libellefamille the libellefamille to set
	 */
	public void setLibellefamille(String libellefamille) {
		this.libellefamille = libellefamille;
	}
	
	
}
