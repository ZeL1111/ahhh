/* Game0.java
 * This example uses two classes for the basic set-up. There are two reasons for this.
 * 	1. To fix the coordinate problem.
 *     If you draw on the JFrame, (0,0) if the top-left of the frame, above the title bar.
 *  2. Fix flickering
 *     JPanels implement what is called "double buffering." Without this your graphics 
 *     flicker when you draw images to the screen.
 **/
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Pong extends JFrame{
	GamePanel game;
		
    public Pong() {
		super("Basic Game Setup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game= new GamePanel();
		add(game);
		pack();  // set the size of my Frame exactly big enough to hold the contents
		setVisible(true);
    }    
    public static void main(String[] arguments) {
		new Pong();		
    }
}
