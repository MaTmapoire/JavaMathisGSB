package gsb.vue;


import gsb.modele.Medicament;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class JIFMedicament extends JInternalFrame  {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	

	protected JLabel JLdepot;       
	protected JLabel JLnom;           
	protected JLabel JLcomposition;     
	protected JLabel JLeffets;        
	protected JLabel JLcontre;        
    protected JLabel JLprix;         
    protected JLabel JLcode;         
    protected JLabel JLlibelle;         
    
	protected JTextField JTdepot;      
	protected JTextField JTnom;        
	protected JTextField JTcomposition;
	protected JTextField JTeffets;     
	protected JTextField JTcontre;     
    protected JTextField JTprix;       
    protected JTextField JTcode;       
    protected JTextField JTlibelle;    
	
    public JIFMedicament() {
    	p = new JPanel();  // panneau principal de la fen�tre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(9,2));
    	
    	 JLdepot = new JLabel("Dépot *");
    	 JLdepot.setMaximumSize(JLdepot.getPreferredSize());
         JLnom = new JLabel("Nom *");
         JLcomposition = new JLabel("Coposition *");
         JLeffets = new JLabel("Effet *");
         JLcontre = new JLabel("Contre Indications *");
         JLprix = new JLabel("Prix *");
         JLcode = new JLabel("Code Famille *");
         JLlibelle = new JLabel("Libéllé Famille *");
         
         
         JTdepot = new JTextField(20);
         JTnom = new JTextField(20);
         JTcomposition = new JTextField(20);
         JTeffets = new JTextField(20);    
         JTcontre = new JTextField(20);
         JTprix = new JTextField(20);
         JTcode = new JTextField(20);
         JTlibelle = new JTextField(20);
         
         pTexte.add(JLdepot);
         pTexte.add(JTdepot);
         pTexte.add(JLnom);
         pTexte.add(JTnom);
         pTexte.add(JLcomposition);
         pTexte.add(JTcomposition);
         pTexte.add(JLeffets);
         pTexte.add(JTeffets);
         pTexte.add(JLcontre);
         pTexte.add(JTcontre);
         pTexte.add(JLprix);
         pTexte.add(JTprix);
         pTexte.add(JLcode);
         pTexte.add(JTcode);
         pTexte.add(JLlibelle);
         pTexte.add(JTlibelle);
		
        // mise en forme de la fen�tre

         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}
    
    public void remplirText(Medicament unMedicament) 	
    {  // m�thode qui permet de remplir les zones de texte � partir des valeurs pass�es en param�tres
        JTdepot.setText(unMedicament.getDepotLegal());        
        JTnom.setText(unMedicament.getNomCommercial());
        JTcomposition.setText(unMedicament.getComposition());
        JTeffets.setText(unMedicament.getEffets());    
        JTcontre.setText(unMedicament.getContreIndication());
        JTprix.setText(String.valueOf(unMedicament.getPrixEchantillon()));
        JTcode.setText(unMedicament.getCodeFamille());
        JTlibelle.setText(unMedicament.getLibellefamille());
     }
     
      public void viderText() 	
    {  // m�thode qui permet de vider les zones de texte 
    	  JTdepot.setText("");        
    	  JTnom.setText("");
    	  JTcomposition.setText("");
    	  JTeffets.setText("");    
    	  JTcontre.setText("");
    	  JTprix.setText("");
    	  JTcode.setText("");
    	  JTlibelle.setText("");
     }

     
      public static void main(String[] args) {

    	  SwingUtilities.invokeLater(() -> {

    	  new MenuPrincipal().setVisible(true);

    	  });
    
      }
}
