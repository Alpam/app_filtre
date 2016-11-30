import java.io.IOException;

public class test{
	public static void main(String[] args) throws IOException{
		ToolsImg img = new ToolsImg("t02.png");
		Pixel[][] result = img.buffToTbl();
		for (int row = 0; row < img.height; row++) {
			for (int col = 0; col < img.width; col++) {
				System.out.print(""+result[row][col]+"|");
			}
			System.out.println();
		}
	}
}
