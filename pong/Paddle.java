import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Paddle {
	private double ang;
	private double[] xpoints = {-50, -50, 50, 50};
	private double[] ypoints = {50, -50, -50, 50};
	private double centx = 0;
	private double centy = 0;
	private double speed = 0;
    public Paddle() {
    	ang = 90; 	
    }

	public void move(boolean []keys){
		double angchange = ang;
		if(keys[KeyEvent.VK_A]){
			ang += 10;
		}
		if(keys[KeyEvent.VK_D]){
			ang -= 10;
		}
		angchange = ang-angchange;
		double xs = Math.cos(Math.toRadians(angchange));
		double ys = Math.sin(Math.toRadians(angchange))*-1; 
		for(int i = 0; i < 4; i++){
			double tempx = xpoints[i] - centx;
			double tempy = ypoints[i] - centy;
			double tempx2 = tempx*xs - tempy*ys;
			tempy = tempy*xs + tempx*ys;
			xpoints[i] = tempx2 + centx;
			ypoints[i] = tempy + centy;
		}
		if(keys[KeyEvent.VK_W]){
			if(speed <= 7.5){
				speed += 1;
			}
		}
		xs = Math.cos(Math.toRadians(ang));
		ys = Math.sin(Math.toRadians(ang));
		for(int i = 0; i < 4; i++){
			xpoints[i] += xs*speed;
			ypoints[i] -= ys*speed;
		}
		centx += xs*speed;
		centy -= ys*speed;
		if(speed > 0){
			speed -= 0.1;
		}
	}	

	public double[][] getPoly(){
		double[][] pointsar = {xpoints, ypoints};
		return pointsar;
	}
	
	public void draw(Graphics2D g){
		g.setColor(Color.WHITE);
		int[] xints = new int[4];
		int[] yints = new int[4];
		for (int i = 0; i < 4; i++){
			xints[i] = (int)xpoints[i];
			yints[i] = (int)ypoints[i];
		}
		g.draw(new Polygon(xints, yints, 4));
	}    
    
}