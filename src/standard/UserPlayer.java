package standard;

import visual.GameVisualizer;
import framework2.Location;
import framework2.Player;
import framework2.Unit;
import framework2.World;

public class UserPlayer implements Player {
	
	private GameVisualizer visual;
	
	public UserPlayer(GameVisualizer visual){
		this.visual = visual;
	}

	@Override
	public Location placeUnit(Unit unit) {
		return null;
	}

	@Override
	public Location[] switchUnits() {
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
		return null;
	}

	

}
