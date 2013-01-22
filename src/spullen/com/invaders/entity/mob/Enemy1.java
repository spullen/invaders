package spullen.com.invaders.entity.mob;

import spullen.com.invaders.graphics.Sprite;

public class Enemy1 extends Mob {
	
	public Enemy1(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}
	
	public Enemy1(Sprite sprite) {
		super(sprite);
	}
	
	public Enemy1() {
		super();
	}
	
	public void update() {
		if(updates == Integer.MAX_VALUE) updates = 0;
		
		if(updates % 30 > 10) sprite = Sprite.enemy1_1;
		else sprite = Sprite.enemy1_0;
		
		updates++;
	}

}
