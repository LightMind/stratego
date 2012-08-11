package framework2;

import java.io.Serializable;

public class Location implements Serializable{
	
	private static final long serialVersionUID = 4932049546920982277L;
	public final int row,column;
	public Location (int column, int row){
		this.row = row;
		this.column = column;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
	
}
