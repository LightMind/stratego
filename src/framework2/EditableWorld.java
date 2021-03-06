package framework2;

public interface EditableWorld extends World {
	public void placeUnit(int column, int row, Unit unit);
	public void placeUnit(Location location, Unit unit);
	public void setTerrain(int column, int row, Terrain terrain);
	public void setTerrain(Location location, Terrain terrain);
}
