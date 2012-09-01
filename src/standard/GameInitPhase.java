package standard;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import framework2.Drawable;
import framework2.EditableWorld;
import framework2.Location;
import framework2.Player;
import framework2.Colors;
import framework2.Unit;
import framework2.UnitType;
import framework2.Updateable;

public class GameInitPhase implements Drawable, Updateable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6483370725944817445L;

	private final Player red, blue;

	private final EditableWorld world = new StandardWorld();
	private final EditableWorld redworld = new StandardWorld();
	private final EditableWorld blueworld = new StandardWorld();

	private final List<Unit> blueUnits = new ArrayList<Unit>();
	private final List<Unit> redUnits = new ArrayList<Unit>();

	public GameInitPhase(Player red, Player blue) {
		this.red = red;
		this.blue = blue;

		makeUnitLists(true);

	}

	private void makeUnitLists(Boolean test) {
		if(test){
			blueUnits.add(new StandardUnit(Colors.Blue, UnitType.Major));
			redUnits.add(new StandardUnit(Colors.Red, UnitType.Major));
			

			blueUnits.add(new StandardUnit(Colors.Blue, UnitType.Captain));
			redUnits.add(new StandardUnit(Colors.Red, UnitType.Captain));

			return;
		}
		for (UnitType type : UnitType.values()) {
			for (int i = 0; i < type.getAmount(); i++) {
				blueUnits.add(new StandardUnit(Colors.Blue, type));
				redUnits.add(new StandardUnit(Colors.Red, type));
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



	public EditableWorld[] getInitPlacementFromPlayers() {
		Runnable redRun = new InitPlacement(Colors.Red, red, redUnits, redworld, blue, blueworld);
		Runnable blueRun = new InitPlacement(Colors.Blue, blue, blueUnits, blueworld, red, redworld);

		Thread red = new Thread(redRun);
		Thread blue = new Thread(blueRun);
		red.start();
		blue.start();
		try {
			red.join();
			blue.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		EditableWorld[] result = { redworld, blueworld, world };
		return result;
	}


	
	
	private class InitPlacement implements Runnable{

		private Colors color;
		private Player player;
		private List<Unit> units;
		private EditableWorld world;
		private Player otherPlayer;
		private EditableWorld otherWorld;
		
		public InitPlacement(Colors color, Player player, List<Unit> units, EditableWorld world, 
				Player otherPlayer, EditableWorld otherWorld){
			this.color = color;
			this.player = player;
			this.units = units;
			this.world = world;
			this.otherPlayer = otherPlayer;
			this.otherWorld = otherWorld;
		}
		
		@Override
		public void run() {
			for (Unit unit : units) {
				player.updateWorld(world);
				Location placement = player.placeUnit(unit);

				while (!checkPlacement(placement, color, false)) {
					player.updateWorld(world);
					placement = player.placeUnit(unit);
				}
				placeUnit(unit, placement);
			}
			player.updateWorld(world);
			System.out.println("start switch unit phase");
			while(!player.endInitPhase()){
				System.out.println("ask player");
				Location[] locs = player.switchUnits();
				switchUnits(locs);
				player.updateWorld(world);
			}
			System.out.println("end switch unit phase");
		}
		
		private void switchUnits(Location[] locs) {
			synchronized (world) {
				if(!(checkPlacement(locs[0],color, true) && checkPlacement(locs[1],color, true))){
					return;
				}
				Unit u0 = world.getUnitAt(locs[0]);
				Unit u1 = world.getUnitAt(locs[1]);
				placeUnit(u0, locs[1]);
				placeUnit(u1, locs[0]);
			}
		}

		private void placeUnit(Unit unit, Location placement) {
			synchronized (world) {
				world.placeUnit(placement.column, placement.row, unit);
				if (unit.getOwner().equals(Colors.Red)) {
					redworld.placeUnit(placement.column, placement.row, unit);
				//	blueworld.placeUnit(placement.column, placement.row,
				//			new StandardUnit(Colors.Red, UnitType.Unknown));
				} else {
				//	redworld.placeUnit(placement.column, placement.row,
				//			new StandardUnit(Colors.Blue, UnitType.Unknown));
					blueworld.placeUnit(placement.column, placement.row, unit);
				}
			}

		}
		
		private boolean checkPlacement(Location loc, Colors owner, boolean ignoreEmpty) {
			if(world.getUnitAt(loc) == null){
				world.placeUnit(loc, new StandardUnit(Colors.None, UnitType.Empty));
			}
			if ((world.getUnitAt(loc).getType().equals(UnitType.Empty) || ignoreEmpty) && 0 <= loc.column && loc.column < 10 ) {
				return (owner.equals(Colors.Blue) && 0 <= loc.row && loc.row < 4) ||
						(owner.equals(Colors.Red) && 6 <= loc.row && loc.row < 10);
			}
			return false;
		}
		
	}

}
