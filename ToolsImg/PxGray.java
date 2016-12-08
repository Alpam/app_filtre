package ToolsImg;
import java.lang.Byte;

public class PxGray extends Pixel{
	public int gray;

	public PxGray(int rgb){
		super(0);
		int red = (rgb & 0xff0000)/(256*256);
		int green = (rgb & 0x00ff00)/256;
		int blue = (rgb & 0x0000ff);
		gray = (2126*red + 7152*green + 722*blue)/10000;
		this.rgb = grayToRgb();
	}

	public PxGray(){
		this(-16777216);
	}

	public int grayToRgb(){
		return gray*256*256+gray*256+gray-16777216;
	}

	public String toString(){
		return super.toString()+"::"+gray;
	}
}
