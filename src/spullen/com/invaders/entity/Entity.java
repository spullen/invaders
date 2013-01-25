package spullen.com.invaders.entity;

public class Entity {
	protected int updates = 0;
	protected boolean removed = false;
	
	public boolean isRemoved() {
		return removed;
	}
	
	public void update() {
		updates++;
		if(updates == Integer.MAX_VALUE) updates = 0;
	}
}
