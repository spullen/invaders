package spullen.com.invaders.formations;

import java.util.ArrayList;

import spullen.com.invaders.entity.mob.Enemy;
import spullen.com.invaders.graphics.Screen;

public class EnemyFormation {

	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	public void update() {
		
	}
	
	public void render(Screen screen) {
		for(Enemy enemy : enemies) {
			enemy.render(screen);
		}
	}
}
