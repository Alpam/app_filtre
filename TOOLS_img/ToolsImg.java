import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ToolsImg{
	/**
	 * Permet de manipuler une image sous forme de BufferedImage
	 * (https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html)
	 */
	BufferedImage img;
	BufferedImage gray;
	int width;
	int height;
	
	public ToolsImg(String file) throws IOException{
		/**
		 * charge une image via le chemin fournit avec file,
		 * pour l'instant uniquement GIF, PNG, JPEG
		 * @param file : chemin complet vers l'image
		 */
		File f = new File(file);
		img = ImageIO.read(f);
		width = img.getWidth();
		height = img.getHeight();
	}

	public void save(String path, String ext, BufferedImage tosave) throws IOException{
		/**
		 * sauve une image à path
		 * @param path : chemin complet vers l'image
		 * @param ext : l'extension (gif, png, jpeg)
		 * @param tosave : BufferedImage à sauver
		 */
		File f = new File(path);
		ImageIO.write(tosave,ext,f);
	}

	public Pixel[][] buffToTbl(){
		/**
		 * on transforme l'image en niveau de gris.
		 */
		Pixel[][] result = new Pixel[height][width];
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				result[row][col] = new Pixel(img.getRGB(col, row));
			}
		}
	return result;
	}


/*	public BufferedImage convertGrayTbltoIMG(int[] tbl){
		BufferedImage g_img = new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY);
		WritableRaster raster = g_img.getRaster();

//		raster.setDataElements(0,0, width, height, (byte[])tbl);
		g_img.setData(raster);
		return g_img;
	}*/
}
