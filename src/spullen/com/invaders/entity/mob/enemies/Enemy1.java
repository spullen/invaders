package spullen.com.invaders.entity.mob.enemies;

import spullen.com.invaders.entity.mob.Enemy;
import spullen.com.invaders.graphics.Sprite;

public class Enemy1 extends Enemy {

	public Enemy1(int x, int y) {
		super(x, y);
		this.sprite = Sprite.enemy1_0;
	}
	
	public void update() {
		if(updates % 30 > 10) sprite = Sprite.enemy1_1;
		else sprite = Sprite.enemy1_0;

		super.update();
	}
}
