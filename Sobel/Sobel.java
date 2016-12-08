package Sobel;
import ToolsImg.*;
import java.lang.Math;

public class Sobel{
	public static PxGray[][] calcSobel(PxGray[][] tbl, int width, int height) {
		PxGray[][] output = new PxGray[height][width];
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
				int a = tbl[row+1][col-1].gray - tbl[row-1][col-1].gray;
				int b = tbl[row+1][col].gray - tbl[row-1][col].gray;
				int c = tbl[row+1][col+1].gray-tbl[row-1][col+1].gray;
				int gx = (a + 2 * b + c)/4;

				a = tbl[row-1][col+1].gray - tbl[row-1][col-1].gray;
				b = tbl[row][col+1].gray - tbl[row][col-1].gray;
				c = tbl[row+1][col+1].gray - tbl[row+1][col-1].gray;
				int gy = (a + 2 * b + c)/4;

				int gn = (int) Math.sqrt(gx*gx + gy*gy);
				output[row][col] = new PxGray(gn*256*256+gn*256+gn-16777216);
				}
			}
	return output;
	}
}
