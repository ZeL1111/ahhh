import java.awt.*;
import javax.swing.*;

class Ball{
	private int x, y, vx, vy;
	
	public Ball(){
		x = 400;
		y = 300;
		if(Util.randint(0,1)==0){
			vx = Util.randint(-5, -3);			
		}
		else{
			vx = Util.randint(3, 5);						
		}
		if(Util.randint(0,1)==0){
			vy = Util.randint(-5, -2);			
		}
		else{
			vy = Util.randint(2, 5);						
		}		
	} 
	
	// return 0 - no wall
	//        1 - left wall
	//        2 - right wall
	public int move(Paddle p1, Paddle p2){
		x += vx;
		y += vy;
		Rectangle rec = getPoly();
		Rectangle p1Rec = p1.getPoly();
		Rectangle p2Rec = p2.getPoly();
		
		if(rec.intersects(p1Rec) || rec.intersects(p2Rec)){
			vx *= -1;
		}
		if(x<0){			
			return 1;
		}
		if(x>800){			
			return 2;
		}
		if(y<0 || y>600){
			vy *= -1;
		}
		return 0;
	}
	
	public Rectangle getRect(){
		return new Rectangle(x,y,10,10);
	}
	
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.fillOval(x,y,10,10);
	}
}