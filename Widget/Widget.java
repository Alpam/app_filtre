package Widget;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ToolsImg.ToolsImg;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.io.IOException;

/**
 * Cette classe permet l'affichage de fenêtres à l'écran, ainsi que leur gestion.
 */

public class Widget extends JFrame {
	/**
	 * t_img est l'image affichée dans cette fenêtre
	 */
	public ToolsImg t_img=null;
	/**
	 * pan est l'objet dans la fenêtre qui va permettre d'afficher l'iamge
	 */
	public Panel pan=new Panel();
	/**
	 * mbar est l'objet représentant la barre du menu
	 */
	public JMenuBar mbar = new JMenuBar();
	/**
	 * m_file est le menu file
	 */
	public JMenu m_file = new JMenu("File");
	/**
	 * i_save est le bouton save du menu déroulant file
	 */
	public JMenuItem i_save = new JMenuItem("Save");

	/**
	 * Widget est le constructeur de la fenêtre, sans image à charger
	 * @param title
	 *				 est le titre de la fenêtre
	 * @param width
	 *				 est la largeur de la fenêtre
	 * @param height
	 *				 est la hauteur de la fenêtre
	 */
	public Widget(String title, int width, int height){
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		AddItem(m_file, i_save, new OutListener());
		this.mbar.add(m_file);
		this.setJMenuBar(mbar);
		this.setContentPane(new Panel());
		this.setVisible(true);
	}

/**
 * Widget est le constructeur de la fenêtre, avec une image à charger
 * @param img
 *				est l'image à charger
 * @param title
 *				titre de l'image
 */
	public Widget(ToolsImg img,String title){
		this(title, img.width, img.height);
		t_img = img;
	}

	/**
	 * Ajoute un bouton au menu
	 * @param menu
	 *				menu à modifier
	 * @param newitem
	 *				le nouveau bouton à ajouter
	 * @param l
	 *				l'action qui est associé à ce bouton
	 */
	public void AddItem(JMenu menu, JMenuItem newitem, ActionListener l){
		newitem.addActionListener(l);
		menu.add(newitem);
	}

	/**
	 * Permet de redimensionner la taille de la fenêtre à la taille de l'image
	 */
	public void reSize(){
		this.setSize(t_img.width,t_img.height);
	}

	/**
	 * Action associer aux boutons, dont l'action sera la sauvegarde de l'image courante
	 */
	public class OutListener extends IOListener implements ActionListener{
		/**
		 * Afficher une boite de dialogue d'avertissement
		 */
		public void displayWarning(){
		JOptionPane info = new JOptionPane();
		info.showMessageDialog(null, "Add the extention: jpg, png or gif.\nNothing save !", "Information", JOptionPane.WARNING_MESSAGE);
		}
		/**
		 * Définit la procédure à suivre suite à une action de l'utilisateur
		 * @param arg0
		 *				clic gauche de la souri sur le bouton associé
		 */
		public void actionPerformed(ActionEvent arg0) {
			File file = getFile("Save");
			String path = ""+file;
			String type = "";
			//on vérifie la cohérance du chemin
			for(int i=path.length()-1;i>=0;i--){
				if(path.charAt(i)=='.'){
					break;
				}
				if(path.charAt(i)=='/'){
					displayWarning();
					return;
				}
				type = "" + path.charAt(i) + type;
			}
			//on vérifie que le type est correcte
			if(!(type.equals("png")  || type.equals("jpg") || type.equals("gif"))){
				displayWarning();
				return;
			}
			try{
			t_img.save(path,type);
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}

	/**
	 * Permet d'afficher l'image voulu
	 */
	public class Panel extends JPanel{
		/**
		 * Affiche l'image qui est sous la forme d'un Graphics
		 * @param g
		 *				représentation de t_img
		 */
		public void paintComponent(Graphics g){
			if(t_img != null){
				g.drawImage((Image)t_img.img,0,0,t_img.width,t_img.height,this);
			}
		}
	}
}

