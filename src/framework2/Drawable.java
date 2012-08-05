package framework2;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface Drawable {
	
	public void init(GameContainer gc);
	public void draw(GameContainer gc, Graphics g);
}
