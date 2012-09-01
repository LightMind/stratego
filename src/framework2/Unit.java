package framework2;

import java.io.Serializable;


public interface Unit extends Serializable{
	public Colors getOwner();
	public UnitType getType();
}
