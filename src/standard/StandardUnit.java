package standard;

import framework2.PlayerColors;
import framework2.Unit;
import framework2.UnitType;

public class StandardUnit implements Unit {

	private static final long serialVersionUID = 141476643912769522L;
	private PlayerColors owner;
	private UnitType type;
	
	public StandardUnit(PlayerColors owner, UnitType type){
		this.owner = owner;
		this.type = type;
	}
	
	@Override
	public PlayerColors getOwner() {
		return owner;
	}

	@Override
	public UnitType getType() {
		return type;
	}

}
