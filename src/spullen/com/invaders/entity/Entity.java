package spullen.com.invaders.entity;

public class Entity {
	protected int updates = 0;
	protected boolean removed = false;
	
	public void update() {
		updates++;
		if(updates == Integer.MAX_VALUE) updates = 0;
	}
}
