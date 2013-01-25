package spullen.com.invaders.entity.mob;

import spullen.com.invaders.Game;
import spullen.com.invaders.graphics.Sprite;

public class PlayerMissile extends Mob {

	public PlayerMissile(int x, int y) {
		super(x, y);
		this.sprite = Sprite.playerMissile;
	}
	
	public void update() {
		if((y + this.sprite.HEIGHT + 1) < 0) Game.removedPlayerMissiles.add(this);
		if(updates % 5 == 0) move(0, -1);
		super.update();
	}
}
