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


public class Widget extends JFrame {
	public ToolsImg t_img=null;
	public Panel pan=new Panel();
	public JMenuBar mbar = new JMenuBar();
	public JMenu m_file = new JMenu("File");
	public JMenuItem i_save = new JMenuItem("Save");
	public Widget(String title, int width, int height){
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		OutListener ol = new OutListener();
		i_save.addActionListener(ol);
		this.m_file.add(i_save);
		this.mbar.add(m_file);
		this.setJMenuBar(mbar);
		this.setVisible(true);
	}

	public Widget(){
			this("Sub:App-filter", 400, 100);
		}

	public class OutListener extends IOListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			File file = getFile();
			String path = ""+file;
			System.out.println(path);
			//t_img.save()
		}
	}

	public class Panel extends JPanel{
		public void paintComponent(Graphics g){
			if(t_img != null){
				g.drawImage((Image)t_img.img,0,0,t_img.width,t_img.height,this);
			}
		}
	}
}

