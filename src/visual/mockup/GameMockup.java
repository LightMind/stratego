package visual.mockup;

import java.util.HashMap;
import java.util.Map;

import framework.Answer;
import framework.Location;
import framework.Pieces;
import framework.Player;
import framework.Rule;
import framework.StrategoGame;
import framework.Terrain;
import framework.Unit;

public class GameMockup implements StrategoGame {

	private Map<Location, Unit> units = new HashMap<Location, Unit>();

	private Unit emptyUnit = new Unit() {

		@Override
		public Pieces getPiece() {
			return Pieces.Empty;
		}

		@Override
		public Player getOwner() {
			return Player.None;
		}
	};

	public GameMockup(){
		units.put(new Location(1,2), new Unit() {
			
			@Override
			public Pieces getPiece() {
				return Pieces.Major;
			}
			
			@Override
			public Player getOwner() {
				return Player.Red;
			}
		});
	}
	
	@Override
	public Unit getPieceAt(int column, int row) {
		Unit u = units.get(new Location(column, row));
		if (u == null) {
			return emptyUnit;
		}
		return u;
	}

	@Override
	public Answer move(int c1, int r1, int c2, int r2) {
		return new Answer(emptyUnit, false);
	}

	@Override
	public Player getPlayerInTurn() {
		return Player.Red;
	}

	@Override
	public boolean addRule(Rule x) {
		
		return false;
	}

	@Override
	public Terrain getTerrain(int column, int row) {
		if (column == 2 || column == 3 || column == 6 || column == 7) {
			if (row == 4 || row == 5) {
				return Terrain.WATER;
			}

		}
		return Terrain.PLAIN;
	}

}
