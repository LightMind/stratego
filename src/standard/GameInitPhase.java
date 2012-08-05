package standard;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import framework2.Drawable;
import framework2.EditableWorld;
import framework2.Player;
import framework2.Unit;
import framework2.Updateable;

public class GameInitPhase implements Drawable, Updateable{
	private Player red,blue;
	private EditableWorld world = new StandardWorld();
	private List<Unit> blueUnits = new ArrayList<Unit>();
	private List<Unit> redunits	 = new ArrayList<Unit>();
	
	
	public GameInitPhase(Player red, Player blue){
		this.red = red;
		this.blue = blue;
		
		
		
	}
	
	
	@Override
	public void init(GameContainer gc) {
		
	}
	@Override
	public void draw(GameContainer gc, Graphics g) {
		
	}
	@Override
	public void update(GameContainer gc, int delta) {
		
		
	}
	
	
}
