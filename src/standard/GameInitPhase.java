package standard;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import framework2.Drawable;
import framework2.EditableWorld;
import framework2.Player;
import framework2.PlayerColors;
import framework2.Unit;
import framework2.UnitType;
import framework2.Updateable;

public class GameInitPhase implements Drawable, Updateable{
	private final Player red,blue;
	private final EditableWorld world = new StandardWorld();
	private final List<Unit> blueUnits = new ArrayList<Unit>();
	private final List<Unit> redUnits	 = new ArrayList<Unit>();
	
	
	public GameInitPhase(Player red, Player blue){
		this.red = red;
		this.blue = blue;
		
		makeUnitLists();
		
	}
	
	private void makeUnitLists(){
		for(UnitType type : UnitType.values()){
			for(int i = 0; i<type.getAmount(); i++){
				blueUnits.add(new StandardUnit(PlayerColors.Blue,type));
				redUnits.add(new StandardUnit(PlayerColors.Red,type));
			}
		}
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
	
	private void 
	
	
}
