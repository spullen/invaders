package spullen.com.invaders.entity.mob;

import spullen.com.invaders.graphics.Screen;
import spullen.com.invaders.graphics.Sprite;
import spullen.com.invaders.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard input;
	
	public Player(int x, int y, Keyboard input) {
		super(x, y);
		this.input = input;
	}
	
	public Player(Keyboard input) {
		super();
		this.input = input;
	}

	public void update() {
		input.update();
		
		if(updates == Integer.MAX_VALUE) updates = 0;
		
		int xa = 0, ya = 0;
		
		if(input.up) ya--;
		if(input.down) ya++;
		if(input.left) xa--;
		if(input.right) xa++;
		
		if(xa != 0 || ya != 0) {
			move(xa, ya);
			moving = true;
		} else {
			moving = false;	
		}
		
		updates++;
	}

	public void render(Screen screen) {
		sprite = Sprite.enemy1_0;
		
		if(updates % 30 > 10 && moving) sprite = Sprite.enemy1_1;
		
		super.render(screen);
	}
}
