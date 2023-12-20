package gsb.vue;

import gsb.modele.Medicament;
import gsb.service.MedicamentService;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JIFMedicamentAjout extends JIFMedicament implements ActionListener {

    private static final long serialVersionUID = 1L;
	private JButton ajouter;
    private JButton annuler;

    public JIFMedicamentAjout(MenuPrincipal uneFenetreContainer) {
        super();

        ajouter = new JButton("Ajouter");
        pBoutons.add(ajouter);
        ajouter.addActionListener(this);

        annuler = new JButton("Annuler");
        pBoutons.add(annuler);
        annuler.addActionListener(this);

        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Ajout Médicament");
    }

    public void actionPerformed(ActionEvent evt) {
    	Object source = evt.getSource();
		if (source == ajouter){
			// Récupérez les valeurs des champs de texte
            String depot = JTdepot.getText();
            String nom = JTnom.getText();
            String composition = JTcomposition.getText();
            String effets = JTeffets.getText();
            String contre = JTcontre.getText();
            String prixString = JTprix.getText();
            String code = JTcode.getText();
            String libelle = JTlibelle.getText();
            if (depot.isEmpty() || nom.isEmpty() || composition.isEmpty() || effets.isEmpty() ||
                    contre.isEmpty() || prixString.isEmpty() || code.isEmpty() || libelle.isEmpty()) {
                    // Afficher un message indiquant les éléments importants à remplir
                    JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs obligatoires (*).",
                            "Champs obligatoires manquants (*)", JOptionPane.WARNING_MESSAGE);
                    return; // Ne pas continuer le traitement si des champs sont vides
                }

                double prix = 0.0; // Valeur par défaut pour le prix

                // Vérification si la chaîne de prix peut être convertie en double
                try {
                    prix = Double.parseDouble(prixString);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Le prix saisi n'est pas valide. Veuillez entrer un nombre décimal pour le prix.",
                            "Erreur de saisie du prix", JOptionPane.ERROR_MESSAGE);
                    return; // Arrêter le traitement si le prix n'est pas valide
                }


            // Créez un objet Visiteur avec ces valeurs
           
            
            Medicament medicament = new Medicament(depot, nom, composition,effets,contre, prix, code, libelle);

            int result;
            
            if ((MedicamentService.rechercherMedicament(medicament.getDepotLegal()) == null)) {
            	result = MedicamentService.creerMedicament(medicament);
            }
            else {
            	JOptionPane.showMessageDialog(null, "Le dépôt légal du médicament existe déjà.");
    		    
            	result = 0;
            	
            }
            
            // Appelez la fonction creer de VisiteurDao
            

            if (result != 0) {
                JOptionPane.showMessageDialog(this, "Médicament ajouté avec succès !");
                viderText();
            } else {
                JOptionPane.showMessageDialog(this, "Échec lors de l'ajout du médicament");
                
            }
            // Videz les champs de texte après l'ajout
            
		}
 }
}
