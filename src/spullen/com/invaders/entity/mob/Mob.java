package spullen.com.invaders.entity.mob;

import spullen.com.invaders.entity.Entity;
import spullen.com.invaders.graphics.Screen;
import spullen.com.invaders.graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected int x = 0, y = 0;
	protected Sprite sprite;
	protected int direction = 0;
	protected boolean moving = false;
	
	public Mob() {
	}
	
	public Mob(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Mob(int x, int y, Sprite sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public Mob(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void setCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public Sprite getSprite() {
		return this.sprite;
	}
	
	public void move(int xa, int ya) {
		if(xa > 0) direction = 1;
		if(xa < 0) direction = 3;
		if(ya > 0) direction = 2;
		if(ya < 0) direction = 0;

		x += xa;
		y += ya;
	}
	
	public void render(Screen screen) {
		if(sprite != null && !isRemoved()) screen.renderSprite(x, y, sprite);
	}
}
