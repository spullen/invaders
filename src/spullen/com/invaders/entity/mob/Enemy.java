package spullen.com.invaders.entity.mob;

import spullen.com.invaders.Game;
import spullen.com.invaders.graphics.Sprite;


public abstract class Enemy extends Mob {

	protected boolean exploding = false;
	protected int explosionCooldown = 120;
	
	public Enemy(int x, int y) {
		super(x, y);
	}
	
	public void update() {
		super.update();
		
		if(exploding) {
			explosionCooldown--;
			
			if(explosionCooldown % 20 >= 10) sprite = Sprite.enemyExplosion1;
			else sprite = Sprite.enemyExplosion0;
		} else {
			checkForCollision();
		}
		
		if(explosionCooldown == 0) removed = true;
	}
	
	protected void checkForCollision() {
		int lowerLeftX  = x;
		int lowerRightX = x + sprite.WIDTH;
		int lowerY = y + sprite.HEIGHT;
		
		for(PlayerMissile missile : Game.playerMissiles) {
			if(missile.y < lowerY && missile.x >= lowerLeftX && missile.x <= lowerRightX) {
				System.out.println("X: " + x + ", Y: " + y);
				
				int pixelX = missile.x - x - 1;
				int pixelY = missile.y - y - 1;
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
