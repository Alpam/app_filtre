package ToolsImg;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ToolsImg{
	/**
	 * Permet de manipuler une image sous forme de BufferedImage
	 * (https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html)
	 */
	public BufferedImage img;
	
	public int width;
	public int height;
	
	

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

	public ToolsImg(File f) throws IOException{
		img = ImageIO.read(f);
		width = img.getWidth();
		height = img.getHeight();
	}

	public ToolsImg(String file) throws IOException{
		/**
		 * charge une image via le chemin fournit avec file,
		 * pour l'instant uniquement GIF, PNG, JPEG
		 * @param file : chemin complet vers l'image
		 */
		this(new File(file));
	}

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

	public Pixel[][] rgbArray(){
		Pixel[][] result = new Pixel[height][width];
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				result[row][col] = new Pixel(img.getRGB(col, row));
			}
		}
		return result;
	}

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
