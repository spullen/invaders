package spullen.com.invaders.entity;

public abstract class Entity {
	protected int updates = 0;
	protected boolean removed = false;
	
	public abstract void update();
}
