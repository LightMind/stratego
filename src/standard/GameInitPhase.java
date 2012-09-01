package standard;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import framework2.Drawable;
import framework2.EditableWorld;
import framework2.Location;
import framework2.Player;
import framework2.PlayerColors;
import framework2.Unit;
import framework2.UnitType;
import framework2.Updateable;
import framework2.World;

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

		makeUnitLists();

	}

	private void makeUnitLists() {
		for (UnitType type : UnitType.values()) {
			for (int i = 0; i < type.getAmount(); i++) {
				blueUnits.add(new StandardUnit(PlayerColors.Blue, type));
				redUnits.add(new StandardUnit(PlayerColors.Red, type));
			}
		}
		System.out.println("Unit list created");
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

	private void placeUnit(Unit unit, Location placement) {
		synchronized (world) {
			world.placeUnit(placement.column, placement.row, unit);
			if (unit.getOwner().equals(PlayerColors.Red)) {
				redworld.placeUnit(placement.column, placement.row, unit);
				blueworld.placeUnit(placement.column, placement.row,
						new StandardUnit(PlayerColors.Red, UnitType.Unknown));
				System.out.println("red updated");
			} else {
				redworld.placeUnit(placement.column, placement.row,
						new StandardUnit(PlayerColors.Blue, UnitType.Unknown));
				blueworld.placeUnit(placement.column, placement.row, unit);
				System.out.println("blue updated");
			}
		}

	}

	public EditableWorld[] getInitPlacementFromPlayers() {
		Runnable redRun = new Runnable() {
			@Override
			public void run() {
				for (Unit unit : redUnits) {
					red.updateWorld(redworld);
					Location placement = red.placeUnit(unit);
					while (!checkPlacement(placement, PlayerColors.Red)) {
						red.updateWorld(redworld);
						placement = red.placeUnit(unit);
					}
					placeUnit(unit, placement);
				}
			}
		};

		Runnable blueRun = new Runnable() {
			@Override
			public void run() {
				for (Unit unit : blueUnits) {
					blue.updateWorld(blueworld);
					Location placement = blue.placeUnit(unit);

					while (!checkPlacement(placement, PlayerColors.Blue)) {
						blue.updateWorld(blueworld);
						placement = blue.placeUnit(unit);
					}
					placeUnit(unit, placement);
				}
			}

		};

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

	private boolean checkPlacement(Location loc, PlayerColors owner) {
		if(world.getUnitAt(loc) == null){
			world.placeUnit(loc, new StandardUnit(PlayerColors.None, UnitType.Empty));
		}
		if (world.getUnitAt(loc).getType().equals(UnitType.Empty)) {

			if (owner.equals(PlayerColors.Blue)) {
				if (0 <= loc.column && loc.column < 10 && 0 <= loc.row
						&& loc.row < 4) {
					return true;
				}
			} else if (owner.equals(PlayerColors.Red)) {
				if (0 < loc.column && loc.column < 10 && 6 <= loc.row
						&& loc.row < 10) {
					return true;
				}
			}
		}
		return false;
	}

}
