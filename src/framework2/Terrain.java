package framework2;

import java.io.Serializable;

public enum Terrain implements Serializable{
	WATER,PLAIN;
	
	public String toString(){
		switch (this) {
		case WATER:
			return "Water";
		case PLAIN:
			return "Plain";
		default:
			return " :( ";
		}
	}
}
