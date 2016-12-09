package Sobel;
import ToolsImg.*;
import java.lang.Math;

/**
	 * Applique le filtre de sobel sur une image représentée par un tableau 2D
	 * de niveau de gris.
	 */
public class Sobel{
	/**
	 * applique le filtre de Sobel
	 * @param tbl
	 *				est un tableau 2D de niveau de gris représentant une image
	 * @param width
	 *				largeur de l'image
	 * @param height
	 *				hauteur de l'image
	 * @return tableau 2D représentant l'image filtrée
	 */
	public static PxGray[][] calcSobel(PxGray[][] tbl, int width, int height) {
		PxGray[][] output = new PxGray[height][width];
		//lors de l'application du filtre on ignorera les 4 côtés de l'image (une
		//ligne de pixel par côtés, il faut donc initialisé "à la main" ces pixels.
		for (int row = 0; row < height; row++) {
			output[row][0]= new PxGray();
		}
		for (int row = 0; row < height; row++) {
			output[row][width-1]= new PxGray();
		}
		for (int col = 0; col < width; col++) {
			output[0][col]= new PxGray();
		}
		for (int col = 0; col < width; col++) {
			output[height-1][col]= new PxGray();
		}
		for (int row = 1; row < height - 1; row++) {
			for (int col = 1; col < width - 1; col++) {
				//les calcules passes par 3 variables pour simplifier l'écritures
				int a = tbl[row+1][col-1].gray - tbl[row-1][col-1].gray;
				int b = tbl[row+1][col].gray - tbl[row-1][col].gray;
				int c = tbl[row+1][col+1].gray-tbl[row-1][col+1].gray;
				int gx = (a + 2 * b + c)/4;

				a = tbl[row-1][col+1].gray - tbl[row-1][col-1].gray;
				b = tbl[row][col+1].gray - tbl[row][col-1].gray;
				c = tbl[row+1][col+1].gray - tbl[row+1][col-1].gray;
				int gy = (a + 2 * b + c)/4;

				int gn = (int) Math.sqrt(gx*gx + gy*gy);
				output[row][col] = new PxGray(PxGray.nGtoRgb(gn));
				}
			}
	return output;
	}
}
