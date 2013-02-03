package spullen.com.invaders.entity.mob.enemies;

import spullen.com.invaders.entity.mob.Enemy;
import spullen.com.invaders.graphics.Sprite;

public class Enemy1 extends Enemy {

	public Enemy1(int x, int y) {
		super(x, y);
		this.sprite = Sprite.enemy1_0;
		System.out.println("Enemy1 - X:" + x + ", Y:" + y);
	}
	
	public void update() {
		super.update();
		
		if(!exploding) {
			if(updates % 40 > 15) sprite = Sprite.enemy1_1;
			else sprite = Sprite.enemy1_0;
		}
	}
}
