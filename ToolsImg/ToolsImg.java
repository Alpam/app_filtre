package ToolsImg;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * ToolsImg est la classe permettant de manipuler une image
 * Elle permet de charger en mémoire une image existante sur le disque
 * ou d'en crée une à partir d'un tableau de pixel
 * Elle permet également de sauvegarder une image sur le disque
 * Les formats : jpg, gif et png sont supportés.
 */

public class ToolsImg{
	/**
	 * img est de type BufferedImage et permet de créer une iamge à partir d'un tableau 2D
	 * d'int ou d'en charger une dans la mémoire.
	 */
	public BufferedImage img;
	
	/**
	 * width est la largeur de l'image
	 */
	public int width;

	/**
	 * height est la hauteur de l'image
	 */
	public int height;
	
	
	/**
	 * ToolsImg est le constructeur
	 * @param tbl
	 *				tableau de pixel permettant de créer la BufferedImage
	 * @param width
	 *				la largeur de l'image
	 * @param height
	 *				la hauteur de l'image
	 */
	public ToolsImg(Pixel[][] tbl, int width, int height){
		this.width = width;
		this.height = height;
		img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				img.setRGB(col,row,tbl[row][col].rgb);
			}
		}
	}

	/**
	 * ToolsImg est le constructeur
	 * @param f
	 *				instance de type File qui représente un fichier
	 */
	public ToolsImg(File f) throws IOException{
		img = ImageIO.read(f);
		width = img.getWidth();
		height = img.getHeight();
	}

	/**
	 * ToolsImg est le constructeur
	 * @param file
	 *				chemin vers un fichier
	 */
	public ToolsImg(String file) throws IOException{
		/**
		 * charge une image via le chemin fournit avec file,
		 * pour l'instant uniquement GIF, PNG, JPEG
		 * @param file : chemin complet vers l'image
		 */
		this(new File(file));
	}

	/**
	 * permet de sauvegarder une image qui est en mémoire sous la forme d'une BufferedImage
	 * @param path
	 *				chemin complet du nouveau fichier
	 * @param ext
	 *				format de l'image
	 */
	public void save(String path, String ext) throws IOException{
		/**
		 * sauve une image à path
		 * @param path : chemin complet vers l'image
		 * @param ext : l'extension (gif, png, jpeg)
		 * @param tosave : BufferedImage à sauver
		 */
		File f = new File(path);
		ImageIO.write(img,ext,f);
	}

	/**
	 * permet de convertir une BufferedImage en un tableau 2D de pixel
	 * @return
	 *					un talbeau 2D de Pixel
	 */
	public Pixel[][] rgbArray(){
		Pixel[][] result = new Pixel[height][width];
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				result[row][col] = new Pixel(img.getRGB(col, row));
			}
		}
		return result;
	}

	/**
	 * permet de convertir une BufferedImage en un tableau 2D de pixel
	 * @return
	 *					un talbeau 2D de PxGray
	 */
	public PxGray[][] grayArray(){
		PxGray[][] result = new PxGray[height][width];
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				result[row][col] = new PxGray(img.getRGB(col, row));
			}
		}
		return result;
	}
}
