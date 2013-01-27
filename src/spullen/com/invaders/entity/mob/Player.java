package spullen.com.invaders.entity.mob;

import spullen.com.invaders.Game;
import spullen.com.invaders.graphics.Sprite;
import spullen.com.invaders.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard input;
	private int fireCooldown = 0;
	
	public Player(int x, int y, Keyboard input) {
		super(x, y);
		this.input = input;
		this.sprite = Sprite.player;
	}
	
	public Player(Keyboard input) {
		super();
		this.input = input;
		this.sprite = Sprite.player;
	}

	public void update() {
		input.update();
		
		if(input.space && fireCooldown == 0) {
			int missileStartX = x + (sprite.WIDTH / 2);
			int missileStartY = y;
			
			Game.playerMissiles.add(new PlayerMissile(missileStartX, missileStartY));
			
			fireCooldown = 180;
		}
		if(fireCooldown > 0) fireCooldown--;
		
		int xa = 0, ya = 0;
		
		if(input.left) xa--;
		if(input.right) xa++;
		
		if(xa != 0 || ya != 0) {
			if((x + xa) >= 0 && (x + xa + sprite.WIDTH) <= Game.width) {
				move(xa, ya);
				moving = true;
			}
		} else {
			moving = false;	
		}
		
		super.update();
	}
}
