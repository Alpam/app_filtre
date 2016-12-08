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
		this.setContentPane(new Panel());
		this.setVisible(true);
	}
	public Widget(ToolsImg img,String title){
		this(title, img.width, img.height);
		t_img = img;

	}
	public Widget(){
			this("Sub:App-filter", 400, 100);
		}

	public void reSize(){
		this.setSize(t_img.width,t_img.height);
	}

	public class OutListener extends IOListener implements ActionListener{
		public void displayWarning(){
		JOptionPane info = new JOptionPane();
		info.showMessageDialog(null, "Add the extention: jpg, png or gif.\nNothing save !", "Information", JOptionPane.WARNING_MESSAGE);
		}

		public void actionPerformed(ActionEvent arg0) {
			File file = getFile("Save");
			String path = ""+file;
			String type = "";
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

	public class Panel extends JPanel{
		public void paintComponent(Graphics g){
			if(t_img != null){
				g.drawImage((Image)t_img.img,0,0,t_img.width,t_img.height,this);
			}
		}
	}
}

