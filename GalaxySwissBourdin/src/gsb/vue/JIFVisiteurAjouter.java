package gsb.vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import gsb.modele.Localite;
import gsb.modele.Visiteur;
import gsb.modele.dao.*;
import gsb.service.VisiteurService;


public class JIFVisiteurAjouter extends JIFVisiteur implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton ajouter;
	
	public JIFVisiteurAjouter(MenuPrincipal uneFenetreContainer){
		
		ajouter = new JButton("Ajouter");
		customizeButton(ajouter);
        
		pBoutons.add(ajouter);
        ajouter.addActionListener(this);
        
        
        
		
	}
	
	private void customizeButton(JButton button) {
        button.setBackground(Color.decode("#123e6a"));
        button.setForeground(Color.white);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setFocusPainted(false);
    }


	
	 public void actionPerformed(ActionEvent evt) { 
			Object source = evt.getSource();
			if (source == ajouter){
				// Récupérez les valeurs des champs de texte
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
	            
	            if (matricule.isEmpty() || login.isEmpty() ||
	                    mdp.isEmpty() || codePostal.isEmpty() || ville.isEmpty()) {

	                    // Afficher un message indiquant les éléments importants à remplir
	                    JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs obligatoires.",
	                            "Champs obligatoires manquants (*)", JOptionPane.WARNING_MESSAGE);
	                    return; // Ne pas continuer le traitement si des champs sont vides
	                }

	            
	            if (!dateEntreeString.isEmpty()) {
	                try {
	                    dateEntree = dateFormat.parse(dateEntreeString);
	                } catch (ParseException e) {
	                    e.printStackTrace();
	                    // Handle the exception as needed (show an error message, log, etc.)
	                }
	            } else {
	                // Si la date d'entrée est vide, attribuez une date par défaut
	                dateEntree = new Date(); // Vous pouvez remplacer cela par la date par défaut souhaitée
	            }
	            
	            java.sql.Date sqlDate = new java.sql.Date(dateEntree.getTime());
	            
	            int prime =0;
	            if (JTprime.getValue() != null) {
	                prime = (int) ((Number) JTprime.getValue()).doubleValue();
	            }
	            String codeUnite = JTcodeUnite.getText();
	            String nomUnite = JTnomUnite.getText();

	            // Créez un objet Visiteur avec ces valeurs
	            Localite uneLoc = null;
	            if (LocaliteDao.rechercher(codePostal) == null) {
	            	uneLoc = new Localite(codePostal, ville);
	            	LocaliteDao.creer(uneLoc);
	            }
	            else {
	            	uneLoc = LocaliteDao.rechercher(codePostal);
	            }
	            
	            
	            Visiteur visiteur = new Visiteur(matricule, nom, prenom,login,mdp, adresse, uneLoc, "", sqlDate, prime, codeUnite, nomUnite);

	            int result;
	            
	            if ((VisiteurService.rechercherVisiteur(visiteur.getMatricule()) == null)) {
	            	result = VisiteurService.creerVisiteur(visiteur);
	            }
	            else {
	            	JOptionPane.showMessageDialog(this, "Le matricule du visiteur existe déjà.");
	            	result = 0;
	            }
	            
	            
	            

	            if (result != 0) {
	                JOptionPane.showMessageDialog(this, "Visiteur ajouté avec succès !");
	                viderText();
	            } else {
	                JOptionPane.showMessageDialog(this, "Échec lors de l'ajout du visiteur");
	                
	            }
	            // Videz les champs de texte après l'ajout
	            
			}
	 }
}
