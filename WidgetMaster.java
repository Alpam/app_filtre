import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ToolsImg.ToolsImg;
import java.io.IOException;

public class WidgetMaster extends Widget {

	public JMenu m_filter = new JMenu("Filter");
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
		this.m_filter.add(i_sobel);
		this.mbar.add(m_filter);
		this.setContentPane(new Panel());
	}
	public WidgetMaster(){
		this("App-filter",400,100);
	}

	public void reSize(){
		this.setSize(t_img.width,t_img.height);
	}

	public class InListener extends IOListener implements ActionListener{
		public void  actionPerformed(ActionEvent arg0){
			File file = getFile();
			try{
				t_img = new ToolsImg(file);
				reSize();
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}
