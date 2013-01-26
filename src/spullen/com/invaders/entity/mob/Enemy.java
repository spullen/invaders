package spullen.com.invaders.entity.mob;

import spullen.com.invaders.graphics.Sprite;

public class Enemy extends Mob {
	
	public Enemy(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}
	
	public void update() {
		if(updates % 30 > 10) sprite = Sprite.enemy1_1;
		else sprite = Sprite.enemy1_0;
		
		super.update();
	}

}
