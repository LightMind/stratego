package framework;

public interface StrategoGame {
	public Unit getPieceAt(int column, int row);
	public Terrain getTerrain(int column, int row);
	public Unit move(int c1,int r1, int c2, int r2);
	public Player getPlayerInTurn();
	public boolean addRule(Rule x);
}
