import java.io.IOException;
import java.awt.image.BufferedImage;

public class test{
	public static void main(String[] args) throws IOException{
		if(args.length!=2){
			System.out.println("Usage : java test <In> <Out>");
			System.exit(0);
		}
		String in = args[0];
		String out = args[1];
		ToolsImg img = new ToolsImg(in);
		Pixel[][] r1 = img.rgbArray();
		Pixel[][] r2 = img.grayArray();
		for(Pixel px : r1[0]){
			System.out.print(px+"|");
		}
		System.out.println();
		for(Pixel px : r2[0]){
			System.out.print(px+"|");
		}
		System.out.println();
		ToolsImg s = new ToolsImg(r2,img.width,img.height);
		s.save(out,"PNG");
	}
	
}
