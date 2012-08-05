package framework;

public class Answer {
	public final Pieces enemyPiece;
	public final boolean legalMove;
	
	public Answer (Pieces p, boolean legal){
		enemyPiece = p;
		legalMove = legal;
	}
	
}
