
import java.awt.*;
import java.awt.Graphics.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

// Main game logic                        Interface
//                                        
class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener{
	private Timer timer;
	private int boxx = 0;
	private boolean []keys;
	private Font fnt;
	private Ball ball;
	private Paddle leftPlayer;
	private int score1=0, score2=0;
	private String screen = "game";
	private Image intro, player;
	

	public GamePanel(){
		setPreferredSize(new Dimension(800, 600));
		intro = Util.loadImage("intro.png");
		player = Util.loadImage("player.png");
		
		ball = new Ball();
		leftPlayer = new Paddle();

		fnt = new Font("Comic Sans MS", Font.PLAIN, 32);
			
		keys = new boolean[1000];
		
		timer = new Timer(20, this);
		timer.start();
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
		addMouseListener(this);
	}
	
	public void move(){
		//int ret = ball.move(leftPlayer);
		//if(ret == 1){
		//	score1++;
		//	ball = new Ball();
		//}
		//if(ret == 2){
		//	score2++;
		//	ball = new Ball();
		//}
		leftPlayer.move(keys);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(screen == "game"){		
			move();
		}
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		keys[e.getKeyCode()] = true;
	}
	@Override
	public void keyReleased(KeyEvent e){
		keys[e.getKeyCode()] = false;		
	}
	@Override
	public void keyTyped(KeyEvent e){}
	@Override
	public void	mouseClicked(MouseEvent e){}

	@Override
	public void	mouseEntered(MouseEvent e){}

	@Override
	public void	mouseExited(MouseEvent e){}
	
	@Override
	public void	mousePressed(MouseEvent e){
		int x = e.getX();
		int y = e.getY();
		Rectangle rec = new Rectangle(350, 400, 100, 40);
		if(rec.contains(x,y)){
			screen = "game";
		} 
	}
	
	@Override
	public void	mouseReleased(MouseEvent e){}


	@Override
	public void paint(Graphics g){
		if(screen == "intro"){
			g.drawImage(intro, 0,0,null);
			g.setColor(Color.RED);
			g.fillRect(350, 400, 100, 40);
		}
		if(screen == "game"){			
			g.setColor(Color.BLACK);
			g.fillRect(0,0,getWidth(),getHeight());
			
			//ball.draw(g);
			leftPlayer.draw((Graphics2D)g);
			g.setFont(fnt);
			g.drawString(""+score1, 100, 40);
			g.drawString(""+score2, 600, 40);
		}
    }
    
    public static void main(String[] arguments) {
		new Pong();
    }

}