package framework2;

import java.io.Serializable;

import org.newdawn.slick.GameContainer;

public interface Updateable extends Serializable{
	public void update(GameContainer gc, int delta);
}
