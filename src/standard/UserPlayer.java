package standard;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import visual.GameVisualizer;
import framework2.Drawable;
import framework2.GameState;
import framework2.Location;
import framework2.Player;
import framework2.Unit;
import framework2.Updateable;
import framework2.World;

import static standard.Constants.*;

public class UserPlayer implements Player, Updateable, Drawable {
	
	private GameVisualizer visual;
	private GameState state;
	
	private Location[] queue = new Location[1];
	
	private int x = 0,y = 0;
	
	public UserPlayer(GameVisualizer visual){
		this.visual = visual;
		state = GameState.UnitPlacement;
	}

	@Override
	public Location placeUnit(Unit unit) {
		return null;
	}

	@Override
	public Location[] switchUnits() {
		if(state.equals(GameState.UnitPlacement)){
			state = GameState.UnitSwitching;
			queue = new Location[2];
		}
		
		
		return null;
	}

	@Override
	public boolean endInitPhase() {
		return false;
	}

	@Override
	public void updateWorld(World world) {
		visual.setWorld(world);
	}

	@Override
	public Location[] getMove(World world) {
		state = GameState.GamePhase;
		return null;
	}

	@Override
	public void init(GameContainer gc) {
		
	}

	
	
	@Override
	public void draw(GameContainer gc, Graphics g) {
		g.setColor(Color.decode("#F87217"));
		g.drawRect(x * CELLSIZE, y * CELLSIZE, CELLSIZE, CELLSIZE);
		g.drawRect(x * CELLSIZE + 1, y * CELLSIZE + 1, CELLSIZE-2, CELLSIZE-2);
		
	}

	@Override
	public void update(GameContainer gc, int delta) {
		Input input = gc.getInput();
		
		if(input.isKeyPressed(Input.KEY_DOWN)){
			y++;
			if(y > HEIGHT-1){
				y = 0;
			}
		}
		if(input.isKeyPressed(Input.KEY_UP)){
			y--;
			if(y < 0){
				y = HEIGHT;
			}
		}
		if(input.isKeyPressed(Input.KEY_RIGHT)){
			x++;
			if(x > WIDTH-1){
				x = 0;
			}
		}
		if(input.isKeyPressed(Input.KEY_LEFT)){
			x--;
			if(x < 0){
				x = WIDTH;
			}
		}
	}

	

}
