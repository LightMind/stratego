package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.SlickException;

import basic.Test;

public class Main{

	/**
	 * @param args
	 * @throws SlickException 
	 */
	public static void main(String[] args) throws SlickException {
		Game game = new Test("test");
		AppGameContainer gc = new AppGameContainer(game, 800, 600, false);
		gc.setTargetFrameRate(60);
		gc.setAlwaysRender(true);
		gc.setUpdateOnlyWhenVisible(false);
		gc.start();
		
	}
	
}
