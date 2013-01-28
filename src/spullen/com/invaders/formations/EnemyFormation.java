package spullen.com.invaders.formations;

import spullen.com.invaders.entity.mob.Enemy;
import spullen.com.invaders.entity.mob.enemies.Enemy1;
import spullen.com.invaders.entity.mob.enemies.Enemy2;
import spullen.com.invaders.entity.mob.enemies.Enemy3;
import spullen.com.invaders.graphics.Screen;

public class EnemyFormation {

	// 5 rows of 11 enemies
	private Enemy[][] enemies = new Enemy[5][11];
		
	public EnemyFormation(int startingPointX, int startingPointY) {		
		// initialize the enemies
		for(int i = 0; i < enemies[0].length; i++) {
			enemies[0][i] = new Enemy1(startingPointX + 2 + (20 * i), startingPointY);
		}
		
		for(int i = 1; i < 3; i++) {
			for(int n = 0; n < enemies[i].length; n++) {
				enemies[i][n] = new Enemy2(startingPointX + (20 * n), startingPointY + (15 * i));
			}
		}
		
		for(int i = 3; i < 5; i++) {
			for(int n = 0; n < enemies[i].length; n++) {
				enemies[i][n] = new Enemy3(startingPointX + (20 * n), startingPointY + (15 * i));
			}
		}
	}
	
	public void update() {
		for(int x = 0; x < enemies.length; x++) {
			for(int y = 0; y < enemies[x].length; y++) {
				Enemy enemy = enemies[x][y];
				if(enemy != null && !enemy.isRemoved()) enemy.update();
			}
		}
	}
	
	public void render(Screen screen) {
		for(int x = 0; x < enemies.length; x++) {
			for(int y = 0; y < enemies[x].length; y++) {
				Enemy enemy = enemies[x][y];
				if(enemy != null && !enemy.isRemoved()) enemy.render(screen);
			}
		}
	}
}
