public class Pixel{
	int rgb;

	public int convertRgbToGray(){
		int red = (rgb & 0xff0000)/(256*256);
		int green = (rgb & 0x00ff00)/256;
		int blue = (rgb & 0x0000ff);
		int gray = (2126*red + 7152*green + 722*blue)/10000;
		System.out.println(""+gray);
		return 0;
	}

	public Pixel(int rgb){
		this.rgb = rgb;
	}
	public String toString(){
		return ""+( rgb & 0xffffff);
	}
}
