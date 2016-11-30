public class Pixel{
	int rgb;
	int gray;

	public void convertRgbToGray(){
		int red = (rgb & 0x0000ff);
		int green = (rgb & 0x00ff00)/256;
		int blue = (rgb & 0xff0000)/(256*256);
	}

	public Pixel(int rgb){
		this.rgb = rgb;
	}
	public String toString(){
		return ""+( rgb & 0xffffff);
	}
}
