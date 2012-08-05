package visual;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import standard.Constants;

import framework.Drawable;
import framework.Pieces;
import framework.Player;
import framework.StrategoGame;
import framework.Terrain;
import framework.Unit;


public class GameVisualizer implements Drawable {
	private StrategoGame game;
	private int width = Constants.WIDTH, height = Constants.HEIGHT;
	private int cellSize = 20;
	
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
					g.setColor(Color.decode("#151B8D"));
				}
				g.fillRect(column*cellSize, row*cellSize, cellSize, cellSize);
				
				g.setColor(Color.black);
				g.drawRect(column*cellSize, row*cellSize, cellSize, cellSize);
			}
		}
		
		for(int row = 0; row < height; row++){
			for(int column = 0; column < width; column++){
				Unit unit = game.getUnitAt(column, row);
				Player player = unit.getOwner();
				Pieces piece = unit.getPiece();
				
				g.setColor(player.getColor());
				
				g.drawString(piece, column*cellSize + 3, row*cellSize + 3);
				
				}
			}
		}
	}

}
