package gsb.vue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Accueil extends JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;
    protected JPanel pImage;

    public Accueil() {
        p = new JPanel(new BorderLayout());  

        ImageIcon imageIcon = new ImageIcon("src/gsb/assets/logo-gsb.png");

        JLabel imageLabel = new JLabel(imageIcon);
        
        p.add(imageLabel, BorderLayout.CENTER);

        setContentPane(p);

        this.setTitle("Accueil");
        setSize(800, 600);
        this.setClosable(true);
        this.setResizable(true);
        this.setMaximizable(true);
        this.setIconifiable(true);
   
        
        

        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
}
