package visual;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

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
	private int cellSize = 40;
	private int textSize; 
	private UnicodeFont uFont;
	private int offsetTextX, offsetTextY;
	private int boxOffset, boxSize;
	
	public GameVisualizer(StrategoGame sgame){
		game = sgame;
		
		textSize = (cellSize*2)/3;
		offsetTextX = cellSize/3;
		offsetTextY = (cellSize - textSize)/2;
		boxOffset = cellSize/8;
		boxSize = (cellSize/4)-1;
	}
	
	
	@Override
	public void init(GameContainer gc) {
		
		java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.PLAIN, textSize);
		uFont = new UnicodeFont(font);
		uFont.addAsciiGlyphs();
		uFont.getEffects().add(new ColorEffect(java.awt.Color.white));
		try {
			uFont.loadGlyphs();
		} catch (SlickException e) {
			e.printStackTrace();
		}		
	}
	

	public void draw(GameContainer gc, Graphics g) {
		for(int row = 0; row < height; row++){
			for(int column = 0; column < width; column++){
				Terrain t = game.getTerrain(column, row);
				if(t.equals(Terrain.PLAIN)){
					g.setColor(Color.decode("#4AA02C"));
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
				
				if(!piece.equals(Pieces.Empty)){
					g.setColor(Color.white);
					g.fillRect(column*cellSize+boxOffset, row*cellSize+boxOffset,cellSize-boxSize, cellSize-boxSize);
				}
				
				g.setColor(player.getColor());
				
				g.setFont(uFont);
				
				g.drawString(piece.toString(), column*cellSize + offsetTextX, row*cellSize + offsetTextY);
				
				g.resetFont();
			}
		}
	}	

}
