/*
 * Crée 21 Décembre 2023
 */
package gsb.vue;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import gsb.modele.Localite;
import gsb.modele.Visiteur;
import gsb.modele.dao.LocaliteDao;
import gsb.service.VisiteurService;

/**
 * @author Théo DI PAULI
 * 21 Décembre 2023
 */
public class JIFVisiteurFiche extends JIFVisiteur implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton modifier;
	private JButton supprimer;

	public JIFVisiteurFiche(Visiteur unVisiteur) {
		super();
		this.remplirText(unVisiteur);
		
		modifier = new JButton("Modifier");
        pBoutons.add(modifier);
        modifier.addActionListener(this);
        
        supprimer = new JButton("Supprimer");
        pBoutons.add(supprimer);
        supprimer.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent evt) { 
		
	
		Object source = evt.getSource();
		if (source == modifier){
			
			String matricule = JTmatricule.getText();
            String nom = JTnom.getText();
            String prenom = JTprenom.getText();
            String login = JTlogin.getText();
            String mdp = JTmdp.getText();
            String adresse = JTadresse.getText();
            String codePostal = JTcodePostal.getText();
            String ville = JTville.getText();
            String dateEntreeString = JTdateEntree.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateEntree = null;

            try {
                dateEntree = dateFormat.parse(dateEntreeString);
            } catch (ParseException e) {
                e.printStackTrace();
                // Handle the exception as needed (show an error message, log, etc.)
            }
            
            java.sql.Date sqlDate = new java.sql.Date(dateEntree.getTime());
            
            int prime =0;
            if (JTprime.getValue() != null) {
                prime = (int) ((Number) JTprime.getValue()).doubleValue();
            }
            String codeUnite = JTcodeUnite.getText();
            String nomUnite = JTnomUnite.getText();
            Localite uneLoc = null;
            if (LocaliteDao.rechercher(codePostal) == null) {
            	uneLoc = new Localite(codePostal, ville);
            }
            else {
            	uneLoc = LocaliteDao.rechercher(codePostal);
            }
            Visiteur visiteur = new Visiteur(matricule, nom, prenom,login,mdp, adresse, uneLoc, "", sqlDate, prime, codeUnite, nomUnite);
            int result = VisiteurService.modifierVisiteur(matricule,visiteur);
            
            if (result != 0) {
                JOptionPane.showMessageDialog(this, "Visiteur modifié avec succès !");
            } else {
                JOptionPane.showMessageDialog(this, "Échec lors de la modification du visiteur");
            }
            // Videz les champs de texte après l'ajout
            
			
		}
		
		
		else if (source == supprimer) {
            int confirmation = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer ce visiteur ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                String matricule = JTmatricule.getText();
                int result = VisiteurService.supprimerVisiteur(matricule);

                if (result != 0) {
                    JOptionPane.showMessageDialog(this, "Visiteur supprimé avec succès !");
                    // Réinitialiser les champs de texte après la suppression
                    viderText();
                } else {
                    JOptionPane.showMessageDialog(this, "Échec lors de la suppression du Visiteur");
                }
            }
        }
	}
	

}
