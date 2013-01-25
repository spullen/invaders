package spullen.com.invaders;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;

import javax.swing.JFrame;

import spullen.com.invaders.entity.mob.Enemy1;
import spullen.com.invaders.entity.mob.Player;
import spullen.com.invaders.entity.mob.PlayerMissile;
import spullen.com.invaders.graphics.Screen;
import spullen.com.invaders.graphics.Sprite;
import spullen.com.invaders.input.Keyboard;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static String title = "Invaders";
	
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	
	private Thread thread;
	private JFrame frame;
	private Screen screen;
	private Keyboard keyboard;
	private boolean running = false;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	private Player player;
	private Enemy1 enemy1 = new Enemy1();
	
	public static ArrayList<PlayerMissile> playerMissiles = new ArrayList<PlayerMissile>();
	
	public Game() {
	    Dimension size = new Dimension(width * scale, height * scale);
	    setPreferredSize(size);

	    frame = new JFrame();
	    screen = new Screen(width, height);
	    keyboard = new Keyboard();
	    
	    player = new Player((width / 2) - 5, (height - 24) - 4, keyboard);
	    
	    addKeyListener(keyboard);
	}
	
	public synchronized void start() {
		running = true;
	    thread = new Thread(this, "Display");
	    thread.start();
	}
	
	public synchronized void stop() {
	    running = false;
	    try {
	        thread.join();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	public synchronized void run() {
		double ns = 1000000000.0 / 60.0;
		double delta = 0;
		
		int frames = 0;
		int updates = 0;
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		
		requestFocus();
		
	    while (running) {
	    	long now = System.nanoTime();
	    	
	    	delta += (now - lastTime) / ns;
	    	lastTime = now;
	    	
	    	while(delta >= 1) {
	    		update();
	    		updates++;
	    		delta--;
	    	}
	    	
	        render();
	        frames++;
	        
	        if(System.currentTimeMillis() - timer >= 1000) {
	        	timer += 1000;
	        	frame.setTitle(title + "  |  " + updates + " ups, " + frames + " fps");
	        	frames = 0;
	        	updates = 0;
	        }
	    }
	    
	    stop();
	}
	
	private void update() {
		player.update();
		for(PlayerMissile missile : playerMissiles) {
			missile.update();
		}
		enemy1.update();
	}
	
	private void render() {
		BufferStrategy bs = getBufferStrategy();
	    if (bs == null) {
	        createBufferStrategy(3);
	        return;
	    }
	    
	    screen.clear();
	    
	    player.render(screen);
	    
	    for(PlayerMissile missile : playerMissiles) {
			missile.render(screen);
		}
	    
	    enemy1.setCoordinates(100, 50);
	    enemy1.render(screen);
	    
	    for(int i = 0; i < pixels.length; i++) {
	    	pixels[i] = screen.pixels[i];
	    }
	    
	    Graphics g = bs.getDrawGraphics();
	    g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	    g.dispose();
	    bs.show();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
	    game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
	    
	    game.start();
	}
}
