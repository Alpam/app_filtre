public class Pixel{
	int rgb;

	public int convertRgbToGray(){
		int red = (rgb & 0x0000ff);
		int green = (rgb & 0x00ff00)/256;
		int blue = (rgb & 0xff0000)/(256*256);
		return 0;
	}

	public Pixel(int rgb){
		this.rgb = rgb;
	}
	public String toString(){
		return ""+( rgb & 0xffffff);
	}
}
