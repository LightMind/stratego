package basic;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import visual.GameVisualizer;
import visual.mockup.GameMockup;

import framework.StrategoGame;
import framework2.Drawable;


public class Test extends BasicGame {

	private Drawable visualizer; 
	private StrategoGame game;
	
	public Test(String title) {
		super(title);
		game = new GameMockup();
		visualizer = new GameVisualizer(game);
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		visualizer.draw(arg0, arg1);
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		visualizer.init(container);
		
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}



}