package standard;

import framework2.Colors;
import framework2.Unit;
import framework2.UnitType;

public class StandardUnit implements Unit {

	private static final long serialVersionUID = 141476643912769522L;
	private Colors owner;
	private UnitType type;
	
	public StandardUnit(Colors owner, UnitType type){
		this.owner = owner;
		this.type = type;
	}
	
	@Override
	public Colors getOwner() {
		return owner;
	}

	@Override
	public UnitType getType() {
		return type;
	}
	
	public String toString(){
		return "?";
	}

}
