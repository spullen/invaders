package spullen.com.invaders.entity.mob;

import spullen.com.invaders.Game;


public class Enemy extends Mob {

	protected boolean exploding = false;
	protected int explosionCooldown = 180;
	
	public Enemy(int x, int y) {
		super(x, y);
	}
	
	public void update() {
		checkForCollision();
		super.update();
	}
	
	private void checkForCollision() {
		int lowerLeftX  = x;
		int lowerRightX = x + sprite.WIDTH; 
		int lowerY = y + sprite.HEIGHT;
		
		for(PlayerMissile missile : Game.playerMissiles) {
			if(missile.y < lowerY && ((missile.x > lowerLeftX) || (missile.x < lowerRightX))) {
				int pixelX = missile.x - x;
				int pixelY = missile.y - y;
				int pixel = sprite.pixels[pixelX + pixelY * sprite.WIDTH];
				if(pixel != 0xffff00ff) {
					System.out.println("Hit!");
					Game.removedPlayerMissiles.add(missile);
					exploding = true;
				}
			}
		}
	}
}
