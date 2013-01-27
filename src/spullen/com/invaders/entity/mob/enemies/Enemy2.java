package spullen.com.invaders.entity.mob.enemies;

import spullen.com.invaders.graphics.Sprite;

public class Enemy2 extends Enemy {

	public Enemy2(int x, int y) {
		super(x, y);
		this.sprite = Sprite.enemy2_0;
	}

	public void update() {
		if(updates % 30 > 10) sprite = Sprite.enemy2_1;
		else sprite = Sprite.enemy2_0;

		super.update();
	}
}
