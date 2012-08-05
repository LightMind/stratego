package framework2;


public interface World {
	public Unit getUnitAt(int column, int row);
	public Unit getUnitAt(Location loc);
	public Terrain getTerrain(int column, int row);
}
