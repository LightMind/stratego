package standard;

import java.util.HashMap;
import java.util.Map;

import framework2.EditableWorld;
import framework2.Location;
import framework2.PlayerColors;
import framework2.Terrain;
import framework2.Unit;
import framework2.UnitType;

public class StandardWorld implements EditableWorld {
	private static final long serialVersionUID = 4830074430535793806L;
	private Map<Location, Unit> units = new HashMap<Location, Unit>();
	private Map<Location, Terrain> terrain = new HashMap<Location, Terrain>();

	private Unit empty = new Unit() {
		@Override
		public UnitType getType() {
			return UnitType.Empty;
		}

		@Override
		public PlayerColors getOwner() {
			return PlayerColors.None;
		}
	};

	@Override
	public Unit getUnitAt(int column, int row) {
		return getUnitAt(new Location(column, row));
	}

	@Override
	public Unit getUnitAt(Location loc) {
		Unit unit = units.get(loc);
		if (unit == null) {
			unit = empty;
			units.put(loc, unit);
		}
		return unit;
	}

	@Override
	public Terrain getTerrain(int column, int row) {
		Terrain terra = this.terrain.get(new Location(column, row));
		if (terra == null) {
			terra = Terrain.PLAIN;
			terrain.put(new Location(column, row), terra);
		}
		return terra;
	}

	@Override
	public void placeUnit(int column, int row, Unit unit) {
		units.put(new Location(column, row), unit);
	}

	@Override
	public void setTerrain(int column, int row, Terrain terrain) {
		this.terrain.put(new Location(column, row), terrain);

	}

	@Override
	public Terrain getTerrain(Location location) {
		Terrain terra = this.terrain.get(location);
		if (terra == null) {
			terra = Terrain.PLAIN;
			terrain.put(location, terra);
		}
		return terra;
	}

	@Override
	public void placeUnit(Location location, Unit unit) {
		units.put(location, unit);
		
	}

	@Override
	public void setTerrain(Location location, Terrain terrain) {
		this.terrain.put(location, terrain);
		
	}

}
