package gsb.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

/**
 * @author Enzo DANIGO
 * 21 Décembre 2023
 */

public class JIFMedicamentFiche extends JIFMedicament implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JButton modifier;
    private JButton supprimer;

    public JIFMedicamentFiche(Medicament unMedicament) {
        super();
        this.remplirText(unMedicament);

        modifier = new JButton("Modifier");
        pBoutons.add(modifier);
        modifier.addActionListener(this);

        supprimer = new JButton("Supprimer");
        pBoutons.add(supprimer);
        supprimer.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        if (source == modifier) {
            String depot = JTdepot.getText();
            String nom = JTnom.getText();
            String composition = JTcomposition.getText();
            String effets = JTeffets.getText();
            String contre = JTcontre.getText();
            String prixString = JTprix.getText();
            String code = JTcode.getText();
            String libelle = JTlibelle.getText();
            Double prix = null;

            try {
                prix = Double.parseDouble(prixString);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Gérer l'exception comme nécessaire (afficher un message d'erreur, journaliser, etc.)
            }

            Medicament Medicament = new Medicament(depot, nom, composition, effets, contre, prix, code, libelle);
            int result = MedicamentDao.modifier(depot, Medicament);

            if (result != 0) {
                JOptionPane.showMessageDialog(this, "Médicament modifié avec succès !");
            } else {
                JOptionPane.showMessageDialog(this, "Échec lors de la modification du médicament");
            }
            // Vider les champs de texte après l'édition
            viderText();

        } else if (source == supprimer) {
            int confirmation = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer ce médicament ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                String depot = JTdepot.getText();
                int result = MedicamentDao.supprimer(depot);

                if (result != 0) {
                    JOptionPane.showMessageDialog(this, "Médicament supprimé avec succès !");
                    // Réinitialiser les champs de texte après la suppression
                    viderText();
                } else {
                    JOptionPane.showMessageDialog(this, "Échec lors de la suppression du médicament");
                }
            }
        }
    }
}
