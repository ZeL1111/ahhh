import java.awt.*;
import javax.swing.*;

class Util{
	public static int randint(int a, int b){
		return (int)(Math.random()*(b-a+1) + a);
	}
	
	public static Image loadImage(String str){
		return  new ImageIcon(str).getImage();
	}	
}