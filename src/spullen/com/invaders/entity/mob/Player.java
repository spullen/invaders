package spullen.com.invaders.entity.mob;

import spullen.com.invaders.Game;
import spullen.com.invaders.graphics.Sprite;
import spullen.com.invaders.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard input;
	
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
		
		if(input.space) {
			int missileStartX = x + (sprite.WIDTH / 2);
			int missileStartY = y;
			
			Game.playerMissiles.add(new PlayerMissile(missileStartX, missileStartY));
		}
		
		int xa = 0, ya = 0;
		
		if(input.left) xa--;
		if(input.right) xa++;
		
		if(xa != 0 || ya != 0) {
			move(xa, ya);
			moving = true;
		} else {
			moving = false;	
		}
		
		super.update();
	}
}
