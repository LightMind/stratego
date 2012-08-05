package framework;

import framework2.Unit;

public class Answer {
	public final Unit enemyPiece;
	public final boolean legalMove;
	
	public Answer (Unit p, boolean legal){
		enemyPiece = p;
		legalMove = legal;
	}
	
}
