package visual.mockup;

import java.util.HashMap;
import java.util.Map;

import framework.Answer;
import framework.StrategoGame;
import framework2.Location;
import framework2.PlayerColors;
import framework2.Rule;
import framework2.Terrain;
import framework2.Unit;
import framework2.UnitType;

public class GameMockup implements StrategoGame {

	private Map<Location, Unit> units = new HashMap<Location, Unit>();

	private Unit emptyUnit = new Unit() {
		@Override
		public UnitType getType() {
			return UnitType.Empty;
		}
		@Override
		public PlayerColors getOwner() {
			return PlayerColors.None;
		}
	};

	public GameMockup(){
		units.put(new Location(1,2), new Unit() {
			@Override
			public UnitType getType() {
				return UnitType.Major;
			}
			
			@Override
			public PlayerColors getOwner() {
				return PlayerColors.Red;
			}
		});
	}
	
	@Override
	public Unit getUnitAt(int column, int row) {
		Unit u = units.get(new Location(column, row));
		if (u == null) {
			return emptyUnit;
		}
		return u;
	}

	@Override
	public Answer move(int c1, int r1, int c2, int r2) {
		return new Answer(emptyUnit, false);
	}

	@Override
	public PlayerColors getPlayerInTurn() {
		return PlayerColors.Red;
	}

	@Override
	public boolean addRule(Rule x) {
		
		return false;
	}

	@Override
	public Terrain getTerrain(int column, int row) {
		if (column == 2 || column == 3 || column == 6 || column == 7) {
			if (row == 4 || row == 5) {
				return Terrain.WATER;
			}

		}
		return Terrain.PLAIN;
	}

}
