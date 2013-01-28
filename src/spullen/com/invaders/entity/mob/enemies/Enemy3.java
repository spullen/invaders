package spullen.com.invaders.entity.mob.enemies;

import spullen.com.invaders.entity.mob.Enemy;
import spullen.com.invaders.graphics.Sprite;

public class Enemy3 extends Enemy {

	public Enemy3(int x, int y) {
		super(x, y);
		this.sprite = Sprite.enemy3_0;
	}

	public void update() {
		if(updates % 30 > 10) sprite = Sprite.enemy3_1;
		else sprite = Sprite.enemy3_0;

		super.update();
	}
}
