package visual;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import standard.Constants;

import framework.Drawable;
import framework.StrategoGame;
import framework.Terrain;


public class GameVisualizer implements Drawable {
	private StrategoGame game;
	private int width = Constants.WIDTH, height = Constants.HEIGHT;
	private int cellSize = 10;
	
	public GameVisualizer(StrategoGame sgame){
		game = sgame;
	}

	public void draw(GameContainer gc, Graphics g) {
		for(int row = 0; row < height; row++){
			for(int column = 0; column < width; column++){
				Terrain t = game.getTerrain(column, row);
				if(t.equals(Terrain.PLAIN)){
					g.setColor(Color.green);
				}
				else{
					g.setColor(Color.blue);
				}
				g.drawRect(column*cellSize, row*cellSize, cellSize, cellSize);
			}
		}
		
		for(int row = 0; row < height; row++){
			for(int column = 0; column < width; column++){
				
			}
		}
	}

}
