package visual;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import standard.Constants;

import framework.Drawable;
import framework.StrategoGame;


public class GameVisualizer implements Drawable {
	private StrategoGame game;
	private int width = Constants.WIDTH, height = Constants.HEIGHT;
	private int cellSize = 10;
	
	public GameVisualizer(StrategoGame sgame){
		game = sgame;
	}

	@Override
	public void draw(GameContainer gc, Graphics g) {
		
	}

}
