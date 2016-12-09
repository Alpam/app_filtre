package Widget;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import ToolsImg.*;
import Sobel.Sobel;

/**
 * Cette classe est hérité de Widget, il n'y a q'une WidgetMaster lancé simultanément
 * elle est la "maitresse" du programme dans le sens où sa fermeture terminera
 * programme.
 */

public class WidgetMaster extends Widget {

	/**
	 * m_filter est le menu filtre
	 */
	public JMenu m_filter = new JMenu("Filtre");
	/**
	 * i_open est le bouton open du menu déroulant file
	 */
	public JMenuItem i_open = new JMenuItem("Open");
	/**
	 * i_sobel est le bouton sobel du menu déroulant file
	 */
	public JMenuItem i_sobel = new JMenuItem("Sobel");
	/**
	 * i_gray est le bouton gray du menu déroulant file
	 */
	public JMenuItem i_gray = new JMenuItem("Gray");

	/**
	 * WidgetMaster est le constructeur de la fenêtre, sans image à charger
	 * @param title
	 *				 est le titre de la fenêtre
	 * @param width
	 *				 est la largeur de la fenêtre
	 * @param height
	 *				 est la hauteur de la fenêtre
	 */
	public WidgetMaster(String title, int width, int height){
		super(title,width,height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AddItem(m_file, i_open, new InListener());
		this.m_file.remove(0);
		this.m_file.add(i_save);
		AddItem(m_filter, i_sobel, new SobelListener());
		AddItem(m_filter, i_gray, new GrayListener());
		this.mbar.add(m_filter);
	}

	/**
	 * WidgetMaster est le constructeur par défaut
	 */
	public WidgetMaster(){
		this("AppSobel",200,100);
	}

	/**
	 * Action associer aux boutons, dont l'action sera la sauvegarde de l'image courante
	 */
	public class InListener extends IOListener implements ActionListener{
		/**
		 * Définit la procédure à suivre suite à une action de l'utilisateur
		 * @param arg0
		 *				clic gauche de la souri sur le bouton associé
		 */
		public void  actionPerformed(ActionEvent arg0){
			File file = getFile("Open File");
			if(file!=null){
				try{
					t_img = new ToolsImg(file);
					reSize();
				}catch (IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * Action associer au bouton, dont l'action sera l'application du filtre de Sobel à
	 * l'image courante dans une nouvelle fenêtre
	 */
	public class SobelListener implements ActionListener{
		/**
		 * Définit la procédure à suivre suite à une action de l'utilisateur
		 * @param arg0
		 *				clic gauche de la souri sur le bouton associé
		 */
		public void actionPerformed(ActionEvent arg0){
			if(t_img!=null){
				PxGray[][] s_img = Sobel.calcSobel(t_img.grayArray(),t_img.width,t_img.height);
				ToolsImg w_i = new ToolsImg(s_img,t_img.width,t_img.height);
				Widget w = new Widget(w_i,"Sobel");
			}
		}
	}

	/**
	 * Action associer aux boutons, dont l'action sera la cconversion en niveau de gris
	 * de l'image courante dans une nouvelle fenêtre
	 */
	public class GrayListener implements ActionListener{
		/**
		 * Définit la procédure à suivre suite à une action de l'utilisateur
		 * @param arg0
		 *				clic gauche de la souri sur le bouton associé
		 */
		public void actionPerformed(ActionEvent arg0){
			if(t_img!=null){
				ToolsImg w_i = new ToolsImg(t_img.grayArray(),t_img.width,t_img.height);
				Widget w = new Widget(w_i,"Gray");
			}
		}
	}

}
