package framework2;

public interface Player {
	/*
	 * Init phase
	 */
	public Location placeUnit(Unit unit);
	public Location[] switchUnits();
	public boolean endInitPhase();
	
	/*
	 * Main Game
	 */
	public void updateWorld(World world);
	public Location[] getMove(World world);
}
