package framework2;

import org.newdawn.slick.Color;

public enum PlayerColors {
	Red,Blue,None;
	
	public Color getColor(){
		switch(this){
		case Red: return Color.red;
		case Blue: return Color.blue;
		case None: return Color.white;
		}
		return Color.black;
	}
}
