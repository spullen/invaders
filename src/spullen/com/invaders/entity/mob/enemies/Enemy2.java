package spullen.com.invaders.entity.mob.enemies;

import spullen.com.invaders.entity.mob.Enemy;
import spullen.com.invaders.graphics.Sprite;

public class Enemy2 extends Enemy {

	public Enemy2(int x, int y) {
		super(x, y);
		this.sprite = Sprite.enemy2_0;
		System.out.println("Enemy2 - X:" + x + ", Y:" + y);
	}

	public void update() {
		super.update();
		
		if(!exploding) {
			if(updates % 40 > 15) sprite = Sprite.enemy2_1;
			else sprite = Sprite.enemy2_0;
		}
	}
}
