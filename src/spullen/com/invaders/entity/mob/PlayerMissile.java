package spullen.com.invaders.entity.mob;

import spullen.com.invaders.graphics.Sprite;

public class PlayerMissile extends Mob {

	public PlayerMissile(int x, int y) {
		super(x, y);
		this.sprite = Sprite.playerMissile;
	}
	
	public void update() {
		if(updates % 5 == 0) move(0, -1);
		
		if((y + this.sprite.HEIGHT) < 0) removed = true;
		
		super.update();
	}
}
