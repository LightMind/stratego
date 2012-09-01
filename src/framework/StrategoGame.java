package framework;

import framework2.Colors;
import framework2.Rule;
import framework2.Terrain;
import framework2.Unit;

public interface StrategoGame {
	public Unit getUnitAt(int column, int row);
	public Terrain getTerrain(int column, int row);
	public Answer move(int c1,int r1, int c2, int r2);
	public Colors getPlayerInTurn();
	public boolean addRule(Rule x);
}
