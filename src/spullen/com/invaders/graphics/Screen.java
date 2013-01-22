package spullen.com.invaders.graphics;

public class Screen {

	public int width, height;
	public int[] pixels;
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
	}
	
	public void clear() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void renderSprite(int xp, int yp, Sprite sprite) {
		for(int y = 0; y < sprite.HEIGHT; y++) {
			for(int x = 0; x < sprite.WIDTH; x++) {
				int pixelColor = sprite.pixels[x + y * sprite.WIDTH];
				if(pixelColor != 0xffff00ff) pixels[(x + xp) + (y + yp) * width] = pixelColor;
			}
		}
	}
}
