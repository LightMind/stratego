package framework;

public interface StrategoGame {
	public Pieces getPieceAt(int column, int row);
	public boolean move(int c1,int r1, int c2, int r2);
	public Player getPlayerInTurn();
}
