package standard;

import java.util.HashMap;
import java.util.Map;

import framework2.EditableWorld;
import framework2.Location;
import framework2.Colors;
import framework2.Terrain;
import framework2.Unit;
import framework2.UnitType;

public class StandardWorld implements EditableWorld {
	private static final long serialVersionUID = 4830074430535793806L;
	private HashMap<Location, Unit> units = new HashMap<Location, Unit>();
	private HashMap<Location, Terrain> terrain = new HashMap<Location, Terrain>();

	private Unit empty = new StandardUnit(Colors.None, UnitType.Empty);

	@Override
	public Unit getUnitAt(int column, int row) {
		return getUnitAt(new Location(column, row));
	}

	@Override
	public Unit getUnitAt(Location loc) {
		Unit unit = units.get(loc);
		/*if (unit == null) {
			unit = empty;
			units.put(loc, unit);
		}*/
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

	
	public String toString(){
		String result = "";
		for(Location k : units.keySet()){
			Unit t = units.get(k);
			System.out.println(t);
			System.out.println(t.getType().toString());
		}
		return result;
	}
}
