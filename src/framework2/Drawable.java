package framework2;

import java.io.Serializable;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface Drawable extends Serializable{
	
	public void init(GameContainer gc);
	public void draw(GameContainer gc, Graphics g);
}
