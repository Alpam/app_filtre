package ToolsImg;

/**
 * PxGray est la classe qui représente les niveaus de gris, elle hérite de Pixel.
 */

public class PxGray extends Pixel{

	/**
	 * gray représente le niveau de gris
	 */
	public int gray;

	/**
	 * permet de convertir un niveau de gris (0 à 255) en rgb
	 * @param gray
	 *				niveau de gris à convertir
	 */

	public static int nGtoRgb(int gray){
		return gray*256*256+gray*256+gray-16777216;
	}

	/**
	 * PxGray(int) est un constructeur, il construit l'instance à partir du valeur rgb
	 * @param gray
	 *				représente le niveau de gris.
	 */
	public PxGray(int rgb){
		super(0);
		int red = (rgb & 0xff0000)/(256*256);
		int green = (rgb & 0x00ff00)/256;
		int blue = (rgb & 0x0000ff);
		gray = (2126*red + 7152*green + 722*blue)/10000;
		this.rgb = nGtoRgb(gray);
	}

	/**
	 * PxGray() est un constructeur, il initialise l'instance sur un pixel noir
	 */
	public PxGray(){
		this(-16777216);
	}

	public String toString(){
		return super.toString()+"::"+gray;
	}
}
