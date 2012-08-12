package framework2;

import java.io.Serializable;


public interface World extends Serializable{
	public Unit getUnitAt(int column, int row);
	public Unit getUnitAt(Location location);
	public Terrain getTerrain(int column, int row);
	public Terrain getTerrain(Location location);
	public String toString();
}
