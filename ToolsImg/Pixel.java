package ToolsImg;

/**
 * Pixel est la classe repésentant les pixels comme des int RGB
 */

public class Pixel{
	

/**
 * rgb int représentant la valeur RGB du pixel.
 */
	public int rgb;

	/**
	 * Pixel est le constructeur.
	 * @param rgb
	 *				int représentant la valeur RGB.
	 */
	public Pixel(int rgb){
		this.rgb = rgb;
	}

	public String toString(){
		return ""+ (rgb);
	}
	
}
