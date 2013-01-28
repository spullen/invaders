package spullen.com.invaders.graphics;

public class Sprite {
	
	public final int WIDTH;
	public final int HEIGHT;
	public int[] pixels;
	
	public static Sprite enemy1_0   = new Sprite(8, 0, 0, SpriteSheet.entities);
	public static Sprite enemy1_1	= new Sprite(8, 0, 8, SpriteSheet.entities);
	public static Sprite enemy2_0 	= new Sprite(12, 8, 8, 0, SpriteSheet.entities);
	public static Sprite enemy2_1	= new Sprite(12, 8, 8, 8, SpriteSheet.entities);
	public static Sprite enemy3_0	= new Sprite(11, 8, 24, 0, SpriteSheet.entities);
	public static Sprite enemy3_1	= new Sprite(11, 8, 24, 8, SpriteSheet.entities);
	public static Sprite mothership = new Sprite(16, 8, 40, 0, SpriteSheet.entities);
	public static Sprite player 	= new Sprite(11, 8, 56, 0, SpriteSheet.entities);
	public static Sprite playerMissile = new Sprite(1, 4, 64, 4, SpriteSheet.entities);
	
	public Sprite(int width, int height, int x, int y, SpriteSheet sheet) {
		WIDTH = width;
		HEIGHT = height;
		pixels = new int[WIDTH * HEIGHT];
		load(x, y, sheet);
	}
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		WIDTH = size;
		HEIGHT = size;
		pixels = new int[WIDTH * HEIGHT];
		load(x, y, sheet);
	}
	
	private void load(int xSheet, int ySheet, SpriteSheet sheet) {
		for(int y = 0; y < HEIGHT; y++) {
			for(int x = 0; x < WIDTH; x++) {
				pixels[x + y * WIDTH] = sheet.pixels[(x + xSheet) + (y + ySheet) * sheet.SIZE];
			}
		}
	}

}
