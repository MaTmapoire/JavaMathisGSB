package gsb.vue;

import java.awt.*;
import java.text.SimpleDateFormat;

import javax.swing.*;

import gsb.modele.Visiteur;

public class JIFVisiteur extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Panneaux de la fenêtre
	
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	
	// Labels pour les champs de saisie
	
	protected JLabel JLmatricule;
	protected JLabel JLnom;
	protected JLabel JLprenom;
	protected JLabel JLlogin;
	protected JLabel JLmdp;
	protected JLabel JLadresse;
	protected JLabel JLcodePostal;
	protected JLabel JLville;
	protected JLabel JLdateEntree;
	protected JLabel JLprime;
	protected JLabel JLcodeUnite;
	protected JLabel JLnomUnite;
	
	
	// Champs de saisie
	
	protected JTextField JTmatricule;
	protected JTextField JTnom;
	protected JTextField JTprenom;
	protected JTextField JTlogin;
	protected JTextField JTmdp;
	protected JTextField JTadresse;
	protected JTextField JTcodePostal;
	protected JTextField JTville;
	protected JTextField JTdateEntree;
	protected JFormattedTextField JTprime;
	protected JTextField JTcodeUnite;
	protected JTextField JTnomUnite;
	
	// Format de date pour afficher la date d'entrée
	
	protected SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	
	// Constructeur de la fenêtre interne
	
	public JIFVisiteur() {
		p = new JPanel();  // panneau principal de la fen�tre
		pBoutons = new JPanel();    // panneau supportant les boutons
		pTexte = new JPanel(new GridLayout(12,2));
        
		// Initialisation des labels
		
        JLmatricule = new JLabel("Matricule*");
        JLnom = new JLabel("Nom");
        JLprenom = new JLabel("Prénom");
        JLlogin = new JLabel("Identitifiant*");
        JLmdp = new JLabel("Mot de Passe*");
        JLadresse = new JLabel("Adresse");
        JLcodePostal = new JLabel("Code Postal*");
        JLville = new JLabel("Ville*");
        JLdateEntree = new JLabel("Date d'entrée (yyyy-MM-dd)");
        JLprime = new JLabel("prime");
        JLcodeUnite = new JLabel("Code Unité*");
        JLnomUnite = new JLabel("Nom Unité*");
        
     // Initialisation des champs de saisie
        
        JTmatricule = new JTextField(20);
        JTmatricule.setMaximumSize(JTmatricule.getPreferredSize());
        JTnom = new JTextField();
        JTprenom = new JTextField();
        JTlogin = new JTextField();
        JTmdp = new JTextField();
        JTadresse = new JTextField();
        JTcodePostal = new JTextField();
        JTville = new JTextField();
        JTdateEntree = new JTextField();
        JTprime = new JFormattedTextField();
        JTcodeUnite = new JTextField();
        JTnomUnite = new JTextField();
        
        
     // Ajout des labels et champs de saisie au panneau texte
        
        pTexte.add(JLmatricule);
        pTexte.add(JTmatricule);
        pTexte.add(JLnom);
        pTexte.add(JTnom);
        pTexte.add(JLprenom);
        pTexte.add(JTprenom);
        pTexte.add(JLlogin);
        pTexte.add(JTlogin);
        pTexte.add(JLmdp);
        pTexte.add(JTmdp);
        pTexte.add(JLadresse);
        pTexte.add(JTadresse);
        pTexte.add(JLcodePostal);
        pTexte.add(JTcodePostal);
        pTexte.add(JLville);
        pTexte.add(JTville);
        pTexte.add(JLdateEntree);
        pTexte.add(JTdateEntree);
        pTexte.add(JLprime);
        pTexte.add(JTprime);
        pTexte.add(JLcodeUnite);
        pTexte.add(JTcodeUnite);
        pTexte.add(JLnomUnite);
        pTexte.add(JTnomUnite);
        
     // Ajout des panneaux au panneau principal
        
        p.add(pTexte);
        p.add(pBoutons);
        p.add(pBoutons);
        
     // Ajout du panneau principal au contenu de la fenêtre interne
        Container contentPane = getContentPane();
        contentPane.add(p);
	}
        
        public void remplirText(Visiteur unVisiteur)
        
        {  // Méthode pour remplir les champs de saisie avec les données d'un visiteur
        	JTmatricule.setText(unVisiteur.getMatricule());        
            JTnom.setText(unVisiteur.getNom());
            JTprenom.setText(unVisiteur.getPrenom());
            JTadresse.setText(unVisiteur.getAdresse());
            JTlogin.setText(unVisiteur.getLogin());
            JTmdp.setText(unVisiteur.getMdp());
            JTcodePostal.setText(unVisiteur.getUneLocalite().getCodePostal());
            JTville.setText(unVisiteur.getUneLocalite().getVille());
            JTdateEntree.setText(dateFormatter.format(unVisiteur.getDateEntree()));
            JTprime.setValue(unVisiteur.getPrime());
            JTcodeUnite.setText(unVisiteur.getCodeUnite());
            JTnomUnite.setText(unVisiteur.getNomUnite());
         
        }
        

		public void viderText() { // Méthode pour vider les champs de saisie
        	JTmatricule.setText("");        
            JTnom.setText("");
            JTprenom.setText("");
            JTlogin.setText("");
            JTmdp.setText("");
            JTadresse.setText("");
            JTcodePostal.setText("");
            JTville.setText("");
            JTdateEntree.setText("");
            JTprime.setText("");
            JTcodeUnite.setText("");
            JTnomUnite.setText("");
        }

}
