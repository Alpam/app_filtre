import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class IOListener{
	public static File getFile(String message) {
		JFileChooser fileopen = new JFileChooser();
		FileFilter f1 = new FileNameExtensionFilter("*.png", "png");
		FileFilter f2 = new FileNameExtensionFilter("*.jpg", "jpg");
		FileFilter f3 = new FileNameExtensionFilter("*.gif", "gif");
		fileopen.addChoosableFileFilter(f1);
		fileopen.addChoosableFileFilter(f2);
		fileopen.addChoosableFileFilter(f3);
		int ret = fileopen.showDialog(null, message);
		File file = null;
		if (ret == JFileChooser.APPROVE_OPTION) {
			file = fileopen.getSelectedFile();
		}
		return file;
	}
}

