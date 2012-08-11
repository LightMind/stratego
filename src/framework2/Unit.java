package framework2;

import java.io.Serializable;


public interface Unit extends Serializable{
	public PlayerColors getOwner();
	public UnitType getType();
}
