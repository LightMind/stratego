package framework2;

public enum Terrain {
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
