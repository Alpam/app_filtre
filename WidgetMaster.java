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

public class WidgetMaster extends Widget {

	public JMenu m_filter = new JMenu("Filtre");
	public JMenuItem i_open = new JMenuItem("Open");
	public JMenuItem i_sobel = new JMenuItem("Sobel");

	public WidgetMaster(String title, int width, int height){
		super(title,width,height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InListener il = new InListener();
		i_open.addActionListener(il);
		this.m_file.add(i_open);
		this.m_file.remove(0);
		this.m_file.add(i_save);
		SobelListener sl = new SobelListener();
		i_sobel.addActionListener(sl);
		this.m_filter.add(i_sobel);
		this.mbar.add(m_filter);
	}
	public WidgetMaster(){
		this("App-filter",200,100);
	}



	public class InListener extends IOListener implements ActionListener{
		public void  actionPerformed(ActionEvent arg0){
			File file = getFile("Open File");
			try{
				t_img = new ToolsImg(file);
				reSize();
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}

	public class SobelListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			PxGray[][] s_img = Sobel.calcSobel(t_img.grayArray(),t_img.width,t_img.height);
			ToolsImg w_i = new ToolsImg(s_img,t_img.width,t_img.height);
			Widget w = new Widget(w_i,"Sobel");
		}
	}
}
